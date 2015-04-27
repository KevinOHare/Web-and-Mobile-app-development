package com.example.quizforkids;

import english5to7.English5to7Q1;
import maths5to7.Maths5to7Q1;
import shapes5to7.Shapes5to7Q1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelSelect5to7 extends MainActivity {
	
	/**
	 * Button instance level 1
	 */
	static Button level1;
	
	/**
	 * Button instance level 2
	 */
	static Button level2;
	
	/**
	 * Button instance level 3
	 */
	static Button level3;
	
	/**
	 * Button instance mainpage
	 */
	static Button mainpage;

	/**
	 * On create method to populate the level select 5 to 7 page
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// call on superclass state
		super.onCreate(savedInstanceState);
		// set the view from the xml
		setContentView(R.layout.activity_level_select5to7);

		// Create button objects for the page
		level1 = (Button) findViewById(R.id.level_1_button);
		//Create button object for the page
		level2 = (Button) findViewById(R.id.level_2_button);
		//Create button object for the page
		level3 = (Button) findViewById(R.id.level_3_button);
		//Create button object for the page
		mainpage = (Button) findViewById(R.id.mainpage_button);

		// if statement to unlock levels after previous has been completed and gold medal achieved for age 5 to 7
		if (Age5to7Results.age5to7Level1CurrentHighscore > 199){
			// allow access to level 2
			LevelSelect5to7.level2.setEnabled(true);
		} else {
			// deny access to level 2
			LevelSelect5to7.level2.setEnabled(false);
		}
		if (Age5to7Results.age5to7Level2CurrentHighscore > 199){
			// allow access to level 3
			LevelSelect5to7.level3.setEnabled(true);
		} else {
			// deny access to level 3
			LevelSelect5to7.level3.setEnabled(false);
		}
		
		// Create listener for Level 1 button
		level1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// check if level 1 is selected
				level1Selected = true;
				level2Selected = false;
				level3Selected = false;
				// Create intent to switch to the first Question in level 1
				Intent q1SwitchLevel1 = new Intent(LevelSelect5to7.this,
						Maths5to7Q1.class);
				// open the new view
				startActivity(q1SwitchLevel1);
			}
		});

		// Create listener for level 2 button
		level2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// check if level 2 is selected
				level1Selected = false;
				level2Selected = true;
				level3Selected = false;
				// Create intent to switch to the first Question in level 2
				Intent q1SwitchLevel2 = new Intent(LevelSelect5to7.this,
						English5to7Q1.class);
				// open the new view
				startActivity(q1SwitchLevel2);
			}
		});

		// Create listener for level 3 button
		level3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// check if level 3 is selected
				level1Selected = false;
				level2Selected = false;
				level3Selected = true;
				// Create intent to switch to the first Question in level 3
				Intent q1SwitchLevel3 = new Intent(LevelSelect5to7.this,
						Shapes5to7Q1.class);
				// open the new view
				startActivity(q1SwitchLevel3);
			}
		});
		
		// Create listener for main page button
		mainpage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Create intent to switch to the main page
				Intent mainpageSwitch = new Intent(LevelSelect5to7.this, MainActivity.class);
				// open the new view
				startActivity(mainpageSwitch);
			}
		});
	}
}
