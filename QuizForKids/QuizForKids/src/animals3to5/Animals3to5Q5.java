package animals3to5;

import com.example.quizforkids.R;
import com.example.quizforkids.Results;

import english5to7.English5to7Q1;
import english5to7.English5to7Q2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Animals3to5Q5 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animals3to5_q5);
	
		nextPageButton();
	}

	/**
	 * Method to change screen after arrow is pressed
	 */
	private void nextPageButton() {
		
		ImageButton btn = (ImageButton) findViewById(R.id.next_page);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent changeScreen = new Intent(Animals3to5Q5.this,
						Results.class);
				startActivity(changeScreen);
			}
		});
	}
}
