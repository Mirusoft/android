package com.msdnplus.android;

public class Model {

	private int icon;
	private String title;
	private String counter;
	
	private boolean isGroupHeader = false;
	
	public Model(String title){
		this(-1,title,null);
		isGroupHeader = true;
	}
	
	public Model(int icon,String title,String counter){
		super();
		this.icon = icon;
		this.title = title;
		this.counter = counter;
	}
	
	public int getIcon(){
		return this.icon;
	}
	
	public void setIcon(int icon){
		this.icon = icon;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getCounter(){
		return this.counter;
	}
	
	public void setCounter(String counter){
		this.counter = counter;
	}
	
	public boolean isGroupHeader(){
		return this.isGroupHeader;
	}
	
	public void setGroupHeader(boolean isGroupHeader){
		this.isGroupHeader = isGroupHeader;
	}
}
