package com.example.quizforkids;

import com.example.quizforkids.MainActivity;
import com.example.quizforkids.R;
import com.example.quizforkids.Highscore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Results extends MainActivity {
	
	static ImageButton btn;

	public static int numberCorrect = 0;

	public static int timerPoints = 0;
	
	public static TextView Level1HighscoreTextView;
	public static TextView Level2HighscoreTextView;
	public static TextView Level3HighscoreTextView;
	
	public static int level1Highscore = 0;
	public static int level2Highscore = 0;
	public static int level3Highscore = 0;

	// displays question points for round
	public static TextView questionscoreTextView;

	// displays time points for round
	public static TextView timescoreTextView;

	// displays total points for round
	public static TextView totalscoreTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		Level1HighscoreTextView = (TextView) findViewById(R.id.Level1Highscore);
		Level2HighscoreTextView = (TextView) findViewById(R.id.Level2Highscore);
		Level3HighscoreTextView = (TextView) findViewById(R.id.Level3Highscore);
		
		// assign image to arrow button
		btn = (ImageButton) findViewById(R.id.next_page);

		questionscoreTextView = (TextView) findViewById(R.id.questionscore);
		// gives 30points per correct answer
		questionscoreTextView.setText(Integer.toString(numberCorrect * 30));
		
		timescoreTextView = (TextView) findViewById(R.id.timescore);
		// gives timer points for each correct answer
		timescoreTextView.setText(Integer.toString(timerPoints));

		totalscoreTextView = (TextView) findViewById(R.id.totalscore);
		// adds the question points and timer points
		totalscoreTextView.setText(Integer.toString((numberCorrect * 30)+(timerPoints)));
		
		//updateHighscores();
		
		nextPageButton();
		
	}
	
	public static void updateHighscores(){
		
		if(MainActivity.level1Selected == true){
			if(Integer.parseInt(totalscoreTextView.getText().toString()) > level1Highscore){
				Level1HighscoreTextView.setText(totalscoreTextView.toString());
			}
			level1Selected = false;
		}
		
		if(level2Selected == true){
			if(Integer.parseInt(totalscoreTextView.getText().toString()) > level2Highscore){
				Level2HighscoreTextView.setText(totalscoreTextView.toString());
			}
			level2Selected = false;
		}
		
		if(level3Selected == true){
			if(Integer.parseInt(totalscoreTextView.getText().toString()) > level3Highscore){
				Level3HighscoreTextView.setText(totalscoreTextView.toString());
			}
			level3Selected = false;
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
				// resets the timer
				countDownTimer.cancel();
				Intent changeScreen = new Intent(Results.this,
						MainActivity.class);
				startActivity(changeScreen);
				// reset scores
				numberCorrect = 0;
				timerPoints = 0;
			}

		});
	}
	
	@Override
	public void onBackPressed(){
		//super.onBackPressed();
	}
	
}
