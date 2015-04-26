package maths3to5;

/**
 * import resources
 */
import com.example.quizforkids.MainActivity;
import com.example.quizforkids.R;
import com.example.quizforkids.Age3to5Results;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Class for the 5th Question in the Maths round of the 3to5yr old
 * @author chrismcclune
 *
 */
public class Maths3to5Q5 extends MainActivity {

	/**
	 * Button for answer 1
	 */
	static Button Answer1;
	
	/**
	 * Button for answer 2
	 */
	static Button Answer2;
	
	/**
	 * Button for answer 3
	 */
	static Button Answer3;
	
	/**
	 * Button for answer 4
	 */
	static Button Answer4;
	
	/**
	 * Button for the next arrow
	 */
	static ImageButton btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maths3to5_q5);
		
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
					// set correct answer boolean
					age3to5answeredCorrectly = true;
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
					// set answer boolean
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
					// set answer boolean
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
					// set answer boolean
					age3to5answeredCorrectly = false;
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
		// assign image to the green tick imageview
		age3to5greentick5 = (ImageView) findViewById(R.id.age3to5greentick5);
		
		ImageButton btn = (ImageButton) findViewById(R.id.next_page);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(age3to5answeredCorrectly == true){
					// assign the correct answer
					Age3to5Results.age3to5Q5AnsweredCorrectly = true;
				} else if (age3to5answeredCorrectly == false){
					// assign the incorrect answer
					Age3to5Results.age3to5Q5AnsweredCorrectly = false;
				}
				update3to5Score();
				countDownTimer.cancel();
				// Intent to change screen to the results screen
				Intent changeScreen = new Intent(Maths3to5Q5.this,
						Age3to5Results.class);
				
				startActivity(changeScreen);
			}
		});
	}
	
	/**
	 * Method to disable the back key on device so user cannot restart level until all are finished
	 */
	@Override
	public void onBackPressed(){
		//super.onBackPressed();
	}
}
