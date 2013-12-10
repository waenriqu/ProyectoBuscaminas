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
/**
 * ModoFácil hereda de ModoPadre. Simplemente se encarga de inicializar el juego
 * de acuerdo a las carecterísticas del modo fácil siguiendo el procedimiento
 * modelado por los métodos de ModoPadre.
 * 
 * @author      Gabriel Aumala
 * @author		Wilson Enriquez
 */
public class ModoFacil extends ModoPadre {

	/**
	 * Inicializa el modo fácil. Asigna el número de minas pertinente. Revisa si hay datos guardados
	 * que se deben de cargar, de lo contrario crea todos los objetos como el reloj y el tablero y los
	 * inicializa. También decide si es necesario usar barras de scrolling horizontal. Si la partida no 
	 * ha terminado coloca los listeners de Click y LongClick.
	 * @param  savedInstanceState Bundle con los últimos datos suministrados
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_facilscroll);
		nMinas = 9;
		@SuppressWarnings("deprecation")
		final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
	    if (data == null) {
	        relojTask = new Reloj(this);
	        tableroAdapter = new TableroFacil(this, showTheMetrics());
			cambiarContentViews();
	    } else{
	    	relojTask = new Reloj(this, data.getCont());
	    	tableroAdapter = new TableroFacil(this, showTheMetrics(), data.getBoard(), data.getGraphics(), data.getRevelados());
			cambiarContentViews();
			TextView relojview = (TextView) findViewById(R.id.tiempoview);
			relojview.setText(data.getTime());
	    	finish = data.getFinish();
	    	if(!finish){
	    	startTimer();
	    	} else{
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
		getMenuInflater().inflate(R.menu.modo_facil, menu);
		return true;
	}
	/**
	 * Resetea el juego. Comienza una nueva actividad idéntica a esta, pero antes
	 *　libera la memoria de los efectos de sonidos y cierra la actividad actual.
	 * @param  view El view al cual se le dio click
	 */
	public void resetGame(View view){
		Intent intent = new Intent(this, ModoFacil.class);
		deleteMP();
		startActivity(intent);
		finish();
	}
	/**
	 * Funcion que decide si debe de cambiar el layout a uno sin scrollBar horizontal
	 * tras haber determinado que la pantalla tiene el tamaño necesario. La función necesita
	 * un API mayor o igual a 16 para verificar el tamaño de la pantalla antes de cambiar
	 * el layout.
	 */
	@Override
	@SuppressLint("NewApi")
	public void gravityCenterAPI16() {
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		if((showTheMetrics())*(tableroAdapter.getDistX()) < width){
			setContentView(R.layout.activity_modo_facil);
		}		
	}
	/**
	 * Funcion que decide si debe de cambiar el layout a uno sin scrollBar horizontal
	 * tras haber determinado que la pantalla tiene el tamaño necesario. La función necesita
	 * un API mayor o igual a 8 para verificar el tamaño de la pantalla antes de cambiar
	 * el layout.
	 */
	@Override
	public void gravityCenterAPI8() {
		Display display = getWindowManager().getDefaultDisplay(); 
		@SuppressWarnings("deprecation")
		int width = display.getWidth();  // deprecated
		if((showTheMetrics())*(tableroAdapter.getDistX()) < width){
			setContentView(R.layout.activity_modo_facil);
		}
		
	}
	

}