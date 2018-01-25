package com.xh.proxy;

import android.app.Application;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * proxy com.xh.proxy 2018 2018-1-24 ����10:18:23 ˵���� author:������
 * email:825378291@qq.com
 **/

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	private void hideTest2() {
		PackageManager packageManager = getPackageManager();
		ComponentName componentName = new ComponentName(this,
				MainActivitySecond.class);
		int res = packageManager.getComponentEnabledSetting(componentName);
		if (res == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT
				|| res == PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {
			Log.e("hideTest2", "����");
			// ����Ӧ��ͼ��
			packageManager.setComponentEnabledSetting(componentName,
					PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
					PackageManager.DONT_KILL_APP);
		} else {
			// ��ʾӦ��ͼ��
			Log.e("hideTest2", "��ʾ");
			packageManager.setComponentEnabledSetting(componentName,
					PackageManager.COMPONENT_ENABLED_STATE_DEFAULT,
					PackageManager.DONT_KILL_APP);
		}
	}
}
