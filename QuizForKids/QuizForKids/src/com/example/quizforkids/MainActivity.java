package com.example.quizforkids;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	
	// Create a mediaPlayer for music
	MediaPlayer bugSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Set the details for the song
        bugSong = MediaPlayer.create(MainActivity.this, R.raw.dontsquashthatbug);
        bugSong.setLooping(true);
        bugSong.start();
        
        // Create the functionality for the PLAY button
        final Button play = (Button) findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//rightanswer.setEnabled(true);
				Intent changeScreen = new Intent(MainActivity.this,SelectAgeActivity.class);
				//bugSong.stop();
				startActivity(changeScreen);
				
			}
		});
        
        // Create the functionality for the SOUND button
        final Button soundButton = (Button) findViewById(R.id.sound_button);
        soundButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				boolean soundOn = false;
				
				if (soundOn = false){
					soundButton.setEnabled(true);
					soundButton.setText("SOUND: ON");
					bugSong.start();
					soundOn = true;
				}
				
				if (soundOn = true){
					soundButton.setText("SOUND: OFF");
					soundButton.setEnabled(true);
					bugSong.stop();
					soundOn = false;
				}
			}
		});
        
        //Create the functionality for the HIGHSCORES button
        final Button highScoresButton = (Button) findViewById(R.id.highscores_button);
        highScoresButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent changeScreen = new Intent(MainActivity.this, Highscore.class);
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
}