package com.msdnplus.android;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity implements OnClickListener{
	
	Button btnPassObject;
	EditText etName,etAge;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnPassObject = (Button) this.findViewById(R.id.btnPassObject);
		etName = (EditText) this.findViewById(R.id.etName);
		etAge = (EditText) this.findViewById(R.id.etAge);
		
		btnPassObject.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View view){
		
		Intent intent = new Intent("com.msdnplus.android.ANOTHER_ACTIVITY");
		
		Person person = new Person();
		person.setName(etName.getText().toString());
		person.setAge(Integer.parseInt(etAge.getText().toString()));
		
		intent.putExtra("person", person);
		
		startActivity(intent);
	}
} 