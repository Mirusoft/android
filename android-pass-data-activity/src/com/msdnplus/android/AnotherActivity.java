package com.msdnplus.android;


import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_another);
		
		// 1. get passed intent.
		Intent intent = this.getIntent();
		
		// 2. get message value from intent
		String message = intent.getStringExtra("message");
		
		// 3. show message on textView
		((TextView)findViewById(R.id.tvMessage)).setText(message);
		
		// 4. get bundle from intent.
		Bundle bundle = intent.getExtras();
		
		// 5. get status value from bundle
		String status = bundle.getString("status");
		
		// 6. show status on Toast.
		Toast toast = Toast.makeText(this, status, Toast.LENGTH_LONG);
		toast.show();
	}
}
