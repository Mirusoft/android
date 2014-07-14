package com.msdnplus.android.sqlite;

import com.msdnplus.android.model.Book;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;
import java.util.LinkedList;

public class MySQLiteHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION=1;
	
	private static final String DATABASE_NAME="BookDB";
	
	public MySQLiteHelper(Context context){
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		
		String CREATE_BOOK_TABLE = "CREATE TABLE books (id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT,author TEXT)";
		db.execSQL(CREATE_BOOK_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
		
		db.execSQL("DROP TABLE IF EXISTS books");
		this.onCreate(db);
	}
	
	private static final String TABLE_BOOKS = "books";
	private static final String KEY_ID = "id";
	private static final String KEY_TITLE = "title";
	private static final String KEY_AUTHOR = "author";
	
	private static final String[] COLUMNS = {KEY_ID,KEY_TITLE,KEY_AUTHOR};
	
	public void addBook(Book book){
		Log.d("addBook",book.toString());
		
		// 1. get reference to writable DB
		SQLiteDatabase db = this.getWritableDatabase();
		
		// 2. create ContentValues to add key "column/value"
		ContentValues values = new ContentValues();
		values.put(KEY_TITLE, book.getTitle());
		values.put(KEY_AUTHOR, book.getAuthor());
		
		// 3. insert
		db.insert(TABLE_BOOKS,null,values);
		
		// 4. close db
		db.close();
	}
	
	public Book getBook(int id){
		
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_BOOKS,
				COLUMNS,
				" id=?",
				new String[]{ String.valueOf(id)},
				null,
				null,
				null);
		
		if(cursor != null)
			cursor.moveToFirst();
		
		Book book = new Book();
		book.setId(Integer.parseInt(cursor.getString(0)));
		book.setTitle(cursor.getString(1));
		book.setAuthor(cursor.getString(2));
		
		Log.d("getBook(" + id + ")", book.toString());
		
		return book;
	}
	
	public List<Book> getAllBooks(){
		
		List<Book> books = new LinkedList<Book>();
		
		String query = "SELECT * FROM " + TABLE_BOOKS;
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query,null);
		
		Book book = null;
		if(cursor.moveToFirst()){
			do{
				book = new Book();
				book.setId(Integer.parseInt(cursor.getString(0)));
				book.setTitle(cursor.getString(1));
				book.setAuthor(cursor.getString(2));
				books.add(book);
			}while(cursor.moveToNext());
		}
		
		Log.d("getAllBooks()",books.toString());
		
		return books;
	}
	
	public int updateBook(Book book){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("title", book.getTitle());
		values.put("author", book.getAuthor());
		
		int i = db.update(TABLE_BOOKS,
				values,
				KEY_ID+" =?",
				new String[]{String.valueOf(book.getId())});
		
		db.close();
		return i;
	}
	
	public void deleteBook(Book book){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete(TABLE_BOOKS,
				KEY_ID +" =?",
				new String[]{String.valueOf(book.getId())});
		
		db.close();
		Log.d("deleteBook",book.toString());
	}
	
}








