package com.example.buscaminasremix;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultScreenSurvival extends  Activity{
private Jugador_S js;
private String tiempo;
private boolean finish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_message);
		 Intent intent = getIntent();
		
		 tiempo = intent.getStringExtra(ModoPadre.TIEMPO_MESSAGE);
		 final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
		    if (data != null) {
		    	setContentView(R.layout.activity_result_screen);
		        finish = data.getFinish();
		        js = new Jugador_S("NO ONE", "INFINITY", ResultScreenSurvival.this);
		        updateRanking();
		       
		    } else{
		    	TextView tv1 = (TextView) findViewById(R.id.score);
		    	tv1.setText(tiempo);
		    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result_screen_survival, menu);
		return true;
	}

	public void addPuntuacion(View view) {
		if(!finish){
			EditText et = (EditText) findViewById(R.id.edit_message);
			String myName = et.getText().toString();
			if(et.getText().toString().equals("")){
				return;
			}
			setContentView(R.layout.activity_result_screen);
			js = new Jugador_S(myName, tiempo, ResultScreenSurvival.this);
			js.guardarPuntuacionSurvival();
			updateRanking();
			finish = true;
		}
		
	}

	public void updateRanking() {
		int cont = 0;
		TextView nombresview = (TextView)findViewById(R.id.nombrelist);
		TextView tiemposview = (TextView)findViewById(R.id.tiempolist);
		String nombres = "";
		String tiempos = "";
		ArrayList<Jugador> list = js.cargarPuntuacionSurvival();
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
	
	@Override
	public Object onRetainNonConfigurationInstance() {
		if(!finish){
			return null;
		}
		TextView nombres = (TextView) findViewById(R.id.nombrelist);
		TextView tiempos = (TextView) findViewById(R.id.tiempolist);
	    final CargarDatos data = new CargarDatos(finish,nombres.getText().toString(),tiempos.getText().toString());
	    return data;
	}
	
	public void tweetIt(View view) {
		String diff = getResources().getString(R.string.button_survival);
		String message = "He vencido el modo " + diff + " con una puntuación de " + tiempo + " via Buscaminas Remix";				
    	String tweetUrl = "https://twitter.com/intent/tweet?text=" + Uri.encode(message);
    	new Twitter_Dialog(this, tweetUrl).show();
		
	}

}
