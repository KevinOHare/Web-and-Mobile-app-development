package com.example.quizforkids;

import java.io.FileInputStream;
import com.example.quizforkids.R;
import com.example.quizforkids.MainActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Class used to output the age 5 to 7 highscore
 * @author Steven
 *
 */
public class Age5to7Highscore extends MainActivity {

	/**
	 * TextView instance for age5to7 level 1
	 */
	TextView age5to7Level1HighscoreTextView;
	
	/**
	 * TextView instance for age5to7 level 2
	 */
	TextView age5to7Level2HighscoreTextView;
	
	/**
	 * TextView instance for age5to7 level 3
	 */
	TextView age5to7Level3HighscoreTextView;

	/**
	 * On create method to populate the highscore page
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// get the super class states
		super.onCreate(savedInstanceState);
		// access layout of the xml needed
		setContentView(R.layout.activity_age5to7_highscore);

		// link TextView object to xml id
		age5to7Level1HighscoreTextView = (TextView) findViewById(R.id.age5to7Level1Highscore);
		// link TextView object to xml id
		age5to7Level2HighscoreTextView = (TextView) findViewById(R.id.age5to7Level2Highscore);
		// link TextView object to xml id
		age5to7Level3HighscoreTextView = (TextView) findViewById(R.id.age5to7Level3Highscore);
		
		// reads this levels saved high score and displays it
		try {
			// open file of highscores
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore1);
			// local variables
			int c;
			String temp = "";
			// read a character at a time 
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			// assign string to TextView
			age5to7Level1HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
		// reads this levels saved high score and displays it
		try {
			// open file of highscores
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore2);
			// local variables
			int c;
			String temp = "";
			// read a character at a time 
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			// assign string to TextView
			age5to7Level2HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
		// reads this levels saved high score and displays it
		try {
			// open file of highscores
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore3);
			// local variables
			int c;
			String temp = "";
			// read a character at a time
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			// assign string to TextView
			age5to7Level3HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
	}
}
