package com.xh.proxy;

import java.lang.reflect.Proxy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

/**
 * @version 创建时间：2018-1-12 上午10:21:32 项目：proxy 包名：com.xh.proxy
 *          文件名：TextActivity.java 作者：lhl 说明:
 */

public class ProxyActivity extends FragmentActivity {
	InvocationHandlerImpl impl;
	IPlugin proxy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		try {
			String className = getIntent().getStringExtra(Contants.CLASS_NAME);
			impl = new InvocationHandlerImpl();
			proxy = (IPlugin) Proxy.newProxyInstance(
					IPlugin.class.getClassLoader(),
					new Class[] { IPlugin.class }, impl);
			impl.setObject(Class.forName(className).newInstance());
			proxy.onCreate(this);
			proxy.onCreate(savedInstanceState);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		proxy.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		proxy.onBackPressed();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		proxy.onStart();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		proxy.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		proxy.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		proxy.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		proxy.onStop();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		proxy.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		proxy.onSaveInstanceState(outState);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		proxy.onNewIntent(intent);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		proxy.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		proxy.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		proxy.onKeyUp(keyCode, event);
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		proxy.onKeyDown(keyCode, event);
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		proxy.onLowMemory();
		super.onLowMemory();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		proxy.onMenuItemSelected(featureId, item);
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		proxy.onPanelClosed(featureId, menu);
		super.onPanelClosed(featureId, menu);
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		proxy.onPostResume();
		super.onPostResume();
	}

	@Override
	public boolean dispatchGenericMotionEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		proxy.dispatchGenericMotionEvent(ev);
		return super.dispatchGenericMotionEvent(ev);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		proxy.dispatchKeyEvent(event);
		return super.dispatchKeyEvent(event);
	}

	@Override
	public boolean dispatchKeyShortcutEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		proxy.dispatchKeyShortcutEvent(event);
		return super.dispatchKeyShortcutEvent(event);
	}

	@Override
	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		proxy.dispatchPopulateAccessibilityEvent(event);
		return super.dispatchPopulateAccessibilityEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		proxy.dispatchTouchEvent(ev);
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean dispatchTrackballEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		proxy.dispatchTrackballEvent(ev);
		return super.dispatchTrackballEvent(ev);
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		proxy.onAttachedToWindow();
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		super.onContentChanged();
		proxy.onContentChanged();
	}

	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		super.onDetachedFromWindow();
		proxy.onDetachedFromWindow();
	}

	@Override
	public boolean onGenericMotionEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		proxy.onGenericMotionEvent(event);
		return super.onGenericMotionEvent(event);
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		proxy.onKeyLongPress(keyCode, event);
		return super.onKeyLongPress(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO Auto-generated method stub
		proxy.onKeyMultiple(keyCode, repeatCount, event);
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@Override
	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		proxy.onKeyShortcut(keyCode, event);
		return super.onKeyShortcut(keyCode, event);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		proxy.onOptionsItemSelected(item);
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		super.onOptionsMenuClosed(menu);
		proxy.onOptionsMenuClosed(menu);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		proxy.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		// TODO Auto-generated method stub
		super.onTitleChanged(title, color);
		proxy.onTitleChanged(title, color);
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		proxy.onTrackballEvent(event);
		return super.onTrackballEvent(event);
	}

	@Override
	public void onTrimMemory(int level) {
		// TODO Auto-generated method stub
		super.onTrimMemory(level);
		proxy.onTrimMemory(level);
	}

	@Override
	public void onWindowAttributesChanged(LayoutParams params) {
		// TODO Auto-generated method stub
		super.onWindowAttributesChanged(params);
		proxy.onWindowAttributesChanged(params);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		proxy.onWindowFocusChanged(hasFocus);
	}
}
