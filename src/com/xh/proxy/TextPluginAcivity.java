package com.xh.proxy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.proxy.R;

/**
 * @version 创建时间：2018-1-12 下午2:00:06 项目：proxy 包名：com.xh.proxy
 *          文件名：TextPluginAcivity.java 作者：lhl 说明:
 */

public class TextPluginAcivity extends PluginActivity {
	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		TextView view = (TextView) findViewById(R.id.text_view);
		view.setText("测试");
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), MainActivity.class));
			}
		});
	}
}
