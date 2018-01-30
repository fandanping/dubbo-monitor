package com.neusoft.neusipo.monitor.dao.impl;

import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;

import com.neusoft.neusipo.monitor.dao.InvokeMysqlManagerDao;
import com.neusoft.neusipo.monitor.domain.DubboInvoke;

/**
 * 
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-13 下午03:51:25
 */
public class InvokeMysqlManagerDaoImpl  implements InvokeMysqlManagerDao{

    private JdbcTemplate jdbctemplate;


	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}



	@Override
	public void insert(DubboInvoke dubboInvoke) {
		// TODO Auto-generated method stub
		final String  id=dubboInvoke.getId();
		final String application=dubboInvoke.getAppilcation();
		final Date invokeDate=dubboInvoke.getInvokeDate();
		final String sevice=dubboInvoke.getService();
		final String method=dubboInvoke.getMethod();
		final String consumer=dubboInvoke.getConsumer();
		final String provider=dubboInvoke.getProvider();
		final String type=dubboInvoke.getType();
		final String invokeTime=dubboInvoke.getInvokeTime();
		final double success=dubboInvoke.getSuccess();
		final double failure=dubboInvoke.getFailure();
		final double elapsed=dubboInvoke.getElapsed();
		final int concurrent=dubboInvoke.getConcurrent();
		final int maxElapsed=dubboInvoke.getMaxElapsed();
		final int maxConcurrent=dubboInvoke.getMaxConcurrent();
		
		String INVOKEDATE_INSERT="insert into dubbo_invoke(id,application,invoke_date,service,method,consumer,provider,type,invoke_time,success,failure,elapsed,concurrent,max_elapsed,max_concurrent) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    
      
		this.jdbctemplate.update(INVOKEDATE_INSERT, new Object[]{id,application,invokeDate,sevice,method,consumer,provider,type,invokeTime,success,failure,elapsed,concurrent,maxElapsed,maxConcurrent});
	
       
	}
  
}
