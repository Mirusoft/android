package com.msdnplus.android;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.IntentFilter;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends Activity implements OnClickListener{
	
	MyReceiver myReceiver;
	IntentFilter intentFilter;
	EditText etReceivedBroadcast;
	Button btnSendBroadcast;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etReceivedBroadcast = (EditText) findViewById(R.id.etReceivedBroadcast);
		btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);
		
		//MyApplication myApplication = (MyApplication) this.getApplicationContext();
		MyApplication myApplication = (MyApplication) this.getApplication();
		myApplication.mainActivity = this;
		
		btnSendBroadcast.setOnClickListener(this);
		
		myReceiver = new MyReceiver();
		intentFilter = new IntentFilter("com.msdnplus.android.USER_ACTION");
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		registerReceiver(myReceiver,intentFilter);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		unregisterReceiver(myReceiver);
	}
	
	@Override
	public void onClick(View view){
		Intent intent = new Intent("com.msdnplus.android.USER_ACTION");
		sendBroadcast(intent);
	}
	
	
	
	
	
	
} 