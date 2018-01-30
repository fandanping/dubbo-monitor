package com.neusoft.neusipo.monitor.domain;

/**
 * 
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 范丹平
 * @mail fandp@neusoft.com
 * @version 1.0 Created on 2017-12-15 下午04:49:15
 */
public class DubboStatistics {
	   

	 //   private double consumerSuccess;

	    private double serviceSuccess;

	 //   private double consumerFailure;

	    private double serviceFailure;

	//    private double consumerAvgElapsed;

	    private double serviceAvgElapsed;

	//    private int consumerMaxElapsed;

	    private int serviceMaxElapsed;

	//    private int consumerMaxConcurrent;

	    private int serviceMaxConcurrent;

		public double getServiceSuccess() {
			return serviceSuccess;
		}

		public void setServiceSuccess(double serviceSuccess) {
			this.serviceSuccess = serviceSuccess;
		}

		public double getServiceFailure() {
			return serviceFailure;
		}

		public void setServiceFailure(double serviceFailure) {
			this.serviceFailure = serviceFailure;
		}

		public double getServiceAvgElapsed() {
			return serviceAvgElapsed;
		}

		public void setServiceAvgElapsed(double serviceAvgElapsed) {
			this.serviceAvgElapsed = serviceAvgElapsed;
		}

		public int getServiceMaxElapsed() {
			return serviceMaxElapsed;
		}

		public void setServiceMaxElapsed(int serviceMaxElapsed) {
			this.serviceMaxElapsed = serviceMaxElapsed;
		}

		public int getServiceMaxConcurrent() {
			return serviceMaxConcurrent;
		}

		public void setServiceMaxConcurrent(int serviceMaxConcurrent) {
			this.serviceMaxConcurrent = serviceMaxConcurrent;
		}
	    
	    
	    
	    
	    
	    
	    
}
