package com.example.quizforkids;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizforkids.Age3to5Results;

public class MainActivity extends Activity {

	public static TextView timer;

	public static boolean age3to5answeredCorrectly = false;
	public static boolean age5to7answeredCorrectly = false;

	public static CountDownTimer countDownTimer;

	public static boolean level1Selected = false;
	public static boolean level2Selected = false;
	public static boolean level3Selected = false;

	public static ImageView age3to5greentick1;
	public static ImageView age3to5greentick2;
	public static ImageView age3to5greentick3;
	public static ImageView age3to5greentick4;
	public static ImageView age3to5greentick5;
	
	public static ImageView age3to5redcross1;
	public static ImageView age3to5redcross2;
	public static ImageView age3to5redcross3;
	public static ImageView age3to5redcross4;
	public static ImageView age3to5redcross5;
	
	public static ImageView age5to7greentick1;
	public static ImageView age5to7greentick2;
	public static ImageView age5to7greentick3;
	public static ImageView age5to7greentick4;
	public static ImageView age5to7greentick5;
	
	public static ImageView age5to7redcross1;
	public static ImageView age5to7redcross2;
	public static ImageView age5to7redcross3;
	public static ImageView age5to7redcross4;
	public static ImageView age5to7redcross5;

	// Create a mediaPlayer for music
	MediaPlayer bugSong;
	private int mSec = 0;

	// Create button objects for the on/off mediaPlayer functionality

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Create the functionality for the PLAY button
		final Button play = (Button) findViewById(R.id.play_button);
		play.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent changeScreen = new Intent(MainActivity.this,
						QuestionAgeSelect.class);
				startActivity(changeScreen);

			}
		});

		// Create the functionality for the SOUND buttons
		final Button soundOnButton = (Button) findViewById(R.id.music_on_button);
		final Button soundOffButton = (Button) findViewById(R.id.music_off_button);

		soundOnButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bugSong = MediaPlayer.create(MainActivity.this,
						R.raw.dontsquashthatbug);
				bugSong.setLooping(true);

				if (mSec == 0) {
					bugSong.start();
				} else {
					bugSong.seekTo(mSec);
					bugSong.start();
				}

				soundOnButton.setEnabled(false);
				soundOffButton.setEnabled(true);
			}
		});

		// Create the functionality for the SOUND off button

		soundOffButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bugSong.pause();
				mSec = bugSong.getCurrentPosition();
				soundOffButton.setEnabled(false);
				soundOnButton.setEnabled(true);
			}
		});

		// Create the functionality for the HIGHSCORES button
		final Button highScoresButton = (Button) findViewById(R.id.highscores_button);
		highScoresButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent changeScreen = new Intent(MainActivity.this,
						HighscoreAgeSelect.class);
				startActivity(changeScreen);
			}
		});

		// Create the functionality for the HELP button
		final Button videoHelpButton = (Button) findViewById(R.id.videoHelp_button);
		// Capture button clicks
		videoHelpButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent changeScreen = new Intent(MainActivity.this,
						VideoHelp.class);
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

			public void onTick(long millSecs) {
				timer.setText("" + millSecs / 1000);
			}

			public void onFinish() {
				timer.setText("0");
			}

		}.start();

	}

	// increases results screen score for each correct answer
	public static void update3to5Score() {
		if (age3to5answeredCorrectly == true) {
			Age3to5Results.age3to5numberCorrect += 1;
			Age3to5Results.age3to5timerPoints += Integer.parseInt(timer
					.getText().toString());
		}
	}

	// increases results screen score for each correct answer
	public static void update5to7Score() {
		if (age5to7answeredCorrectly == true) {
			Age5to7Results.age5to7numberCorrect += 1;
			Age5to7Results.age5to7timerPoints += Integer.parseInt(timer
					.getText().toString());
		}
	}

}