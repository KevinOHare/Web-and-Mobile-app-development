package com.example.quizforkids;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);

		calculateTotal();
		
	}
	
	private void calculateTotal() {
		
		TextView questionscore = (TextView) findViewById(R.id.questionscore);
		TextView timescore = (TextView) findViewById(R.id.timescore);
		TextView totalscore = (TextView) findViewById(R.id.totalscore);
		
		Integer total = Integer.valueOf(questionscore.getText().toString())
				+ Integer.valueOf(timescore.getText().toString());

		totalscore.setText(total.toString());		
	}
	
}
