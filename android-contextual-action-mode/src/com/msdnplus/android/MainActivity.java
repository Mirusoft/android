package com.msdnplus.android;

import android.app.Activity;
import android.view.View;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.ActionMode;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.os.Bundle;


public class MainActivity extends Activity implements OnLongClickListener,ActionMode.Callback{
	
	EditText editTextCopy;
	
	ActionMode mActionMode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editTextCopy = (EditText) findViewById(R.id.editTextCopy);
		
		editTextCopy.setOnLongClickListener(this);
	}
	
	@Override
	public boolean onLongClick(View view){
		
		// if actionmode is null "not started"
		if(mActionMode != null){
			return false;
		}
		
		// Start the CAB
		mActionMode = this.startActionMode(this);
		view.setSelected(true);
		return true;
	}
	
	@Override
	public boolean onCreateActionMode(ActionMode mode,Menu menu){
		
		MenuInflater inflater = mode.getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onActionItemClicked(ActionMode mode,MenuItem item){
		switch(item.getItemId()){
		case R.id.action_share:
			Toast.makeText(this,"Shared!", Toast.LENGTH_SHORT).show();
			mode.finish();
			return true;
		default:
			return false;	
		}
	}
	
	@Override
	public boolean onPrepareActionMode(ActionMode mode,Menu menu){
		return false;
	}
	
	@Override
	public void onDestroyActionMode(ActionMode mode){
		mActionMode = null;
	}
	
	
	
	
	
}