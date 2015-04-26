package com.example.quizforkids;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	//initialise the table of the database
	public static final String TABLE_COMMENTS = "comments";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_COMMENT = "comment";

	private static final String DATABASE_NAME = "commments.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	//please remove the spaces in the code and see the results
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_COMMENTS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_COMMENT
			+ " text not null);";

	public MySQLiteHelper(Context context) {
		//please change 'context' to 'this' and see the result
		super(context, DATABASE_NAME, null, DATABASE_VERSION);//super class of creating database
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);//execute the table to create statements on the database
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//send a warn message: tag - source of the log message; msg - message to be logged
		//please try to remove some of the spaces and see the consequence
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);//execute a SQL statement
		onCreate(db);//create a database
	}

}
