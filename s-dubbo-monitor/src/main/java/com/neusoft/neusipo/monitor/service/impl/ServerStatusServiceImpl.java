package com.neusoft.neusipo.monitor.service.impl;

import com.neusoft.neusipo.monitor.dao.ServerStatusDao;
import com.neusoft.neusipo.monitor.domain.DubboStatistics;
import com.neusoft.neusipo.monitor.service.ServerStatusService;
/**
 * 
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-15 下午02:32:10
 */
public class ServerStatusServiceImpl implements ServerStatusService {
    
	private ServerStatusDao serverStatusDao;
	
	public void setServerStatusDao(ServerStatusDao serverStatusDao) {
		this.serverStatusDao = serverStatusDao;
	}



	@Override
	public DubboStatistics getServerStatus(String ServiceName) {
		// TODO Auto-generated method stub
		return serverStatusDao.getServerStatus(ServiceName);
	}

}
