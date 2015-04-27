package com.example.quizforkids;

import com.example.quizforkids.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Class used to select the Highscore age
 * @author Steven
 */
public class HighscoreAgeSelect extends Activity {

	/**
	 * On create method to populate the highscore age select
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// get the super class states
		super.onCreate(savedInstanceState);
		// access layout of the xml needed
		setContentView(R.layout.activity_select_age);

		// Create button for 3-5 button
		final Button age3to5 = (Button) findViewById(R.id.ages3_5yrs);
		// Create button for 5-7 button
		final Button age5to7 = (Button) findViewById(R.id.ages5_7yrs);

		// Create button listener for lower age group
		age3to5.setOnClickListener(new View.OnClickListener() {
			// call method on click
			@Override
			public void onClick(View v) {

				// Create intent to change screen on click
				Intent pageSwitch3to5 = new Intent(HighscoreAgeSelect.this,
						Age3to5Highscore.class);
				// start the activity switch
				startActivity(pageSwitch3to5);

			}
		});

		// Create button listener for upper age group
		age5to7.setOnClickListener(new View.OnClickListener() {
			// call method on click
			@Override
			public void onClick(View v) {
				// Create intent to change screen on click
				Intent pageSwitch5to7 = new Intent(HighscoreAgeSelect.this,
						Age5to7Highscore.class);
				// start the activity switch
				startActivity(pageSwitch5to7);

			}
		});
	}
}
