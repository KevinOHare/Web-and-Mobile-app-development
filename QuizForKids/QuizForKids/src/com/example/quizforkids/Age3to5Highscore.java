package com.example.quizforkids;

import java.io.FileInputStream;
import com.example.quizforkids.R;
import com.example.quizforkids.MainActivity;
import com.example.quizforkids.Age3to5Results;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Class used to output age 3 to 5 highscore
 * @author Steven
 *
 */
public class Age3to5Highscore extends MainActivity {

	/**
	 * TextView instance for age3to5 level 1
	 */
	TextView age3to5Level1HighscoreTextView;
	
	/**
	 * TextView instance for age3to5 level 2
	 */
	TextView age3to5Level2HighscoreTextView;
	
	/**
	 * TextView instance for age3to5 level 3
	 */
	TextView age3to5Level3HighscoreTextView;

	/**
	 * On create method to populate the highscore page
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// get the super class states
		super.onCreate(savedInstanceState);
		// access layout of the xml needed
		setContentView(R.layout.activity_age3to5_highscore);

		// link TextView object to xml id
		age3to5Level1HighscoreTextView = (TextView) findViewById(R.id.Level1Highscore);
		// link TextView object to xml id
		age3to5Level2HighscoreTextView = (TextView) findViewById(R.id.Level2Highscore);
		// link TextView object to xml id
		age3to5Level3HighscoreTextView = (TextView) findViewById(R.id.Level3Highscore);
		
		// reads this levels saved high score and displays it
		try {
			// open file of highscores
			FileInputStream fin = openFileInput(Age3to5Results.age3to5Highscore1);
			// local variables
			int c;
			String temp = "";
			// read a character at a time 
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			// assign string to TextView
			age3to5Level1HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
		// reads this levels saved high score and displays it
		try {
			// open file of highscores
			FileInputStream fin = openFileInput(Age3to5Results.age3to5Highscore2);
			// local variables
			int c;
			String temp = "";
			// read a character at a time 
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			// assign string to TextView
			age3to5Level2HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
		// reads this levels saved high score and displays it
		try {
			// open file of highscores
			FileInputStream fin = openFileInput(Age3to5Results.age3to5Highscore3);
			// local variables
			int c;
			String temp = "";
			// read a character at a time 
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			// assign string to TextView
			age3to5Level3HighscoreTextView.setText(temp.toString());
		} catch (Exception e) {
		}
		
	}

}
