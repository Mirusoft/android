package com.msdnplus.android;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class AnotherActivity extends Activity {

	TextView tvPerson;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_another);
		
		Intent intent = this.getIntent();
		Person person = (Person) intent.getSerializableExtra("person");
		
		tvPerson =(TextView) this.findViewById(R.id.tvPerson);
		tvPerson.setText(person.toString());
	}
}
