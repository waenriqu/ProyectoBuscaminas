package com.example.buscaminasremix;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class ModoDificil extends ModoPadre {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_dificilscroll);
		nMinas = 99;
		@SuppressWarnings("deprecation")
		final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
	    if (data == null) {
	        relojTask = new Reloj(this);
	        tableroAdapter = new TableroDificil(this, showTheMetrics());
	        cambiarContentViews();
	    } else{
	    	relojTask = new Reloj(this, data.getCont());
	    	tableroAdapter = new TableroDificil(this, showTheMetrics(), data.getBoard(), data.getGraphics(), data.getRevelados());
	    	cambiarContentViews();
	    	TextView relojview = (TextView) findViewById(R.id.tiempoview);
	    	relojview.setText(data.getTime());
	    	finish = data.getFinish();
	    	if(!finish){
	    	startTimer();
	    	}else{
	    		actualizarCarita(tableroAdapter.isVictoria());
	    	}
	    	start = true;
	    	relojview.invalidate();
	    }
			
		gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(tableroAdapter);
		
	    if(!finish){
			setListeners();
			}else{
	    		actualizarCarita(tableroAdapter.isVictoria());
	    	}
	    
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modo_dificil, menu);
		return true;
	}
	
	
	public void resetGame(View view){
		Intent intent = new Intent(this, ModoDificil.class);
		deleteMP();
		startActivity(intent);
		finish();
	}

	@Override
	@SuppressLint("NewApi")
	public void gravityCenterAPI16() {
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		if((showTheMetrics())*(tableroAdapter.getDistX()) < width){
			setContentView(R.layout.activity_modo_dificil);
		}	
	}

	@Override
	public void gravityCenterAPI8() {
		Display display = getWindowManager().getDefaultDisplay(); 
		@SuppressWarnings("deprecation")
		int width = display.getWidth();  // deprecated
		if((showTheMetrics())*(tableroAdapter.getDistX()) < width){
			setContentView(R.layout.activity_modo_dificil);
			
		}
		
	}
	

}
