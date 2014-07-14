package com.msdnplus.android;

import android.app.Activity;
import android.os.Bundle;

import com.msdnplus.android.sqlite.MySQLiteHelper;
import com.msdnplus.android.model.Book;

import java.util.List;

public class MainActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MySQLiteHelper db = new MySQLiteHelper(this);
		
		db.addBook(new Book("Android Application Development-1","hong gil dong"));
		db.addBook(new Book("Android Programming","Bill Gates"));
		db.addBook(new Book("Learn Android","Jacson"));
		
		List<Book> list = db.getAllBooks();
		
		db.deleteBook(list.get(0));
		
		db.getAllBooks();
	}
}