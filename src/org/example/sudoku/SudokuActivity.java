package org.example.sudoku;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class SudokuActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sudoku);
		
		
		View continueButton = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
		
		View newGameButton = findViewById(R.id.new_game_button);
		newGameButton.setOnClickListener(this);
		
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);

		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sudoku, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.about_button:
			Intent i = new Intent(this, AboutActivity.class);
			startActivity(i);
			break;
		}
	}

}
