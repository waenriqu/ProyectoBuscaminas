package com.example.buscaminasremix;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
/**
 * Esta clase es la primera actividad que ve el usuario al comenzar la
 * aplicación. Muestra un menu de todos los modos de juego, para que con un
 * click elija que en cual quiere jugar.
 * 
 * @author      Gabriel Aumala
 * @author		Wilson Enriquez
 */
public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.practica1.MESSAGE";
	/**
	 * Coloca el layout de la actividad principal justo despues de ser creada.
	 */
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
	
	/**
	 * Comienza el modo fácil cuando el usuario le da click al botón de modo fácil.
	 * @param  view  el view al que se le dió click
	 */
	public void modoFacil(View view) {
		Intent intent = new Intent(this, ModoFacil.class);
		startActivity(intent);
		
	}
	/**
	 * Comienza el modo normal cuando el usuario le da click al botón de modo normal.
	 * @param  view  el view al que se le dió click
	 */
	public void modoNormal(View view) {
		Intent intent = new Intent(this, ModoNormal.class);
		startActivity(intent);
		
	}
	/**
	 * Comienza el modo dificil cuando el usuario le da click al botón de modo dificil.
	 * @param  view  el view al que se le dió click
	 */
	public void modoDificil(View view) {
		Intent intent = new Intent(this, ModoDificil.class);
		startActivity(intent);
		
	}
	/**
	 * Comienza el modo remix cuando el usuario le da click al botón de modo remix.
	 * @param  view  el view al que se le dió click
	 */
	public void modoRemix(View view) {
		Intent intent = new Intent(this, ModoRemix.class);
		startActivity(intent);
		
	}
	
	public void modoSurvival(View view) {
		Intent intent = new Intent(this, ModoSurvival.class);
		startActivity(intent);
		
	}
	
	public void rankings(View view) {
		Intent intent = new Intent(this, ConsultResults.class);
		startActivity(intent);
		
	}

}
