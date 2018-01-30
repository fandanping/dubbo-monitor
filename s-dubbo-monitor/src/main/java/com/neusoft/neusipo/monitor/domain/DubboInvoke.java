package com.neusoft.neusipo.monitor.domain;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * <p>[描述信息：Dubbo Invoke Base Entity]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-13 下午03:08:55
 */
public class DubboInvoke {
    
	//唯一标识
	private String id;
	
	private String appilcation;
	//调用日期
	private Date invokeDate;
	//服务名
	private  String service;
	//方法名
	private String method;
	//消费者
	private String consumer;
	//提供者
	private String provider;
	//类型 ：提供者or消费者
	private String type;
	//成功调用次数
	private double success;
	//失败调用次数
	private double failure;
	//调用耗时时间
	private double elapsed;
	//并发数
	private int concurrent;
	//最大调用耗时
	private int maxElapsed;
	//最大并发数
	private int maxConcurrent;
	//调用时间
	private String invokeTime;
	// ====================查询辅助参数===================
    /**
     * 统计时间粒度(毫秒)
     */
    private long timeParticle = 60000;//1分钟
    private Date invokeDateFrom;
    private Date invokeDateTo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getInvokeDate() {
		return invokeDate;
	}
	public void setInvokeDate(Date invokeDate) {
		this.invokeDate = invokeDate;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getConsumer() {
		return consumer;
	}
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getType() {
		if (StringUtils.isEmpty(type)) {
	            return "provider";
	    }
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getSuccess() {
		return success;
	}
	public void setSuccess(double success) {
		this.success = success;
	}
	public double getFailure() {
		return failure;
	}
	public void setFailure(double failure) {
		this.failure = failure;
	}
	public double getElapsed() {
		return elapsed;
	}
	public void setElapsed(double elapsed) {
		this.elapsed = elapsed;
	}
	public int getConcurrent() {
		return concurrent;
	}
	public void setConcurrent(int concurrent) {
		this.concurrent = concurrent;
	}
	public int getMaxElapsed() {
		return maxElapsed;
	}
	public void setMaxElapsed(int maxElapsed) {
		this.maxElapsed = maxElapsed;
	}
	public int getMaxConcurrent() {
		return maxConcurrent;
	}
	public void setMaxConcurrent(int maxConcurrent) {
		this.maxConcurrent = maxConcurrent;
	}
	
	public long getTimeParticle() {
		return timeParticle;
	}
	public void setTimeParticle(long timeParticle) {
		this.timeParticle = timeParticle;
	}
	public Date getInvokeDateFrom() {
		return invokeDateFrom;
	}
	public void setInvokeDateFrom(Date invokeDateFrom) {
		this.invokeDateFrom = invokeDateFrom;
	}
	public Date getInvokeDateTo() {
		return invokeDateTo;
	}
	public void setInvokeDateTo(Date invokeDateTo) {
		this.invokeDateTo = invokeDateTo;
	}
	public String getInvokeTime() {
		return invokeTime;
	}
	public void setInvokeTime(String invokeTime) {
		this.invokeTime = invokeTime;
	}
	public String getAppilcation() {
		return appilcation;
	}
	public void setAppilcation(String appilcation) {
		this.appilcation = appilcation;
	}
     
	
    
    
	
	
}
