package com.msdnplus.android;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener{
	
	Button btnStartAnotherActivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnStartAnotherActivity = (Button) findViewById(R.id.btnPassData);
		btnStartAnotherActivity.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view){
		
		// 1. create an intent pass class name or intent action name
		Intent intent = new Intent("com.msdnplus.android.ANOTHER_ACTIVITY");
		
		// 2. put key / value data
		intent.putExtra("message", "Hello from MainActivity");
		
		// 3. or you can add data to a bundle
		Bundle extras = new Bundle();
		extras.putString("status", "Data Received");
		
		// 4. add bundle to intent
		intent.putExtras(extras);
		
		// 5. start the activity
		this.startActivity(intent);
	}
} 