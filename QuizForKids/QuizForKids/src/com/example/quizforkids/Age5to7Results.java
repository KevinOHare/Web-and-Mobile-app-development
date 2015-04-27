package com.example.quizforkids;

/**
 * import resources
 */
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

/**
 * Class to show the results of the Age 5 to 7 levels
 * @author chrismcclune
 *
 */
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
	
	/**
	 * Instance variable for the question 1 answer
	 */
	public static boolean age5to7Q1AnsweredCorrectly = false;
	
	/**
	 * Instance variable for the question 2 answer
	 */
	public static boolean age5to7Q2AnsweredCorrectly = false;
	
	/**
	 * Instance variable for the question 3 answer
	 */
	public static boolean age5to7Q3AnsweredCorrectly = false;
	
	/**
	 * Instance variable for the question 4 answer
	 */
	public static boolean age5to7Q4AnsweredCorrectly = false;
	
	/**
	 * Instance variable for the question 5 answer
	 */
	public static boolean age5to7Q5AnsweredCorrectly = false;



	/**
	 * int for the current highscore of level 1 in age 5to7
	 */
	static int age5to7Level1CurrentHighscore;
	
	/**
	 * int for the current highscore of level 2 in age 5to7
	 */
	static int age5to7Level2CurrentHighscore;
	
	/**
	 * int for the current highscore of level 3 in age 5to7
	 */
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

	/**
	 * instance variable for the data to be written to highscore
	 */
	public static String age5to7data1;
	
	/**
	 * String to assign the Highscore to
	 */
	public static String age5to7Highscore1 = "age5to7lvl1Highscore";

	/**
	 * instance variable for the data to be written to highscore
	 */
	public static String age5to7data2;
	
	/**
	 * String to assign the Highscore to
	 */
	public static String age5to7Highscore2 = "age5to7lvl2Highscore";

	/**
	 * instance variable for the data to be written to highscore
	 */
	public static String age5to7data3;
	
	/**
	 * String to assign the Highscore to
	 */
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

	/**
	 * Image view for the gold medal
	 */
	public static ImageView goldMedal;
	
	/**
	 * Image view for the silver medal
	 */
	public static ImageView silverMedal;
	
	/**
	 * Image view for the bronze medal
	 */
	public static ImageView bronzeMedal;
	
	/**
	 * TextView for the results message
	 */
	public static TextView resultMessage;
	
	/**
	 * ImageView for greentick question 1
	 */
	public static ImageView greentick1;
	
	/**
	 * ImageView for greentick question 2
	 */
	public static ImageView greentick2;
	
	/**
	 * ImageView for greentick question 3
	 */
	public static ImageView greentick3;
	
	/**
	 * ImageView for greentick question 4
	 */
	public static ImageView greentick4;
	
	/**
	 * ImageView for greentick question 5
	 */
	public static ImageView greentick5;

	/**
	 * ImageView for redcross question 1
	 */
	public static ImageView redcross1;
	
	/**
	 * ImageView for redcross question 2
	 */
	public static ImageView redcross2;
	
	/**
	 * ImageView for redcross question 3
	 */
	public static ImageView redcross3;
	
	/**
	 * ImageView for redcross question 4
	 */
	public static ImageView redcross4;
	
	/**
	 * ImageView for redcross question 5
	 */
	public static ImageView redcross5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_age5to7_results);

		// open the highcore files to read the highscores
		openFile1();
		openFile2();
		openFile3();

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

		// assign gold medal image to imageviews
		goldMedal = (ImageView) findViewById(R.id.goldMedal);
		silverMedal = (ImageView) findViewById(R.id.silverMedal);
		bronzeMedal = (ImageView) findViewById(R.id.bronzeMedal);
		
		// assign results message image to result message
		resultMessage = (TextView) findViewById(R.id.resultMessage);
		
		// assign greenticks and red crosses to appropriate images
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
		
		// if statement to set visibility of ticks and crosses to question 1
		if(age5to7Q1AnsweredCorrectly == true){
			age5to7greentick1.setVisibility(View.VISIBLE);
			age5to7redcross1.setVisibility(View.INVISIBLE);
		} else if (age5to7Q1AnsweredCorrectly == false){
			age5to7greentick1.setVisibility(View.INVISIBLE);
			age5to7redcross1.setVisibility(View.VISIBLE);
		}
		
		// if statement to set visibility of ticks and crosses to question 2
		if(age5to7Q2AnsweredCorrectly == true){
			age5to7greentick2.setVisibility(View.VISIBLE);
			age5to7redcross2.setVisibility(View.INVISIBLE);
		} else if (age5to7Q2AnsweredCorrectly == false){
			age5to7greentick2.setVisibility(View.INVISIBLE);
			age5to7redcross2.setVisibility(View.VISIBLE);
		}
		
		// if statement to set visibility of ticks and crosses to question 3
		if(age5to7Q3AnsweredCorrectly == true){
			age5to7greentick3.setVisibility(View.VISIBLE);
			age5to7redcross3.setVisibility(View.INVISIBLE);
		} else if (age5to7Q3AnsweredCorrectly == false){
			age5to7greentick3.setVisibility(View.INVISIBLE);
			age5to7redcross3.setVisibility(View.VISIBLE);
		}
		
		// if statement to set visibility of ticks and crosses to question 4
		if(age5to7Q4AnsweredCorrectly == true){
			age5to7greentick4.setVisibility(View.VISIBLE);
			age5to7redcross4.setVisibility(View.INVISIBLE);
		} else if (age5to7Q4AnsweredCorrectly == false){
			age5to7greentick4.setVisibility(View.INVISIBLE);
			age5to7redcross4.setVisibility(View.VISIBLE);
		}
		
		// if statement to set visibility of ticks and crosses to question 5
		if(age5to7Q5AnsweredCorrectly == true){
			age5to7greentick5.setVisibility(View.VISIBLE);
			age5to7redcross5.setVisibility(View.INVISIBLE);
		} else if (age5to7Q5AnsweredCorrectly == false){
			age5to7greentick5.setVisibility(View.INVISIBLE);
			age5to7redcross5.setVisibility(View.VISIBLE);
		}

		// If statements to determine score and to give appropriate medal colour
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

		// if statement to write new highscore if better than previous attempts
		if (level1Selected == true) {
			if ((age5to7numberCorrect * 30) + (age5to7timerPoints) > age5to7Level1CurrentHighscore) {
				saveage5to7Level1HighScore(age5to7Level1HighscoreTextView);
			}
		}
		
		// if statement to write new highscore if better than previous attempts
		if (level2Selected == true) {
			if ((age5to7numberCorrect * 30) + (age5to7timerPoints) > age5to7Level2CurrentHighscore) {
				saveage5to7Level2HighScore(age5to7Level2HighscoreTextView);
			}
		}

		// if statement to write new highscore if better than previous attempts
		if (level3Selected == true) {
			if ((age5to7numberCorrect * 30) + (age5to7timerPoints) > age5to7Level3CurrentHighscore) {
				saveage5to7Level3HighScore(age5to7Level3HighscoreTextView);
			}
		}
		// call method to move to next screen
		nextPageButton();

	}
	
	/**
	 * Method to read the highscore from the saved file and assign it to the current highscore
	 */
	public void openFile1(){
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
	}
	
	/**
	 * Method to read the highscore from the saved file and assign it to the current highscore
	 */
	public void openFile2(){
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
	}
	
	/**
	 * Method to read the highscore from the saved file and assign it to the current highscore
	 */
	public void openFile3(){
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
	}

	/**
	 * saves score from level 1 to high scores table
	 * 
	 * @param view
	 */
	@SuppressLint("WorldReadableFiles")
	public void saveage5to7Level1HighScore(View view) {

		// assign the value from totalscore text view to data to be written to file
		age5to7data1 = totalscoreTextView.getText().toString();

		// sets new current high score
		age5to7Level1CurrentHighscore = Integer.parseInt(age5to7data1);

		//write to file and display toast if highscore is better than before
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

		// assign the value from totalscore text view to data to be written to file
		age5to7data2 = totalscoreTextView.getText().toString();

		// sets new current high score
		age5to7Level2CurrentHighscore = Integer.parseInt(age5to7data2);

		//write to file and display toast if highscore is better than before
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

		// assign the value from totalscore text view to data to be written to file
		age5to7data3 = totalscoreTextView.getText().toString();

		// sets new current high score
		age5to7Level3CurrentHighscore = Integer.parseInt(age5to7data3);

		//write to file and display toast if highscore is better than before
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
				
				// Intent to change screen to level select after level completed
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