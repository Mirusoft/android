package com.msdnplus.android;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;

public class MainActivity extends ListActivity{
	
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		
		MyAdapter adapter = new MyAdapter(this,generateData());
		
		setListAdapter(adapter);
	}
	
	private ArrayList<Model> generateData(){
		
		ArrayList<Model> models = new ArrayList<Model>();
		models.add(new Model("Group Title"));
		models.add(new Model(R.drawable.action_help_32,"Menu Item 1","1"));
		models.add(new Model(R.drawable.action_search_32,"Menu Item 2","2"));
		models.add(new Model(R.drawable.collections_cloud_32,"Menu Item 3","12"));
		
		return models;
	}
}