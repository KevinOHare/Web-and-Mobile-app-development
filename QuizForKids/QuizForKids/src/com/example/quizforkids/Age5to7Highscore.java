package com.example.quizforkids;

import java.io.FileInputStream;
import com.example.quizforkids.R;
import com.example.quizforkids.MainActivity;
import com.example.quizforkids.Age3to5Results;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Age5to7Highscore extends MainActivity {

	TextView age5to7Level1HighscoreTextView;
	TextView age5to7Level2HighscoreTextView;
	TextView age5to7Level3HighscoreTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_highscore);

		age5to7Level1HighscoreTextView = (TextView) findViewById(R.id.Level1Highscore);
		age5to7Level2HighscoreTextView = (TextView) findViewById(R.id.Level2Highscore);
		age5to7Level3HighscoreTextView = (TextView) findViewById(R.id.Level3Highscore);
		
		// reads this levels saved high score and displays it
		try {
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore1);
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age5to7Level1HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
		// reads this levels saved high score and displays it
		try {
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore2);
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age5to7Level2HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
		// reads this levels saved high score and displays it
		try {
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore3);
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age5to7Level3HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.highscore, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
