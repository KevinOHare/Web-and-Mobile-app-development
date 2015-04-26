package shapes5to7;

/**
 * import resources
 */
import com.example.quizforkids.Age5to7Results;
import com.example.quizforkids.MainActivity;
import com.example.quizforkids.R;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Class for the 1st Question in the Shapes round of the 5to7yr old
 * @author chrismcclune
 *
 */
public class Shapes5to7Q1 extends MainActivity {

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
		setContentView(R.layout.activity_shapes5to7_q1);

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
					// set answer boolean
					age5to7answeredCorrectly = false;
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
					age5to7answeredCorrectly = false;
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
					age5to7answeredCorrectly = false;
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
					// set correct answer boolean
					age5to7answeredCorrectly = true;
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
		age5to7greentick1 = (ImageView) findViewById(R.id.age5to7greentick1);

		ImageButton btn = (ImageButton) findViewById(R.id.next_page);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (age5to7answeredCorrectly == true) {
					// assign the correct answer
					Age5to7Results.age5to7Q1AnsweredCorrectly = true;
				} else if (age5to7answeredCorrectly == false) {
					// assign the incorrect answer
					Age5to7Results.age5to7Q1AnsweredCorrectly = false;
				}
				update5to7Score();
				countDownTimer.cancel();
				// Intent to change screen to the next question
				Intent changeScreen = new Intent(Shapes5to7Q1.this,
						Shapes5to7Q2.class);
				startActivity(changeScreen);
			}
		});
	}

	/**
	 * Method to disable the back key on device so user cannot restart level until all are finished
	 */
	@Override
	public void onBackPressed() {
		// super.onBackPressed();
	}
}
