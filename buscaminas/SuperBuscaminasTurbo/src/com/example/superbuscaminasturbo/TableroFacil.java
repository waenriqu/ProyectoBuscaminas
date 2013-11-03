package com.example.superbuscaminasturbo;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class TableroFacil extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tablero_facil);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tablero_facil, menu);
		return true;
	}

}
