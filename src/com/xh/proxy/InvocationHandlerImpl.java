package com.xh.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version ����ʱ�䣺2018-1-12 ����10:49:29 ��Ŀ��proxy ������com.xh.proxy
 *          �ļ�����InvocationHandlerImpl.java ���ߣ�lhl ˵��:
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
