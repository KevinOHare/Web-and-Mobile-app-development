package com.example.quizforkids;

import english5to7.English5to7Q1;
import maths5to7.Maths5to7Q1;
import shapes5to7.Shapes5to7Q1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelSelect5to7 extends MainActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level_select5to7);

		// Create button objects for the page
		final Button level1 = (Button) findViewById(R.id.level_1_button);
		final Button level2 = (Button) findViewById(R.id.level_2_button);
		final Button level3 = (Button) findViewById(R.id.level_3_button);

		// Set level 1 and 2 buttons to be not clickable until previous level is
		// complete
		//level2.setEnabled(false);
		//level3.setEnabled(false);

		// Create listener for Level 1 button
		level1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				level1Selected = true;
				// Create intent to switch to the first Question in level 1
				Intent q1SwitchLevel1 = new Intent(LevelSelect5to7.this,
						Maths5to7Q1.class);
				startActivity(q1SwitchLevel1);
			}
		});

		// Create listener for level 2 button
		level2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				level2Selected = true;
				// Create intent to switch to the first Question in level 2
				Intent q1SwitchLevel2 = new Intent(LevelSelect5to7.this,
						English5to7Q1.class);
				startActivity(q1SwitchLevel2);
			}
		});

		// Create listener for level 3 button
		level3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				level3Selected = true;
				// Create intent to switch to the first Question in level 3
				Intent q1SwitchLevel3 = new Intent(LevelSelect5to7.this,
						Shapes5to7Q1.class);
				startActivity(q1SwitchLevel3);
			}
		});
	}
}
