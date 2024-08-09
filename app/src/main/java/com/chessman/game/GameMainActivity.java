package com.chessman.game;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.chessman.game.R;


public class GameMainActivity extends Activity {

	private ImageView play;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		play = (ImageView)findViewById(R.id.playBtn);
		play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
				byte playColor = (byte)preferences.getInt("playerColor", Constant.BLACK);
				int difficulty = preferences.getInt("difficulty", 1);

				Intent intent = new Intent(GameMainActivity.this, GameActivity.class);
				Bundle bundle = new Bundle();
				bundle.putByte("playerColor", playColor);
				bundle.putInt("difficulty", difficulty);
				intent.putExtras(bundle);
				startActivity(intent);
				overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
			}
		});
	}

}
