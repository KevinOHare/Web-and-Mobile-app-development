package com.example.quizforkids;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.quizforkids.Results;

public class MainActivity extends Activity {

	public static TextView timer;

	public static boolean answeredCorrectly = false;

	public static CountDownTimer countDownTimer;
	
	public static boolean level1Selected = false;
	public static boolean level2Selected = false;
	public static boolean level3Selected = false;
	
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
						SelectAgeActivity.class);
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
						Highscore.class);
				startActivity(changeScreen);
			}
		});

		// Create the functionality for the EXIT button
		final Button exitButton = (Button) findViewById(R.id.exit_button);
		exitButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bugSong.stop();
				finish();
				System.exit(0);
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
				timer.setText("!");
			}

		}.start();

	}

	public static void updateScore() {
		if (answeredCorrectly == true) {
			Results.numberCorrect+=1;
			Results.timerPoints += Integer.parseInt(timer.getText().toString());
		}
	}

}