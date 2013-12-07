package com.example.practica1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.practica1.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user clicks the Send button */
	public void modoFacil(View view) {
		Intent intent = new Intent(this, ModoFacil.class);
		startActivity(intent);
		
	}
	
	public void modoNormal(View view) {
		Intent intent = new Intent(this, ModoNormal.class);
		startActivity(intent);
		
	}
	
	public void modoDificil(View view) {
		Intent intent = new Intent(this, ModoDificil.class);
		startActivity(intent);
		
	}
	
	public void modoRemix(View view) {
		Intent intent = new Intent(this, ModoRemix.class);
		startActivity(intent);
		
	}

}
