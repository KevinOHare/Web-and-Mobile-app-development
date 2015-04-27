package com.example.quizforkids;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizforkids.Age3to5Results;

public class MainActivity extends Activity {

	/**
	 * TextView object
	 */
	public static TextView timer;

	/**
	 * Boolean for age 3-5 answer correctly
	 */
	public static boolean age3to5answeredCorrectly = false;
	
	/**
	 * Boolean for age 5-7 answer correctly
	 */
	public static boolean age5to7answeredCorrectly = false;

	/**
	 * CountDownTimer object
	 */
	public static CountDownTimer countDownTimer;

	/**
	 * Boolean for level select
	 */
	public static boolean level1Selected = false;
	
	/**
	 * Boolean for level select
	 */
	public static boolean level2Selected = false;
	
	/**
	 * Boolean for level select
	 */
	public static boolean level3Selected = false;

	/**
	 * ImageView object for green tick
	 */
	public static ImageView age3to5greentick1;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age3to5greentick2;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age3to5greentick3;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age3to5greentick4;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age3to5greentick5;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age3to5redcross1;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age3to5redcross2;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age3to5redcross3;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age3to5redcross4;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age3to5redcross5;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age5to7greentick1;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age5to7greentick2;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age5to7greentick3;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age5to7greentick4;
	
	/**
	 * ImageView object for green tick
	 */
	public static ImageView age5to7greentick5;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age5to7redcross1;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age5to7redcross2;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age5to7redcross3;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age5to7redcross4;
	
	/**
	 * ImageView object for red cross
	 */
	public static ImageView age5to7redcross5;

	// Create a mediaPlayer for music
	MediaPlayer bugSong;
	// local variable
	private int mSec = 0;

	/**
	 * On create method to carry out MainActivity
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// call to superclass for states
		super.onCreate(savedInstanceState);
		// set content to xml
		setContentView(R.layout.activity_main);

		// Create the functionality for the PLAY button
		final Button play = (Button) findViewById(R.id.play_button);
		play.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// create intent
				Intent changeScreen = new Intent(MainActivity.this,
						QuestionAgeSelect.class);
				// open new view
				startActivity(changeScreen);

			}
		});

		// Create the functionality for the SOUND buttons
		// On button
		final Button soundOnButton = (Button) findViewById(R.id.music_on_button);
		// Off button
		final Button soundOffButton = (Button) findViewById(R.id.music_off_button);
		soundOffButton.setEnabled(false);

		soundOnButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Create and call song
				bugSong = MediaPlayer.create(MainActivity.this,
						R.raw.dontsquashthatbug);
				// set loop
				bugSong.setLooping(true);

				// check and start the songs
				if (mSec == 0) {
					bugSong.start();
				} else {
					bugSong.seekTo(mSec);
					bugSong.start();
				}

				// set enable buttons
				soundOnButton.setEnabled(false);
				soundOffButton.setEnabled(true);
			}
		});

		// Create the functionality for the SOUND off button

		soundOffButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// pause the song
				bugSong.pause();
				// find the current position of the song
				mSec = bugSong.getCurrentPosition();
				// set enable buttons
				soundOffButton.setEnabled(false);
				soundOnButton.setEnabled(true);
			}
		});

		// Create the functionality for the HIGHSCORES button
		final Button highScoresButton = (Button) findViewById(R.id.highscores_button);
		highScoresButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// create intent
				Intent changeScreen = new Intent(MainActivity.this,
						HighscoreAgeSelect.class);
				// open new view
				startActivity(changeScreen);
			}
		});

		// Create the functionality for the HELP button
		final Button videoHelpButton = (Button) findViewById(R.id.videoHelp_button);
		// Capture button clicks
		videoHelpButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// create intent
				Intent changeScreen = new Intent(MainActivity.this,
						VideoHelp.class);
				// open new view
				startActivity(changeScreen);
			}
		});
			
	}

	/**
	 * Countdown timer method - from 30 seconds
	 */
	public void countDown() {

		// create timer Text view and link to xml
		timer = (TextView) findViewById(R.id.timer);

		// create timer function
		countDownTimer = new CountDownTimer(30000, 1000) {
			
			// display text as the timer continues
			public void onTick(long millSecs) {
				timer.setText("" + millSecs / 1000);
			}

			// display text on finish
			public void onFinish() {
				timer.setText("0");
			}
			// start the timer
		}.start();

	}

	/**
	 * A method to increase results screen score for each correct answer
	 */
	public static void update3to5Score() {
		// check if question is answered correctly
		if (age3to5answeredCorrectly == true) {
			// add points
			Age3to5Results.age3to5numberCorrect += 1;
			// add timer points
			Age3to5Results.age3to5timerPoints += Integer.parseInt(timer
					.getText().toString());
		}
	}

	/**
	 * A method to increase results screen score for each correct answer
	 */
	public static void update5to7Score() {
		// check if question is answered correctly
		if (age5to7answeredCorrectly == true) {
			// add points
			Age5to7Results.age5to7numberCorrect += 1;
			// add timer points
			Age5to7Results.age5to7timerPoints += Integer.parseInt(timer
					.getText().toString());
		}
	}

}