package com.xh.proxy;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.proxy.R;

public class MainActivity extends Activity {
	private View text_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.text_view).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						ProxyActivity.class);
				intent.putExtra(Contants.CLASS_NAME,
						TextPluginAcivity.class.getName());

				try {
					pmTest();
					startActivity(intent);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}

	private PackageManager mPackageManager;
	// 默认组件
	private ComponentName componentNameDefault;
	private ComponentName componentName2;
	private ComponentName componentName3;

	/**
	 * 设置第icon2图标生效
	 */
	private void enableComponentName2() {
		disableComponent(componentNameDefault);
		disableComponent(componentName3);
		enableComponent(componentName2);
	}

	/**
	 * 设置第icon3图标生效
	 */
	private void enableComponentName3() {
		disableComponent(componentNameDefault);
		disableComponent(componentName2);
		enableComponent(componentName3);
	}

	/**
	 * 启动组件
	 * 
	 * @param componentName
	 *            组件名
	 */
	private void enableComponent(ComponentName componentName) {
		// 此方法用以启用和禁用组件，会覆盖Androidmanifest文件下定义的属性
		mPackageManager.setComponentEnabledSetting(componentName,
				PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
				PackageManager.DONT_KILL_APP);
	}

	/**
	 * 禁用组件
	 * 
	 * @param componentName
	 *            组件名
	 */
	private void disableComponent(ComponentName componentName) {
		mPackageManager.setComponentEnabledSetting(componentName,
				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
				PackageManager.DONT_KILL_APP);
	}

	// 最后调用
	public void pmTest() {
		// 获取到包管理类实例
		mPackageManager = getPackageManager();
		// 得到此activity的全限定名
		componentNameDefault = getComponentName();
		// 根据全限定名创建一个组件，即activity-alias 节点下的name：HomeActivity2 对应的组件
		componentName2 = new ComponentName(getBaseContext(),
				"com.xh.proxy.MainActivity2");
		componentName3 = new ComponentName(getBaseContext(),
				"com.xh.proxy.MainActivity3");
		// if ("comp2".equals(action)) {
		// enableComponentName2();
		// } else if ("comp3".equals(action)) {
		enableComponentName3();
		// Intent 重启 Launcher 应用
//		Intent intent = new Intent(Intent.ACTION_MAIN);
//		intent.addCategory(Intent.CATEGORY_HOME);
//		intent.addCategory(Intent.CATEGORY_DEFAULT);
//		List<ResolveInfo> resolves = mPackageManager.queryIntentActivities(
//				intent, 0);
//		for (ResolveInfo res : resolves) {
//			if (res.activityInfo != null) {
//				ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//				am.killBackgroundProcesses(res.activityInfo.packageName);
//			}
//		}
		// }
		// 如果没有，则显示默认图标
	}
}
