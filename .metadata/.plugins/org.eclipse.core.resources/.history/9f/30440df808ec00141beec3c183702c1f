package com.example.quizforkids;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CommentsDataSource {

	// Database fields
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
			MySQLiteHelper.COLUMN_COMMENT };//define the format of string allColumns

	public CommentsDataSource(Context context) {
		//instantiate the MySQLiteHelper class 
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		//open the database for reading and writing
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Comment createComment(String comment) {
		//instantiate the class ContentValues
		ContentValues values = new ContentValues();
		
		//initialise values to be inserted to the database
		values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
		
		//Returns a new InsertQuery object for the active database
		// insert(String table, String nullColumnHack, ContantValues values)
		long insertId = database.insert(MySQLiteHelper.TABLE_COMMENTS, null,
				values);
		
		//query returns a Cursor object
		Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
				allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		
		//pointing to first element in the cursor object
		cursor.moveToFirst();
		//Calling another method to go through the cursor and perform the logic of the method
		//may I remove cursor from the following of code?
		Comment newComment = cursorToComment(cursor);
		cursor.close();
		//Return the comment object to caller
		return newComment;
	}

	public void deleteComment(Comment comment) {
		long id = comment.getId();
		
		//printf(). should use log.w() instead
		System.out.println("Comment deleted with id: " + id);
		//delete records in the database
		database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Comment> getAllComments() {
		//instantiate List<Commnet>
		//can we change it to: List<Comment> comments = new ArrayList<Comment>(this);
		List<Comment> comments = new ArrayList<Comment>();

		Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENTS,
				allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Comment comment = cursorToComment(cursor);
			comments.add(comment);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return comments;
	}

	private Comment cursorToComment(Cursor cursor) {
		Comment comment = new Comment();
		comment.setId(cursor.getLong(0));
		//set the comment and return the column values as strings 
		comment.setComment(cursor.getString(1));
		return comment;
	}
}
