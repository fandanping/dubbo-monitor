package com.neusoft.neusipo.monitor.service.impl;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

public class TestFilter implements Filter {

	@Override
	public Result invoke(Invoker<?> invoker, Invocation invocation)
			throws RpcException {
		String serverName = "";   //从properties文件里取
		invoker.getUrl().addParameter(Constant.SERVER_NAME, serverName);
		return invoker.invoke(invocation);
		//Constants.CONSUMER_SIDE
	}

}
