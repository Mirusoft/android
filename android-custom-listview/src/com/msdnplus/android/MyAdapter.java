package com.msdnplus.android;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import com.msdnplus.android.Item;

public class MyAdapter extends ArrayAdapter<Item> {

	private final Context context;
	private final ArrayList<Item> itemsArrayList;
	
	public MyAdapter(Context context,ArrayList<Item> itemsArrayList){
		super(context,R.layout.row,itemsArrayList);
		this.context = context;
		this.itemsArrayList = itemsArrayList;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		
		// 1. create Inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		// 2. get rowView from inflater
		View rowView = inflater.inflate(R.layout.row, parent,false);
		
		// 3. Get the two text view from the rowView
		TextView labelView =(TextView) rowView.findViewById(R.id.label);
		TextView valueView =(TextView) rowView.findViewById(R.id.value);
		
		// 4. Set the text for textView
		labelView.setText(itemsArrayList.get(position).getTitle());
		valueView.setText(itemsArrayList.get(position).getDescription());
		
		return rowView;
	}
}
