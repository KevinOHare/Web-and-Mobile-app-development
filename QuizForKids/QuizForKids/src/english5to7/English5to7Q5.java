package english5to7;

import com.example.quizforkids.R;
import com.example.quizforkids.Results;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class English5to7Q5 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_english5to7_q5);
	
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
				Intent changeScreen = new Intent(English5to7Q5.this,
						Results.class);
				startActivity(changeScreen);
			}
		});
	}
}
