package com.msdnplus.android;

import java.util.ArrayList;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

public class MyAdapter extends ArrayAdapter<Model> {

	private final Context context;
	private final ArrayList<Model> modelsArrayList;
	
	public MyAdapter(Context context,ArrayList<Model> modelsArrayList){
		super(context,R.layout.target_item,modelsArrayList);
		this.context = context;
		this.modelsArrayList = modelsArrayList;
	}
	
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = null;
		if(!modelsArrayList.get(position).isGroupHeader()){
			rowView = inflater.inflate(R.layout.target_item, parent,false);
			
			ImageView imgView = (ImageView) rowView.findViewById(R.id.item_icon);
			TextView titleView = (TextView) rowView.findViewById(R.id.item_title);
			TextView counterView = (TextView) rowView.findViewById(R.id.item_counter);
			
			imgView.setImageResource(modelsArrayList.get(position).getIcon());
			titleView.setText(modelsArrayList.get(position).getTitle());
			counterView.setText(modelsArrayList.get(position).getCounter());
		}else{
			rowView = inflater.inflate(R.layout.group_header_item,parent,false);
			TextView titleView = (TextView) rowView.findViewById(R.id.header);
			titleView.setText(modelsArrayList.get(position).getTitle());
		}
		
		return rowView;
	}
	
}
