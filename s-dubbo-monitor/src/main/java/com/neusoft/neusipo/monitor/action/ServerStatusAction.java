package com.neusoft.neusipo.monitor.action;

import com.neusoft.neusipo.monitor.domain.DubboStatistics;
import com.neusoft.neusipo.monitor.service.ServerStatusService;

/**
 * 
 * <p>[描述信息：获取服务状态]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-15 下午02:07:52
 */
public class ServerStatusAction {
	
	private ServerStatusService serviceStatusService;

	public void setServiceStatusService(ServerStatusService serviceStatusService) {
		this.serviceStatusService = serviceStatusService;
	}
	 
	private DubboStatistics dubboStatistics;
	
	/*public void setDubboStatistics(DubboStatistics dubboStatistics) {
		this.dubboStatistics = dubboStatistics;
	}*/
	
	
    
	public DubboStatistics getDubboStatistics() {
		return dubboStatistics;
	}

	String serverinterface="";
	
	
	
	public void setServerinterface(String serverinterface) {
		this.serverinterface = serverinterface;
	}

    
	public String getServerinterface() {
		return serverinterface;
	}


	/**
	 * 
	 * <p>[描述功能]</p>
	 * 
	 * @return: void
	 * @author: 范丹平
	 * @mail: fandp@neusoft.com
	 * @date: Created on 2017-12-15 下午05:16:25
	 */
	public String getServerStatus(){
		
		System.out.println("...................."+serverinterface);
		//this.dubboStatistics=serviceStatusService.getServerStatus("com.neusoft.neusipo.apis.search.bizservice.IShowStatisticInfoService");
		this.dubboStatistics=serviceStatusService.getServerStatus(serverinterface);

		System.out.println("平均耗时："+dubboStatistics.getServiceAvgElapsed());
		System.out.println("调用失败的次数"+dubboStatistics.getServiceFailure());
		System.out.println("服务最大并发数"+dubboStatistics.getServiceMaxConcurrent());
		System.out.println("服务最大调用耗时"+dubboStatistics.getServiceMaxElapsed());
		System.out.println("服务调用成功的次数"+dubboStatistics.getServiceSuccess());
	    
		return "jsonResult";
		
	}
	 
	

}
