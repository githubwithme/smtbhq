package com.bhq.ui;

import android.app.Activity;
import android.os.Bundle;

import com.bhq.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.yijianfankui)
public class YiJianFanKui extends Activity
{
	@Click
	void btn_back()
	{
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().hide();
	}

	@Override
	protected void onChildTitleChanged(Activity childActivity, CharSequence title)
	{
		super.onChildTitleChanged(childActivity, title);
	}
}
