package com.example.quizforkids;

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

public class Age5to7Results extends MainActivity {

	/**
	 * Image Button object to be used for the next arrow.
	 */
	static ImageButton btn;

	/**
	 * Instance variable for the number of correct answers.
	 */
	public static int age5to7numberCorrect = 0;

	/**
	 * Instance variable for the points assigned per second remaining.
	 */
	public static int age5to7timerPoints = 0;
	
	public static boolean age5to7Q1AnsweredCorrectly = false;
	public static boolean age5to7Q2AnsweredCorrectly = false;
	public static boolean age5to7Q3AnsweredCorrectly = false;
	public static boolean age5to7Q4AnsweredCorrectly = false;
	public static boolean age5to7Q5AnsweredCorrectly = false;


	// causes app to always start with a highest score of 0
	// move to another location to make internal storage keep actual highest
	// score in final product
	static int age5to7Level1CurrentHighscore;
	static int age5to7Level2CurrentHighscore;
	static int age5to7Level3CurrentHighscore;

	/**
	 * TextView object for the Level 1 Highscores.
	 */
	public static TextView age5to7Level1HighscoreTextView;

	/**
	 * TextView object for the Level 2 Highscores.
	 */
	public static TextView age5to7Level2HighscoreTextView;

	/**
	 * TextView object for the Level 3 Highscores.
	 */
	public static TextView age5to7Level3HighscoreTextView;

	public static String age5to7data1;
	public static String age5to7Highscore1 = "age5to7lvl1Highscore";

	public static String age5to7data2;
	public static String age5to7Highscore2 = "age5to7lvl2Highscore";

	public static String age5to7data3;
	public static String age5to7Highscore3 = "age5to7lvl3Highscore";

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
		setContentView(R.layout.activity_age5to7_results);

		// open file 1 to be written to
		try {
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore1);
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age5to7Level1CurrentHighscore = Integer.parseInt(temp);
			fin.close();
		} catch (Exception e) {
		}

		// open file 2 to be written to
		try {
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore2);
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age5to7Level2CurrentHighscore = Integer.parseInt(temp);
			fin.close();
		} catch (Exception e) {
		}

		// open file 3 to be written to
		try {
			FileInputStream fin = openFileInput(Age5to7Results.age5to7Highscore3);	
			int c;
			String temp = "";
			while ((c = fin.read()) != -1) {
				temp = temp + Character.toString((char) c);
			}
			age5to7Level3CurrentHighscore = Integer.parseInt(temp);
			fin.close();
		} catch (Exception e) {
		}

		// assign image to arrow button
		btn = (ImageButton) findViewById(R.id.next_page);

		questionscoreTextView = (TextView) findViewById(R.id.questionscore);
		// gives 30points per correct answer
		questionscoreTextView.setText(Integer.toString(age5to7numberCorrect * 30));

		timescoreTextView = (TextView) findViewById(R.id.timescore);
		// gives timer points for each correct answer
		timescoreTextView.setText(Integer.toString(age5to7timerPoints));

		totalscoreTextView = (TextView) findViewById(R.id.totalscore);
		// adds the question points and timer points
		totalscoreTextView.setText(Integer.toString((age5to7numberCorrect * 30)
				+ (age5to7timerPoints)));

		goldMedal = (ImageView) findViewById(R.id.goldMedal);
		silverMedal = (ImageView) findViewById(R.id.silverMedal);
		bronzeMedal = (ImageView) findViewById(R.id.bronzeMedal);
		
		resultMessage = (TextView) findViewById(R.id.resultMessage);
		
		age5to7greentick1 = (ImageView) findViewById(R.id.age5to7greentick1);
		age5to7redcross1 = (ImageView) findViewById(R.id.age5to7redcross1);
		
		age5to7greentick2 = (ImageView) findViewById(R.id.age5to7greentick2);
		age5to7redcross2 = (ImageView) findViewById(R.id.age5to7redcross2);
		
		age5to7greentick3 = (ImageView) findViewById(R.id.age5to7greentick3);
		age5to7redcross3 = (ImageView) findViewById(R.id.age5to7redcross3);
		
		age5to7greentick4 = (ImageView) findViewById(R.id.age5to7greentick4);
		age5to7redcross4 = (ImageView) findViewById(R.id.age5to7redcross4);
		
		age5to7greentick5 = (ImageView) findViewById(R.id.age5to7greentick5);
		age5to7redcross5 = (ImageView) findViewById(R.id.age5to7redcross5);
		
		if(age5to7Q1AnsweredCorrectly == true){
			age5to7greentick1.setVisibility(View.VISIBLE);
			age5to7redcross1.setVisibility(View.INVISIBLE);
		} else if (age5to7Q1AnsweredCorrectly == false){
			age5to7greentick1.setVisibility(View.INVISIBLE);
			age5to7redcross1.setVisibility(View.VISIBLE);
		}
		
		if(age5to7Q2AnsweredCorrectly == true){
			age5to7greentick2.setVisibility(View.VISIBLE);
			age5to7redcross2.setVisibility(View.INVISIBLE);
		} else if (age5to7Q2AnsweredCorrectly == false){
			age5to7greentick2.setVisibility(View.INVISIBLE);
			age5to7redcross2.setVisibility(View.VISIBLE);
		}
		
		if(age5to7Q3AnsweredCorrectly == true){
			age5to7greentick3.setVisibility(View.VISIBLE);
			age5to7redcross3.setVisibility(View.INVISIBLE);
		} else if (age5to7Q3AnsweredCorrectly == false){
			age5to7greentick3.setVisibility(View.INVISIBLE);
			age5to7redcross3.setVisibility(View.VISIBLE);
		}
		
		if(age5to7Q4AnsweredCorrectly == true){
			age5to7greentick4.setVisibility(View.VISIBLE);
			age5to7redcross4.setVisibility(View.INVISIBLE);
		} else if (age5to7Q4AnsweredCorrectly == false){
			age5to7greentick4.setVisibility(View.INVISIBLE);
			age5to7redcross4.setVisibility(View.VISIBLE);
		}
		
		if(age5to7Q5AnsweredCorrectly == true){
			age5to7greentick5.setVisibility(View.VISIBLE);
			age5to7redcross5.setVisibility(View.INVISIBLE);
		} else if (age5to7Q5AnsweredCorrectly == false){
			age5to7greentick5.setVisibility(View.INVISIBLE);
			age5to7redcross5.setVisibility(View.VISIBLE);
		}

		if (((age5to7numberCorrect * 30) + (age5to7timerPoints)) >= 200) {
			goldMedal.setVisibility(View.VISIBLE);
			silverMedal.setVisibility(View.INVISIBLE);
			bronzeMedal.setVisibility(View.INVISIBLE);
			resultMessage.setText("Well done!");
			resultMessage.setTextColor(Color.RED);
		} else if (((age5to7numberCorrect * 30) + (age5to7timerPoints)) >= 100
				&& ((age5to7numberCorrect * 30) + (age5to7timerPoints)) < 200) {
			goldMedal.setVisibility(View.INVISIBLE);
			silverMedal.setVisibility(View.VISIBLE);
			bronzeMedal.setVisibility(View.INVISIBLE);
			resultMessage.setText("Almost, try again");
			resultMessage.setTextColor(Color.BLUE);
		} else if (((age5to7numberCorrect * 30) + (age5to7timerPoints)) >= 0
				&& ((age5to7numberCorrect * 30) + (age5to7timerPoints)) < 100) {
			goldMedal.setVisibility(View.INVISIBLE);
			silverMedal.setVisibility(View.INVISIBLE);
			bronzeMedal.setVisibility(View.VISIBLE);
			resultMessage.setText("Hard luck");
			resultMessage.setTextColor(Color.GREEN);
		}

		if (level1Selected == true) {
			if ((age5to7numberCorrect * 30) + (age5to7timerPoints) > age5to7Level1CurrentHighscore) {
				saveage5to7Level1HighScore(age5to7Level1HighscoreTextView);
			}
		}

		if (level2Selected == true) {
			if ((age5to7numberCorrect * 30) + (age5to7timerPoints) > age5to7Level2CurrentHighscore) {
				saveage5to7Level2HighScore(age5to7Level2HighscoreTextView);
			}
		}

		if (level3Selected == true) {
			if ((age5to7numberCorrect * 30) + (age5to7timerPoints) > age5to7Level3CurrentHighscore) {
				saveage5to7Level3HighScore(age5to7Level3HighscoreTextView);
			}
		}

		nextPageButton();
		set5to7Ticks();

	}
	
	public void set5to7Ticks() {
		age5to7greentick1  = (ImageView) findViewById(R.id.age5to7greentick1);
		age5to7greentick2  = (ImageView) findViewById(R.id.age5to7greentick2);
		age5to7greentick3  = (ImageView) findViewById(R.id.age5to7greentick3);
		age5to7greentick4  = (ImageView) findViewById(R.id.age5to7greentick4);
		age5to7greentick5  = (ImageView) findViewById(R.id.age5to7greentick5);


		if (Age5to7Results.age5to7numberCorrect == 1) {
			age5to7greentick1.setVisibility(View.VISIBLE);
		} else if (Age5to7Results.age5to7numberCorrect == 2) {
			age5to7greentick2.setVisibility(View.VISIBLE);
		} else if (Age5to7Results.age5to7numberCorrect == 3) {
			age5to7greentick3.setVisibility(View.VISIBLE);
		} else if (Age5to7Results.age5to7numberCorrect == 4) {
			age5to7greentick4.setVisibility(View.VISIBLE);
		} else if (Age5to7Results.age5to7numberCorrect == 5) {
			age5to7greentick5.setVisibility(View.VISIBLE);
		}
	}

	/**
	 * saves score from level 1 to high scores table
	 * 
	 * @param view
	 */
	@SuppressLint("WorldReadableFiles")
	public void saveage5to7Level1HighScore(View view) {

		age5to7data1 = totalscoreTextView.getText().toString();

		// sets new current high score
		age5to7Level1CurrentHighscore = Integer.parseInt(age5to7data1);

		try {
			@SuppressWarnings("deprecation")
			FileOutputStream fOut = openFileOutput(age5to7Highscore1, MODE_WORLD_READABLE);
			fOut.write(age5to7data1.getBytes());
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
	public void saveage5to7Level2HighScore(View view) {

		age5to7data2 = totalscoreTextView.getText().toString();

		age5to7Level2CurrentHighscore = Integer.parseInt(age5to7data2);

		try {
			@SuppressWarnings("deprecation")
			FileOutputStream fOut = openFileOutput(age5to7Highscore2, MODE_WORLD_READABLE);
			fOut.write(age5to7data2.getBytes());
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
	public void saveage5to7Level3HighScore(View view) {

		age5to7data3 = totalscoreTextView.getText().toString();

		age5to7Level3CurrentHighscore = Integer.parseInt(age5to7data3);

		try {
			@SuppressWarnings("deprecation")
			FileOutputStream fOut = openFileOutput(age5to7Highscore3, MODE_WORLD_READABLE);
			fOut.write(age5to7data3.getBytes());
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
				
				Intent changeScreen = new Intent(Age5to7Results.this,
						LevelSelect5to7.class);
				startActivity(changeScreen);
				// reset scores
				age5to7numberCorrect = 0;
				age5to7timerPoints = 0;
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