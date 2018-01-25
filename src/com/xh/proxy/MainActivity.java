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
	// Ĭ�����
	private ComponentName componentNameDefault;
	private ComponentName componentName2;
	private ComponentName componentName3;

	/**
	 * ���õ�icon2ͼ����Ч
	 */
	private void enableComponentName2() {
		disableComponent(componentNameDefault);
		disableComponent(componentName3);
		enableComponent(componentName2);
	}

	/**
	 * ���õ�icon3ͼ����Ч
	 */
	private void enableComponentName3() {
		disableComponent(componentNameDefault);
		disableComponent(componentName2);
		enableComponent(componentName3);
	}

	/**
	 * �������
	 * 
	 * @param componentName
	 *            �����
	 */
	private void enableComponent(ComponentName componentName) {
		// �˷����������úͽ���������Ḳ��Androidmanifest�ļ��¶��������
		mPackageManager.setComponentEnabledSetting(componentName,
				PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
				PackageManager.DONT_KILL_APP);
	}

	/**
	 * �������
	 * 
	 * @param componentName
	 *            �����
	 */
	private void disableComponent(ComponentName componentName) {
		mPackageManager.setComponentEnabledSetting(componentName,
				PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
				PackageManager.DONT_KILL_APP);
	}

	// ������
	public void pmTest() {
		// ��ȡ����������ʵ��
		mPackageManager = getPackageManager();
		// �õ���activity��ȫ�޶���
		componentNameDefault = getComponentName();
		// ����ȫ�޶�������һ���������activity-alias �ڵ��µ�name��HomeActivity2 ��Ӧ�����
		componentName2 = new ComponentName(getBaseContext(),
				"com.xh.proxy.MainActivity2");
		componentName3 = new ComponentName(getBaseContext(),
				"com.xh.proxy.MainActivity3");
		// if ("comp2".equals(action)) {
		// enableComponentName2();
		// } else if ("comp3".equals(action)) {
		enableComponentName3();
		// Intent ���� Launcher Ӧ��
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
		// ���û�У�����ʾĬ��ͼ��
	}
}
