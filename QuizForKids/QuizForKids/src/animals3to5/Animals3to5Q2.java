package animals3to5;

import com.example.quizforkids.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Animals3to5Q2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animals3to5_q2);
	
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
				Intent changeScreen = new Intent(Animals3to5Q2.this,
						Animals3to5Q3.class);
				startActivity(changeScreen);
			}
		});
	}
}
