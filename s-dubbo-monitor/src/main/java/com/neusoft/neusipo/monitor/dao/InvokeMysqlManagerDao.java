package com.neusoft.neusipo.monitor.dao;

import com.neusoft.neusipo.monitor.domain.DubboInvoke;

/**
 * 
 * <p>[描述信息：对Mysql数据操作的增删改查接口]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-13 下午03:44:55
 */
public interface InvokeMysqlManagerDao {
   
	//插入
	public void insert(DubboInvoke object);
}
