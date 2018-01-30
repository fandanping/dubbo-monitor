package com.neusoft.neusipo.monitor.utils;

import java.util.UUID;

/**
 * 
 * <p>[描述信息：uuid生成器工具类]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-13 下午03:29:24
 */
public class UuidUtil {

	
	 /**
     * 获得UUID的方法
     *
     * @return
     */
    public static String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获得系统时间戳
     *
     * @return
     */
    public static long createIDForLong() {
        return System.currentTimeMillis();
    }
}
