package maths5to7;

import com.example.quizforkids.MainActivity;
import com.example.quizforkids.R;
import com.example.quizforkids.Results;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Maths5to7Q5 extends MainActivity {

	// Buttons for answers
	static Button Answer1;
	static Button Answer2;
	static Button Answer3;
	static Button Answer4;
	
	// Button for the arrow
	static ImageButton btn;
	
	static boolean answeredCorrectly = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maths5to7_q5);
		
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
					answeredCorrectly = false;
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
					answeredCorrectly = false;
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
					answeredCorrectly = false;
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
					answeredCorrectly = true;
				}
				// set arrow to visible
				btn.setVisibility(View.VISIBLE);
			}
		});

		// method to navigate to next page
		nextPageButton();

	}

	/**
	 * Method to change screen after arrow is pressed
	 */
	private void nextPageButton() {
		
		ImageButton btn = (ImageButton) findViewById(R.id.next_page);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateScore();
				countDownTimer.cancel();
				Intent changeScreen = new Intent(Maths5to7Q5.this,
						Results.class);
				startActivity(changeScreen);
			}
		});
	}
	
	@Override
	public void onBackPressed(){
		//super.onBackPressed();
	}
}
