package com.example.practica1;


import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class ModoDificil extends modoPadre {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_dificil);
		nMinas = 99;
		@SuppressWarnings("deprecation")
		final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
	    if (data == null) {
	        relojTask = new Reloj(this);
	        tableroAdapter = new TableroDificil(this, showTheMetrics());
	    } else{
	    	TextView relojview = (TextView) findViewById(R.id.tiempoview);
	    	relojTask = new Reloj(this, data.getCont());
	    	tableroAdapter = new TableroDificil(this, showTheMetrics(), data.getBoard(), data.getGraphics());
	    	relojview.setText(data.getTime());
	    	perdiste = data.getPerdiste();
	    	if(!perdiste){
	    	startTimer();
	    	}
	    	start = true;
	    	relojview.invalidate();
	    }
			
		gridview = (GridView) findViewById(R.id.gridview);
			
	    gridview.setAdapter(tableroAdapter);

	    if(!perdiste){
			setListeners();
			}
	    
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_demo, menu);
		return true;
	}
	
	
	public void resetGame(View view){
		Intent intent = new Intent(this, ModoDificil.class);
		startActivity(intent);
		finish();
	}

}
