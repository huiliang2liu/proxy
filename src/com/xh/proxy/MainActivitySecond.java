package com.xh.proxy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.proxy.R;

public class MainActivitySecond extends Activity {
	private View text_view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.text_view).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivitySecond.this,
						ProxyActivity.class);
				intent.putExtra(Contants.CLASS_NAME,
						TextPluginAcivity.class.getName());
				try {
					startActivity(intent);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}


}
