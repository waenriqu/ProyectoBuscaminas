package com.example.buscaminasremix;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/**
 * Clase que hereda de ResultScreen e implementa los métodos addPuntuacion() y 
 * updateRanking() para poder gestionar exclusivamente las puntuaciones que le pertenecen
 * al modo normal.
 * 
 * @author      Gabriel Aumala
 */
public class ResultScreenNormal extends ResultScreen {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_result_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result_screen_normal, menu);
		return true;
	}
	@Override
	public void addPuntuacion(View view){
		if(!finish){
			EditText et = (EditText) findViewById(R.id.edit_message);
			jugador = new Jugador(et.getText().toString(), tiempo, ResultScreenNormal.this);
			jugador.guardarPuntuacionNormal();
			updateRanking();
			finish = true;
		}
	}
	
public void updateRanking(){
	int cont = 0;
	TextView nombresview = (TextView)findViewById(R.id.nombrelist);
	TextView tiemposview = (TextView)findViewById(R.id.tiempolist);
	String nombres = "";
	String tiempos = "";
	ArrayList<Jugador> list = jugador.cargarPuntuacionNormal();
	for(Jugador j:list){
		if(cont<10){
			nombres = nombres + j.getNombre() + '\n';
			tiempos = tiempos + j.getTiempo() + '\n';
			cont++;
		}
	}
	nombresview.setText((CharSequence)nombres);
	tiemposview.setText((CharSequence)tiempos);
	nombresview.invalidate();
	tiemposview.invalidate();
}

}
