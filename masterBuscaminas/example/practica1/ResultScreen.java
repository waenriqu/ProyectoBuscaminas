package com.example.buscaminasremix;

import java.util.ArrayList;
import java.util.Vector;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * ResultScreen es una clase abstracta que pertence a la actividad que le pide al
 * usuario que ingrese por pantalla sus datos para agregarlo al ranking y posteriormente
 * mostrarle las puntuaciones más altas que se han alcanzado por los jugadores anteriores.
 * Las clases ResultScreenDificil, ResultScreenFacil, ResultScreenNormal y ResultScreenRemix
 * heredan de esta, ya que el procedimiento y el layout son los mismo pero cada actividad 
 * trabaja con diferentes archivos.
 * 
 * @author      Gabriel Aumala
 */
public abstract class ResultScreen extends Activity {
String tiempo;
Jugador jugador;
Boolean finish = false;
/**
 * Al crearse la actividad verifica si hay datos que cargar. Si no los hay crea objetos nuevos.
 * Si hay datos que cargar los debe de mostrar en la pantalla tal como en la instancia anterior y 
 * ya no debe de permitir que el usuario ingrese más puntuaciones. También consigue el el dato del
 * tiempo del jugador de la activiidad anterior.
 * * @param  savedInstanceState Bundle con los últimos datos suministrados
 * 
 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_screen);
		 Intent intent = getIntent();
		 tiempo = intent.getStringExtra(ModoPadre.TIEMPO_MESSAGE);
		 final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
		    if (data != null) {
		        finish = data.getFinish();
		        jugador = new Jugador("NO ONE", "INFINITY", ResultScreen.this);
		        updateRanking();
		       
		    } 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.result_screen, menu);
		return true;
	}
	/**
	 * Clase abstracta que tras hacer click en el botón, guarda la información del jugador en el archivo
	 * de las puntuaciones. Cada dificultad debe de implementar este método pues cada uno usa archivos diferentes.
	 *@param view El view donde se dio el click
	 */
	public abstract void addPuntuacion(View view);
	/**
	 * Clase abstracta que actualiza las puntuaciones que se muestran por pantalla. Estas puntuaciones se guardan en
	 * los respectivos archivos de cada dificultad. Cada dificultad debe de implementar este método pues cada uno usa archivos diferentes.
	 */
	public abstract void updateRanking();
	/**
	 * Guarda los datos necesarios antes de realizar los cambios de configuración. Estos datos son el boolean 'finish'
	 * que indica si el jugador ya ingresó sus datos. Es esencial para evitar que el jugador ingrese más de una
	 * puntuación; Los nombres y tiempos que se han impreso por pantalla en lista que forman parte del ranking. Sólo se
	 * pueden guardar datos si el jugador ya terminó de ingresar sus datos.
	 */
	public Object onRetainNonConfigurationInstance() {
		if(!finish){
			return null;
		}
		TextView nombres = (TextView) findViewById(R.id.nombrelist);
		TextView tiempos = (TextView) findViewById(R.id.tiempolist);
	    final CargarDatos data = new CargarDatos(finish,nombres.getText().toString(),tiempos.getText().toString());
	    return data;
	}

}
