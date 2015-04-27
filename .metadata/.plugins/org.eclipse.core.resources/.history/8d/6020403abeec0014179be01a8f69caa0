package com.example.quizforkids;

// testing git connection

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.example.quizforkids.MainActivity;
import com.example.quizforkids.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Age3to5Results extends MainActivity {

	/**
	 * Image Button object to be used for the next arrow.
	 */
	static ImageButton btn;

	/**
	 * Instance variable for the number of correct answers.
	 */
	public static int age3to5numberCorrect = 0;

	/**
	 * Instance variable for the points assigned per second remaining.
	 */
	public static int age3to5timerPoints = 0;
	
	public static boolean age3to5Q1AnsweredCorrectly = false;
	public static boolean age3to5Q2AnsweredCorrectly = false;
	public static boolean age3to5Q3AnsweredCorrectly = false;
	public static boolean age3to5Q4AnsweredCorrectly = false;
	public static boolean age3to5Q5AnsweredCorrectly = false;

	// causes app to always start with a highest score of 0
	// move to another location to make internal storage keep actual highest
	// score in final product
	static int age3to5Level1CurrentHighscore;
	static int age3to5Level2CurrentHighscore;
	static int age3to5Level3CurrentHighscore;

	/**
	 * TextView object for the Level 1 Highscores.
	 */
	public static TextView age3to5Level1HighscoreTextView;

	/**
	 * TextView object for the Level 2 Highscores.
	 */
	public static TextView age3to5Level2HighscoreTextView;

	/**
	 * TextView object for the Level 3 Highscores.
	 */
	public static TextView age3to5Level3HighscoreTextView;

	public static String age3to5data1;
	public static String age3to5Highscore1 = "age3to5lvl1Highscore";

	public static String age3to5data2;
	public static String age3to5Highscore2 = "age3to5lvl2Highscore";

	public static String age3to5data3;
	public static String age3to5Highscore3 = "age3to5lvl3Highscore";

	/**
	 * TextView object for the points earned for each round
	 */
	public static TextView questionscoreTextView;

	/**
	 * TextView object for the points earned for time remaining
	 */
	public static TextView timescoreTextView;

	/**
	 * TextView object for the points earned in total
	 */
	public static TextView totalscoreTextView;

	public static ImageView goldMedal;
	public static ImageView silverMedal;
	public static ImageView bronzeMedal;

	public static TextView resultMessage;
	
	public static ImageView greentick1;
	public static ImageView greentick2;
	public static ImageView greentick3;
	public static ImageView greentick4;
	public static ImageView greentick5;
	
	public static ImageView redcross1;
	public static ImageView redcross2;
	public static ImageView redcross3;
	public static ImageView redcross4;
	public static ImageView redcross5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_age3to5_results);

		// open file 1 to be written to
		try {
			FileInputStream fin = openFileInput(Age3to5Results.age3to5Highscore1);
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age3to5Level1CurrentHighscore = Integer.parseInt(temp);
			fin.close();
		} catch (Exception e) {
		}

		// open file 2 to be written to
		try {
			FileInputStream fin = openFileInput(Age3to5Results.age3to5Highscore2);
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age3to5Level2CurrentHighscore = Integer.parseInt(temp);
			fin.close();
		} catch (Exception e) {
		}

		// open file 3 to be written to
		try {
			FileInputStream fin = openFileInput(Age3to5Results.age3to5Highscore3);	
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age3to5Level3CurrentHighscore = Integer.parseInt(temp);
			fin.close();
		} catch (Exception e) {
		}

		// assign image to arrow button
		btn = (ImageButton) findViewById(R.id.next_page);

		questionscoreTextView = (TextView) findViewById(R.id.questionscore);
		// gives 30points per correct answer
		questionscoreTextView.setText(Integer.toString(age3to5numberCorrect * 30));

		timescoreTextView = (TextView) findViewById(R.id.timescore);
		// gives timer points for each correct answer
		timescoreTextView.setText(Integer.toString(age3to5timerPoints));

		totalscoreTextView = (TextView) findViewById(R.id.totalscore);
		// adds the question points and timer points
		totalscoreTextView.setText(Integer.toString((age3to5numberCorrect * 30)
				+ (age3to5timerPoints)));

		goldMedal = (ImageView) findViewById(R.id.goldMedal);
		silverMedal = (ImageView) findViewById(R.id.silverMedal);
		bronzeMedal = (ImageView) findViewById(R.id.bronzeMedal);
		
		resultMessage = (TextView) findViewById(R.id.resultMessage);
		
		age3to5greentick1 = (ImageView) findViewById(R.id.age3to5greentick1);
		age3to5redcross1 = (ImageView) findViewById(R.id.age3to5redcross1);
		
		age3to5greentick2 = (ImageView) findViewById(R.id.age3to5greentick2);
		age3to5redcross2 = (ImageView) findViewById(R.id.age3to5redcross2);
		
		age3to5greentick3 = (ImageView) findViewById(R.id.age3to5greentick3);
		age3to5redcross3 = (ImageView) findViewById(R.id.age3to5redcross3);
		
		age3to5greentick4 = (ImageView) findViewById(R.id.age3to5greentick4);
		age3to5redcross4 = (ImageView) findViewById(R.id.age3to5redcross4);
		
		age3to5greentick5 = (ImageView) findViewById(R.id.age3to5greentick5);
		age3to5redcross5 = (ImageView) findViewById(R.id.age3to5redcross5);
		
		if(age3to5Q1AnsweredCorrectly == true){
			age3to5greentick1.setVisibility(View.VISIBLE);
			age3to5redcross1.setVisibility(View.INVISIBLE);
		} else if (age3to5Q1AnsweredCorrectly == false){
			age3to5greentick1.setVisibility(View.INVISIBLE);
			age3to5redcross1.setVisibility(View.VISIBLE);
		}
		
		if(age3to5Q2AnsweredCorrectly == true){
			age3to5greentick2.setVisibility(View.VISIBLE);
			age3to5redcross2.setVisibility(View.INVISIBLE);
		} else if (age3to5Q2AnsweredCorrectly == false){
			age3to5greentick2.setVisibility(View.INVISIBLE);
			age3to5redcross2.setVisibility(View.VISIBLE);
		}
		
		if(age3to5Q3AnsweredCorrectly == true){
			age3to5greentick3.setVisibility(View.VISIBLE);
			age3to5redcross3.setVisibility(View.INVISIBLE);
		} else if (age3to5Q3AnsweredCorrectly == false){
			age3to5greentick3.setVisibility(View.INVISIBLE);
			age3to5redcross3.setVisibility(View.VISIBLE);
		}
		
		if(age3to5Q4AnsweredCorrectly == true){
			age3to5greentick4.setVisibility(View.VISIBLE);
			age3to5redcross4.setVisibility(View.INVISIBLE);
		} else if (age3to5Q4AnsweredCorrectly == false){
			age3to5greentick4.setVisibility(View.INVISIBLE);
			age3to5redcross4.setVisibility(View.VISIBLE);
		}
		
		if(age3to5Q5AnsweredCorrectly == true){
			age3to5greentick5.setVisibility(View.VISIBLE);
			age3to5redcross5.setVisibility(View.INVISIBLE);
		} else if (age3to5Q5AnsweredCorrectly == false){
			age3to5greentick5.setVisibility(View.INVISIBLE);
			age3to5redcross5.setVisibility(View.VISIBLE);
		}

		if (((age3to5numberCorrect * 30) + (age3to5timerPoints)) >= 200) {
			goldMedal.setVisibility(View.VISIBLE);
			silverMedal.setVisibility(View.INVISIBLE);
			bronzeMedal.setVisibility(View.INVISIBLE);
			resultMessage.setText("Well done!");
			resultMessage.setTextColor(Color.RED);
		} else if (((age3to5numberCorrect * 30) + (age3to5timerPoints)) >= 100
				&& ((age3to5numberCorrect * 30) + (age3to5timerPoints)) < 200) {
			goldMedal.setVisibility(View.INVISIBLE);
			silverMedal.setVisibility(View.VISIBLE);
			bronzeMedal.setVisibility(View.INVISIBLE);
			resultMessage.setText("Almost, try again");
			resultMessage.setTextColor(Color.BLUE);
		} else if (((age3to5numberCorrect * 30) + (age3to5timerPoints)) >= 0
				&& ((age3to5numberCorrect * 30) + (age3to5timerPoints)) < 100) {
			goldMedal.setVisibility(View.INVISIBLE);
			silverMedal.setVisibility(View.INVISIBLE);
			bronzeMedal.setVisibility(View.VISIBLE);
			resultMessage.setText("Hard luck");
			resultMessage.setTextColor(Color.GREEN);
		}

		if (level1Selected == true) {
			if ((age3to5numberCorrect * 30) + (age3to5timerPoints) > age3to5Level1CurrentHighscore) {
				saveage3to5Level1HighScore(age3to5Level1HighscoreTextView);
			}
		}

		if (level2Selected == true) {
			if ((age3to5numberCorrect * 30) + (age3to5timerPoints) > age3to5Level2CurrentHighscore) {
				saveage3to5Level2HighScore(age3to5Level2HighscoreTextView);
			}
		}

		if (level3Selected == true) {
			if ((age3to5numberCorrect * 30) + (age3to5timerPoints) > age3to5Level3CurrentHighscore) {
				saveage3to5Level3HighScore(age3to5Level3HighscoreTextView);
			}
		}

		nextPageButton();

	}

	/**
	 * saves score from level 1 to high scores table
	 * 
	 * @param view
	 */
	@SuppressLint("WorldReadableFiles")
	public void saveage3to5Level1HighScore(View view) {

		age3to5data1 = totalscoreTextView.getText().toString();

		// sets new current high score
		age3to5Level1CurrentHighscore = Integer.parseInt(age3to5data1);

		try {
			@SuppressWarnings("deprecation")
			FileOutputStream fOut = openFileOutput(age3to5Highscore1, MODE_WORLD_READABLE);
			fOut.write(age3to5data1.getBytes());
			fOut.close();
			Toast.makeText(getBaseContext(), "New High Score",
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * saves score from level 2 to high scores table
	 * 
	 * @param view
	 */
	@SuppressLint("WorldReadableFiles")
	public void saveage3to5Level2HighScore(View view) {

		age3to5data2 = totalscoreTextView.getText().toString();

		age3to5Level2CurrentHighscore = Integer.parseInt(age3to5data2);

		try {
			@SuppressWarnings("deprecation")
			FileOutputStream fOut = openFileOutput(age3to5Highscore2, MODE_WORLD_READABLE);
			fOut.write(age3to5data2.getBytes());
			fOut.close();
			Toast.makeText(getBaseContext(), "New High Score",
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * saves score from level 3 to high scores table
	 * 
	 * @param view
	 */
	@SuppressLint("WorldReadableFiles")
	public void saveage3to5Level3HighScore(View view) {

		age3to5data3 = totalscoreTextView.getText().toString();

		age3to5Level3CurrentHighscore = Integer.parseInt(age3to5data3);

		try {
			@SuppressWarnings("deprecation")
			FileOutputStream fOut = openFileOutput(age3to5Highscore3, MODE_WORLD_READABLE);
			fOut.write(age3to5data3.getBytes());
			fOut.close();
			Toast.makeText(getBaseContext(), "New High Score",
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method to change screen after arrow is pressed
	 */
	private void nextPageButton() {

		ImageButton btn = (ImageButton) findViewById(R.id.next_page);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent changeScreen = new Intent(Age3to5Results.this,
						LevelSelect3to5.class);
				startActivity(changeScreen);
				// reset scores
				age3to5numberCorrect = 0;
				age3to5timerPoints = 0;
			}

		});
	}

	/**
	 * Method to disable the back button
	 */
	@Override
	public void onBackPressed() {
		// super.onBackPressed();
	}

}