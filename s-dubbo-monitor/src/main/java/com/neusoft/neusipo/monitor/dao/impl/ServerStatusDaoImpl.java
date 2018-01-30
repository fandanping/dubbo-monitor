package com.neusoft.neusipo.monitor.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.neusoft.neusipo.monitor.dao.ServerStatusDao;
import com.neusoft.neusipo.monitor.domain.DubboInvoke;
import com.neusoft.neusipo.monitor.domain.DubboStatistics;

/**
 * 
 * <p>[描述信息：获取服务状态的dao实现类]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-15 下午02:15:28
 */
public class ServerStatusDaoImpl implements ServerStatusDao {
	

    private JdbcTemplate jdbctemplate;


	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
    
	String COUNT_DUBBO_INVOKE_INFO="";
	public class ServerStatusRowMapper implements RowMapper<DubboStatistics>{
	   
	    public DubboStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	DubboStatistics dubboStatistics=new DubboStatistics();
	    	
	    	dubboStatistics.setServiceSuccess(rs.getDouble(1));
	    	dubboStatistics.setServiceFailure(rs.getDouble(2));
	    	dubboStatistics.setServiceAvgElapsed(rs.getDouble(3));
	    	dubboStatistics.setServiceMaxElapsed(rs.getInt(4));
	    	dubboStatistics.setServiceMaxConcurrent(rs.getInt(5));	    	
	    	return dubboStatistics;
	      
	    }
	}
	
	@Override
	public DubboStatistics getServerStatus(String ServiceName) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar bt = Calendar.getInstance();
		bt.add(Calendar.MINUTE, -5);// 5分钟之前的时间
		Date beforeD = bt.getTime();
		String beforeTime = sdf.format(beforeD);
		String nowTime = sdf.format(new Date());
		COUNT_DUBBO_INVOKE_INFO="select sum(success),sum(failure),sum(elapsed)/(sum(failure)+sum(success)),max(max_elapsed),max(max_concurrent)from dubbo_invoke where service=? and invoke_time>? and invoke_time<=?";
		DubboStatistics result = this.jdbctemplate.queryForObject(COUNT_DUBBO_INVOKE_INFO,new Object[]{ServiceName, beforeTime, nowTime},new ServerStatusRowMapper());
		return result;
	}
	
	public static void main(String args[]){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar beforeTime = Calendar.getInstance();
		beforeTime.add(Calendar.MINUTE, -5);// 5分钟之前的时间
		Date beforeD = beforeTime.getTime();
		String time = sdf.format(beforeD);
		System.out.println(time);
	}

}
