package com.msdnplus.android;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	boolean canAddItem = false;
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		Toast toast;
		
		if(item.getItemId() == R.id.action_addItem){
			invalidateOptionsMenu();
		}else{
			toast = Toast.makeText(this, item.getTitle() + " Clicked!", Toast.LENGTH_SHORT);
			toast.show();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		
		if(canAddItem){
			menu.getItem(0).setIcon(R.drawable.ic_content_remove);
			MenuItem mi = menu.add("New Item");
			mi.setIcon(R.drawable.ic_location_web_site);
			mi.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_IF_ROOM);
			canAddItem = false;
		}else{
			menu.getItem(0).setIcon(R.drawable.ic_content_new);
			canAddItem = true;
		}
		
		return super.onPrepareOptionsMenu(menu);
	}
}