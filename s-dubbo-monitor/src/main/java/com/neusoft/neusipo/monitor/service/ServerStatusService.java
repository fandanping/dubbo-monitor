package com.neusoft.neusipo.monitor.service;

import com.neusoft.neusipo.monitor.domain.DubboStatistics;

/**
 * 
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-15 下午02:29:34
 */
public interface ServerStatusService {
	
    public  DubboStatistics getServerStatus(String ServiceName);
	
}
