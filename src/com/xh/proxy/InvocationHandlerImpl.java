package com.xh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version 创建时间：2018-1-12 上午10:49:29 项目：proxy 包名：com.xh.proxy
 *          文件名：InvocationHandlerImpl.java 作者：lhl 说明:
 */

public class InvocationHandlerImpl implements InvocationHandler {
	private Object object;

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		if (object == null)
			return arg1.invoke(arg0, arg2);
		return arg1.invoke(object, arg2);
	}

}
