package com.example.buscaminasremix;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

public class ModoSurvival extends ModoPadre {
	int combo = 0, vidas = 2, boards = 0;
	final int oneMore = 12;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_modo_survival);
		mpDeactivate = newAudio(audioDeactivate);
		@SuppressWarnings("deprecation")
		final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
	    if (data == null) {
	        relojTask = new RelojBarrier(this);
	        tableroAdapter = new TableroSurvival(this, showTheMetrics());
	        cambiarContentViews();
	    } else{
	    	relojTask = new RelojBarrier(this, data.getCont(), data.getBarrier());
	    	tableroAdapter = new TableroSurvival(this, showTheMetrics(), data.getBoard(), data.getGraphics(), data.getRevelados());
	    	cambiarContentViews();
	    	TextView relojview = (TextView) findViewById(R.id.tiempoview);
	    	vidas = data.getVidas()-1;
			combo = data.getCombo()-1;
			updateVidas();
			updateComboAtStart();
	    	relojview.setText(data.getTime());
	    	finish = data.getFinish();
	    	relojTask.updateBarrier();
	    	boards = data.getBoards();
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
			setRemixedListeners();
			}else{
	    		actualizarCarita(tableroAdapter.isVictoria());
	    	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modo_survival, menu);
		return true;
	}

	public void resetGame(View view){
		if(start){
			Intent intent = new Intent(this, ModoSurvival.class);
			deleteMP();
			startActivity(intent);
			finish();
		}
	}
	
	protected void setRemixedListeners() {
		gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            //Toast.makeText(GridDemo.this, "" + position, Toast.LENGTH_SHORT).show();
	            if (!start){
	            tableroAdapter.generaMina(position);
		            if(boards == 0){
		            	startTimer();
		            }
	            start = true;
	            }
	            
	            if(!tableroAdapter.getTablero()[position].isOculto()){
	            	return;
	            }
	            if(tableroAdapter.getTablero()[position].getEsMina() && vidas == 0){
	            	tableroAdapter.revelarTodasMinas();
	            	detenerJuego();
	            	actualizarCarita(false);
	            	gridview.invalidateViews();
	            	playAudio(mpDerrota);
	            	resultScreen(boards,tableroAdapter.getRevelados());
	            	return;
	            }  else if(tableroAdapter.getTablero()[position].getEsMina()){
	            	gastarVidas();
	            	playAudio(mpDeactivate);
	            	tableroAdapter.changeImgAfterExplosion(position);
	            	gridview.invalidateViews();
	            	return;
	            }

	            updateCombo();
	            seleccionarNumero(position);
	            gridview.invalidateViews();
	            
	            if(tableroAdapter.isVictoria()){
	            	playAudio(mpVictoria);
	            	nextBoard();
	            }
	            relojTask.subirBarrier();
	        }

	    });
	    
	    gridview.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if(!tableroAdapter.getTablero()[position].isOculto()){
					return true;
				}
				if(tableroAdapter.changeImgAfterLongClickedRemixed(position)){
	            gridview.invalidateViews();
	            playAudio(mpBandera);
	            relojTask.subirBarrierBandera();
				}
				return true;
			}
	    	
	    });
		
	}

	
	
	/**
	 * Funcion que decide si debe de cambiar el layout a uno sin scrollBar horizontal
	 * tras haber determinado que la pantalla tiene el tama necesario. La funci necesita
	 * un API mayor o igual a 16 para verificar el tama de la pantalla antes de cambiar
	 * el layout. No hace nada ya que el modo remix no tiene soporte para scrollBars horizotales
	 * ya que es exclusivo para tablets.
	 */
	@Override
	@SuppressLint("NewApi")
	public void gravityCenterAPI16() {
		/**
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int metrics = showTheMetrics();
		if(metrics*tableroAdapter.getDistX() + 32*metrics/36 < width){
			setContentView(R.layout.activity_modo_remix);			
		} else{
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
		*/
	}
	/**
	 * Funcion que decide si debe de cambiar el layout a uno sin scrollBar horizontal
	 * tras haber determinado que la pantalla tiene el tama necesario. La funci necesita
	 * un API mayor o igual a 8 para verificar el tama de la pantalla antes de cambiar
	 * el layout. No hace nada ya que el modo remix no tiene soporte para scrollBars horizotales
	 * ya que es exclusivo para tablets.
	 */
	@Override
	public void gravityCenterAPI8() {
		Display display = getWindowManager().getDefaultDisplay(); 
		//@SuppressWarnings("deprecation")
		/**
		int width = display.getWidth();  // deprecated
		int metrics = showTheMetrics();
		if(showTheMetrics()*tableroAdapter.getDistX() + 32*metrics/36 < width){
			setContentView(R.layout.activity_modo_remix);
			
		} else{
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
		*/
	}
	/**
	 * Funci que resetea el contador de combos, lo coloca en cero, y actualiza el view.
	 */
	public void resetCombo(){
		TextView t = (TextView) findViewById(R.id.combo);
		combo = 0;
		t.setText(R.string.comboempty);
		t.invalidate();
	}
	/**
	 * Funci que actualiza el contador de combos, lo aumenta en una unidad, y actualiza el view.
	 * Si el contador supera el valor de 15, actualiza el n伹ero de vidas.
	 */
	public void updateCombo(){
		TextView t = (TextView) findViewById(R.id.combo);
		t.setText("" + ++combo + " Hits!");
		if(combo == 1){
			t.setText("1 Hit!");
		}
		if(combo>0 && combo%oneMore == 0){
			updateVidas();
		}
		
		t.invalidate();
	}
	/**
	 * Funci que hace lo mismo que updateCombo pero no actualiza las vidas ya que esta funci
	 * se usar�al comienzo de la actividad tras haber realizado un cambio de configuraci y es necesario
	 * poner asignarle el valor guardado de contador de combos al view sin actualizar vidas ya que so es
	 * un cambio de configuraci.
	 */
	public void updateComboAtStart(){
		TextView t = (TextView) findViewById(R.id.combo);
		t.setText("" + ++combo + " Hits!");
		if(combo == 1){
			t.setText("1 Hit!");
		}
		
		t.invalidate();
	}
	/**
	 * Funci que actualiza el contador de vidas, lo incrementa en una unidad y actualiza el view.
	 */
	public void updateVidas(){
		TextView t = (TextView) findViewById(R.id.multiplier);
		t.setText("x" + ++vidas);
	}
	/**
	 * Funci que actualiza el contador de vidas, disminuy駭dolo en una unidad y actualiza el view.
	 */
	public void gastarVidas(){
		TextView t = (TextView) findViewById(R.id.multiplier);
		t.setText("x" + --vidas);
	}
	/**
	 * Funci que libera la memora de los reproductores de efectos de sonidos exclusivos del modo Survival
	 * y los que comparte con los modos cl疽icos.
	 */
	public void deleteMP(){
		super.deleteMP();
		if(mpDeactivate != null){
			mpDeactivate.stop();
			mpDeactivate.release();
		}
	}
	/**
	 * Funci que controla lo que se hace al pulsar la tecla 'back'. Se libera la memoria de los 
	 * efectos de sonidos y se cierra la actividad.
	 */
	@Override
	public void onBackPressed() {
	    deleteMP();
	    finish();
	    return;
	}  
	/**
	 * Retorna un objeto de la clase cargarDatos que guarda toda la informaci importante del 
	 * modo Survival antes de un cambio de configuraci y libera la memoria de los efectos de sonido.
	 * @return un objeto de la clase cargarDatos, si la partida a佖 no empieza retorna null
	 */
	@Override
	public Object onRetainNonConfigurationInstance() {
		TextView marcador = (TextView) findViewById(R.id.tiempoview);
		deleteMP();
		if(!start){
			return null;
		}
	    final CargarDatos data = new CargarDatos(relojTask.getCont(),marcador.getText(),tableroAdapter.getTablero(), tableroAdapter.getGraphics(), finish, tableroAdapter.revelados,
	    		vidas, relojTask.getBarrier(), combo, boards);
	    return data;
	}
	
	public void nextBoard(){
		boards++;		
        tableroAdapter.resetBoard();
        finish = false;
        start = false;
        if(relojTask.resetClock()){
        	updateVidas();
        }
        gridview.invalidate();
        setNMinasRandomly();
        System.gc();        
        
	}
	
	public void setNMinasRandomly(){
		int r = ((int)(Math.random()*5));
		tableroAdapter.setNMinas();
	}

}
