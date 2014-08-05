package com.msdnplus.android;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.ListActivity;

public class MainActivity extends ListActivity{
		
	public void onCreate(Bundle icicle){
		super.onCreate(icicle);
		MyAdapter adapter = new MyAdapter(this,generateData());
		setListAdapter(adapter);
	}
	
	private ArrayList<Item> generateData(){
		ArrayList<Item> items = new ArrayList<Item>();
		
		items.add(new Item("Item 1","First Item on the list"));
		items.add(new Item("Item 2","Second Item on the list"));
		items.add(new Item("Item 3","Third Item on the list"));
		return items;
	}
}