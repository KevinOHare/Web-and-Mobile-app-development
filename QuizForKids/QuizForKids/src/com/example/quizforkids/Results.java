package com.example.quizforkids;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends Activity {
	
	public static int numberCorrect = 0;
	
	TextView questionscore;
	
	//TextView timescore = (TextView) findViewById(R.id.timescore);
	//TextView totalscore = (TextView) findViewById(R.id.totalscore);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		questionscore = (TextView) findViewById(R.id.questionscore);
		
		questionscore.setText(Integer.toString(numberCorrect*30));
	}
	
}
