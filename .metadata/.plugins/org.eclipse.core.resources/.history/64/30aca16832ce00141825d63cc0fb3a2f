package com.example.quizforkids;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends Activity {
	

	TextView questionscore = (TextView) findViewById(R.id.questionscore);
	TextView timescore = (TextView) findViewById(R.id.timescore);
	TextView totalscore = (TextView) findViewById(R.id.totalscore);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		int intquestionscore = Integer.parseInt(questionscore.getText().toString());
		int inttimescore = Integer.parseInt(timescore.getText().toString());
		
		int inttotalscore = intquestionscore + inttimescore;
		
		totalscore.setText(inttotalscore);

		// Integer total = Integer.valueOf((String) questionscore.getText())
		// + Integer.valueOf((String) timescore.getText());

		// calculateTotal();

	}

}
