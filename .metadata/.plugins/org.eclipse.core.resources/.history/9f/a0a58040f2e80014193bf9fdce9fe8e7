package com.example.quizforkids;

import com.example.quizforkids.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HighscoreAgeSelect extends Activity {
	
	static boolean age3to5Selected = false;
	static boolean age5to7Selected = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_age);

		// Create button for 3-5 button
		final Button age3to5 = (Button) findViewById(R.id.ages3_5yrs);
		final Button age5to7 = (Button) findViewById(R.id.ages5_7yrs);

		// Create button listener for lower age group
		age3to5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				age3to5Selected = true;

				// Create intent to change screen on click
				Intent pageSwitch3to5 = new Intent(HighscoreAgeSelect.this,
						LevelSelect3to5.class);
				startActivity(pageSwitch3to5);

			}
		});

		// Create button listener for upper age group
		age5to7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				age5to7Selected = true;
				
				Intent pageSwitch5to7 = new Intent(HighscoreAgeSelect.this,
						LevelSelect5to7.class);
				startActivity(pageSwitch5to7);

			}
		});
	}
}
