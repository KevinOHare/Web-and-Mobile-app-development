package shapes3to5;

import maths5to7.Maths5to7Q1;
import maths5to7.Maths5to7Q2;

import com.example.quizforkids.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Shapes3to5Q1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shapes3to5_q1);
	
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
				Intent changeScreen = new Intent(Shapes3to5Q1.this,
						Shapes3to5Q2.class);
				startActivity(changeScreen);
			}
		});
	}
}
