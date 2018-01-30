package com.neusoft.neusipo.monitor.dao;

import com.neusoft.neusipo.monitor.domain.DubboInvoke;
import com.neusoft.neusipo.monitor.domain.DubboStatistics;

/**
 * 
 * <p>[描述信息：获取服务状态接口]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-15 下午02:11:00
 */
public interface ServerStatusDao {
    
	 public DubboStatistics getServerStatus(String ServiceName);
}
