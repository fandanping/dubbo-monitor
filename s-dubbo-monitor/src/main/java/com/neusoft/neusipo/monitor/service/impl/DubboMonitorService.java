package com.neusoft.neusipo.monitor.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.utils.ConfigUtils;
import com.alibaba.dubbo.monitor.MonitorService;
import com.neusoft.neusipo.monitor.dao.InvokeMysqlManagerDao;
import com.neusoft.neusipo.monitor.domain.DubboInvoke;
import com.neusoft.neusipo.monitor.utils.UuidUtil;

/**
 * 
 * <p>[描述信息：Dubbo monito扩展---获取服务接口状态]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-13 下午02:15:54
 */
public class DubboMonitorService implements MonitorService{
     
	//BlockingQueue作为线程容器，可以为线程同步提供有力的保障。
	//queue.take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到Blocking有新的对象被加入为止
	//offer(anObject):表示如果可能的话,将anObject加到BlockingQueue里,即如果BlockingQueue可以容纳,则返回true,否则返回false.
	private BlockingQueue<URL> queue;
	private Thread writeThread;
	private volatile boolean running = true;
	private static final String POISON_PROTOCOL = "poison";
	
	
	private InvokeMysqlManagerDao invokeMysqlManagerDao;
	public void setInvokeMysqlManagerDao(InvokeMysqlManagerDao invokeMysqlManagerDao) {
		this.invokeMysqlManagerDao = invokeMysqlManagerDao;
	}

	
	public void init(){
		System.out.println("dubbo monitor service start init");
		  queue = new LinkedBlockingQueue<URL>(Integer.parseInt(ConfigUtils.getProperty("dubbo.monitor.queue", "100000")));
		  writeThread=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(running){
					try{
						saveInvoke(); //记录统计数据
					}catch(Throwable t){
						System.out.println("Unexpected error occur at write stat log, cause: "+t.getMessage());
					    try{
					    	  Thread.sleep(5000); // 失败延迟
					    }catch(Throwable t2){
					    	
					    }
					}
				}
			}
			  
		  });
		  writeThread.setDaemon(true);
	      writeThread.setName("S-DubboMonitorAsyncWriteLogThread");
	      writeThread.start();
	}
	
	/**
	 * 
	 * <p>[描述功能:dubbo调用信息数据写入Mysql//  目前先写入mysql ，后期考虑redis]</p>
	 * 
	 * @return: void
	 * @author: 范丹平
	 * @throws InterruptedException 
	 * @throws ParseException 
	 * @mail: fandp@neusoft.com
	 * @date: Created on 2017-12-13 下午02:49:59
	 */
	private void saveInvoke() throws InterruptedException, ParseException{
		if(queue.isEmpty()){
			return;
		}
		URL statistics =queue.take();
		if(POISON_PROTOCOL.equals(statistics.getProtocol())){
			return;
		}
		String timestamp = statistics.getParameter(Constants.TIMESTAMP_KEY);
		Date now;
		if (timestamp == null || timestamp.length() == 0) {
	            now = new Date();
	    } else if (timestamp.length() == "yyyyMMddHHmmss".length()) {
	            now = new SimpleDateFormat("yyyyMMddHHmmss").parse(timestamp);
	    } else {
	            now = new Date(Long.parseLong(timestamp));
	     }
		
		 DubboInvoke dubboInvoke = new DubboInvoke();
		 dubboInvoke.setId(UuidUtil.createUUID());
		 try {
	            if (statistics.hasParameter(PROVIDER)) {
	                dubboInvoke.setType(CONSUMER);
	                dubboInvoke.setConsumer(statistics.getHost());
	                dubboInvoke.setProvider(statistics.getParameter(PROVIDER));
	                int i = dubboInvoke.getProvider().indexOf(':');
	                if (i > 0) {
	                    dubboInvoke.setProvider(dubboInvoke.getProvider().substring(0, i));
	                }
	            } else {
	                dubboInvoke.setType(PROVIDER);
	                dubboInvoke.setConsumer(statistics.getParameter(CONSUMER));
	                int i = dubboInvoke.getConsumer().indexOf(':');
	                if (i > 0) {
	                    dubboInvoke.setConsumer(dubboInvoke.getConsumer().substring(0, i));
	                }
	                dubboInvoke.setProvider(statistics.getHost());
	            }
	            dubboInvoke.setInvokeDate(now);
	            dubboInvoke.setAppilcation(statistics.getParameter(Constants.APPLICATION_KEY));
	            System.out.println(statistics.getParameter(Constants.APPLICATION_KEY));
	            dubboInvoke.setService(statistics.getServiceInterface());
	            dubboInvoke.setMethod(statistics.getParameter(METHOD));
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            String nowTime = sdf.format(new Date());
	            dubboInvoke.setInvokeTime(nowTime);
	            dubboInvoke.setSuccess(statistics.getParameter(SUCCESS, 0));
	            dubboInvoke.setFailure(statistics.getParameter(FAILURE, 0));
	            dubboInvoke.setElapsed(statistics.getParameter(ELAPSED, 0));
	            dubboInvoke.setConcurrent(statistics.getParameter(CONCURRENT, 0));
	            dubboInvoke.setMaxElapsed(statistics.getParameter(MAX_ELAPSED, 0));
	            dubboInvoke.setMaxConcurrent(statistics.getParameter(MAX_CONCURRENT, 0));
	            if (dubboInvoke.getSuccess() == 0 && dubboInvoke.getFailure() == 0 && dubboInvoke.getElapsed() == 0
	                    && dubboInvoke.getConcurrent() == 0 && dubboInvoke.getMaxElapsed() == 0 && dubboInvoke.getMaxConcurrent() == 0) {
	                return;
	            }
	            //插入数据库
	           // dao.insert(CLASSNAME, "addDubboInvoke", dubboInvoke);
	            invokeMysqlManagerDao.insert(dubboInvoke);
     
	        } catch (Throwable t) {
	        	System.out.println("message---------------"+t.getMessage());
	        }
		 
		 
		 
		 
		 
	}
	@Override
	public void collect(URL statistics) {
		// TODO Auto-generated method stub
		 queue.offer(statistics);
		 System.out.println(new Date().toString());
		 System.out.println("................................................url:"+statistics);
	}

	@Override
	public List<URL> lookup(URL query) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
