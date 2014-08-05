package com.msdnplus.android;

public class Item {

	private String title;
	private String description;
	
	public Item(String title,String description){
		super();
		this.title = title;
		this.description = description;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
}
