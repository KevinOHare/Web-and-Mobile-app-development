package maths3to5;

import com.example.quizforkids.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Maths3to5Q4 extends Activity {

	// Text View for timer
	TextView timer;
	
	public static int numberAnsweredCorrectlyBy3;
	
	public static int numberAnsweredCorrectlyByQ4;

	// Buttons for answers
	static Button Answer1;
	static Button Answer2;
	static Button Answer3;
	static Button Answer4;
	
	// Button for the arrow
	static ImageButton btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maths3to5_q4);
		
		// assign image to arrow button
		btn = (ImageButton) findViewById(R.id.next_page);
		
		// Buttons for answers
		Answer1 = (Button) findViewById(R.id.button1);
		Answer2 = (Button) findViewById(R.id.button2);
		Answer3 = (Button) findViewById(R.id.button3);
		Answer4 = (Button) findViewById(R.id.button4);

		// implement count down
		countDown();

		// Set the visibility of the arrow
		btn.setVisibility(View.INVISIBLE);

		// ****** on click listeners *******
		Answer1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (Answer1.isPressed()) {
					Answer1.setBackgroundColor(Color.RED);
					Answer2.setBackgroundColor(Color.YELLOW);
					Answer3.setBackgroundColor(Color.YELLOW);
					Answer4.setBackgroundColor(Color.YELLOW);
				}
				// set arrow to visible
				btn.setVisibility(View.VISIBLE);
			}
		});

		Answer2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (Answer2.isPressed()) {
					Answer1.setBackgroundColor(Color.YELLOW);
					Answer2.setBackgroundColor(Color.RED);
					Answer3.setBackgroundColor(Color.YELLOW);
					Answer4.setBackgroundColor(Color.YELLOW);
				}
				// set arrow to visible
				btn.setVisibility(View.VISIBLE);
			}
		});

		Answer3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (Answer3.isPressed()) {
					Answer1.setBackgroundColor(Color.YELLOW);
					Answer2.setBackgroundColor(Color.YELLOW);
					Answer3.setBackgroundColor(Color.RED);
					Answer4.setBackgroundColor(Color.YELLOW);
				}
				// set arrow to visible
				btn.setVisibility(View.VISIBLE);
			}
		});

		Answer4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (Answer4.isPressed()) {
					Answer1.setBackgroundColor(Color.YELLOW);
					Answer2.setBackgroundColor(Color.YELLOW);
					Answer3.setBackgroundColor(Color.YELLOW);
					Answer4.setBackgroundColor(Color.RED);
					numberAnsweredCorrectlyByQ4 = numberAnsweredCorrectlyBy3+1;
				}
				// set arrow to visible
				btn.setVisibility(View.VISIBLE);
			}
		});

		// method to navigate to next page
		nextPageButton();

	}

	/**
	 * Countdown timer method - from 30 seconds
	 */
	public void countDown() {
		// create timer Text view and link to xml
		timer = (TextView) findViewById(R.id.timer);

		// create timer function
		new CountDownTimer(30000, 1000) {
			@Override
			public void onTick(long millSecs) {

				timer.setText("" + millSecs / 1000);
			}

			public void onFinish() {
				timer.setText("!");
			}
		}.start();
	}

	/**
	 * Method to change screen after arrow is pressed
	 */
	private void nextPageButton() {
		
		ImageButton btn = (ImageButton) findViewById(R.id.next_page);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent changeScreen = new Intent(Maths3to5Q4.this,
						Maths3to5Q5.class);
				startActivity(changeScreen);
			}
		});
	}
}
