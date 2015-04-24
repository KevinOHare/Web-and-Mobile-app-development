package maths3to5;

import com.example.quizforkids.Age3to5Results;
import com.example.quizforkids.MainActivity;
import com.example.quizforkids.R;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Maths3to5Q3 extends MainActivity {

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
		setContentView(R.layout.activity_maths3to5_q3);
		
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
					Answer1.setBackgroundColor(Color.WHITE);
					Answer2.setBackgroundColor(Color.YELLOW);
					Answer3.setBackgroundColor(Color.YELLOW);
					Answer4.setBackgroundColor(Color.YELLOW);
					age3to5answeredCorrectly = false;
				}
				// set arrow to visible
				btn.setVisibility(View.VISIBLE);
			}
		});

		Answer2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (Answer2.isPressed()) {
					Answer1.setBackgroundColor(Color.YELLOW);
					Answer2.setBackgroundColor(Color.WHITE);
					Answer3.setBackgroundColor(Color.YELLOW);
					Answer4.setBackgroundColor(Color.YELLOW);
					age3to5answeredCorrectly = false;
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
					Answer3.setBackgroundColor(Color.WHITE);
					Answer4.setBackgroundColor(Color.YELLOW);
					age3to5answeredCorrectly = false;
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
					Answer4.setBackgroundColor(Color.WHITE);
					age3to5answeredCorrectly = true;
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
		
		age3to5greentick3 = (ImageView) findViewById(R.id.age3to5greentick3);
		
		ImageButton btn = (ImageButton) findViewById(R.id.next_page);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(age3to5answeredCorrectly == true){
					Age3to5Results.age3to5Q3AnsweredCorrectly = true;
				} else if (age3to5answeredCorrectly == false){
					Age3to5Results.age3to5Q3AnsweredCorrectly = false;
				}
				update3to5Score();
				countDownTimer.cancel();
				Intent changeScreen = new Intent(Maths3to5Q3.this,
						Maths3to5Q4.class);
				
				startActivity(changeScreen);
			}
		});
	}
	
	@Override
	public void onBackPressed(){
		//super.onBackPressed();
	}
}
