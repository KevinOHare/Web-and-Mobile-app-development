package animals3to5;

import com.example.quizforkids.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Animals3to5Q1 extends Activity {
	
	Button Answer1 = (Button) findViewById(R.id.button1);
	Button Answer2 = (Button) findViewById(R.id.button2);
	Button Answer3 = (Button) findViewById(R.id.button3);
	Button Answer4 = (Button) findViewById(R.id.button4);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animals3to5_q1);
		
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
				Intent changeScreen = new Intent(Animals3to5Q1.this,
						Animals3to5Q2.class);
				startActivity(changeScreen);
			}
		});
	}
	
}
