package org.example.sudoku;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class SudokuActivity extends Activity implements OnClickListener {

	public static final String TAG = "Sudoku";

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
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_sudoku, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.menu_settings:
			startActivity(new Intent(this, Prefs.class));
		}
		return false;
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.about_button:
			Intent i = new Intent(this, AboutActivity.class);
			startActivity(i);
			break;
		case R.id.new_game_button:
			openNewGameDialog();
			break;
		case R.id.exit_button:
			finish();
			break;
		}
	}
	
	private void openNewGameDialog() {
		new AlertDialog.Builder(this)
			.setTitle(R.string.new_game_title)
			.setItems(R.array.difficulty,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialogInterface, int i) {
							startGame(i);
						}
					})
					.show();
		
	}
	
	private void startGame(int level){
		Log.d(TAG, "Starting with difficulty: " + level);
	}
}
