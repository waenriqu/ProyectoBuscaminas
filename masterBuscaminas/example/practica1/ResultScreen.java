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

public abstract class ResultScreen extends Activity {
String tiempo;
Jugador jugador;
Boolean finish = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_screen);
		 Intent intent = getIntent();
		 tiempo = intent.getStringExtra(ModoPadre.TIEMPO_MESSAGE);
		 final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
		    if (data != null) {
		    	TextView nombres = (TextView) findViewById(R.id.nombrelist);
		    	TextView tiempos = (TextView) findViewById(R.id.tiempolist);
		        finish = data.getFinish();
		        nombres.setText((CharSequence)data.getNombres());
		        tiempos.setText((CharSequence)data.getTiempos());
		        nombres.invalidate();
		        tiempos.invalidate();
		       
		    } 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.result_screen, menu);
		return true;
	}
	
	public abstract void addPuntuacion(View view);
	
	public void updateRanking(){
		
	}
	
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
