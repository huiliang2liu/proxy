package com.xh.proxy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.proxy.R;

/**
 * @version ����ʱ�䣺2018-1-12 ����2:00:06 ��Ŀ��proxy ������com.xh.proxy
 *          �ļ�����TextPluginAcivity.java ���ߣ�lhl ˵��:
 */

public class TextPluginAcivity extends PluginActivity {
	@Override
	public void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		TextView view = (TextView) findViewById(R.id.text_view);
		view.setText("����");
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), MainActivity.class));
			}
		});
	}
}
