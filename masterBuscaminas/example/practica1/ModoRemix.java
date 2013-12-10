package com.example.buscaminasremix;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
/**
 * ModoRemix hereda de ModoPadre. Se encarga de inicializar el juego
 * de acuerdo a las carecterísticas del modo Remix siguiendo el procedimiento
 * modelado por los métodos de ModoPadre hasta cierto punto. Agrega algunas
 * mécanicas que son exclusivas del modo Remix. Este modo introduce una barra
 * de combos que al revelar una celda se llena al 100%, luego de eso, la barra
 * va disminuyendo periódicamente hasta cero. Le toma 5 segundos caer a cero, y
 * tras caer a cero se resetea el combo. El jugador debe de tratar de prolongar
 * su combo lo más que pueda, pues cada 15 hits se le premia con una vida que
 * le permite revelar minas sin perder el juego. 
 * 
 * @author      Gabriel Aumala
 * @author		Wilson Enriquez
 */
public class ModoRemix extends ModoPadre{
int combo = 0, vidas = 0;

	
/**
 * Inicializa el modo remix. Asigna el número de minas pertinente. Revisa si hay datos guardados
 * que se deben de cargar, de lo contrario crea todos los objetos como el reloj y el tablero y los
 * inicializa. También decide si es necesario usar barras de scrolling horizontal. Si la partida no 
 * ha terminado coloca los listeners de Click y LongClick.
 * @param  savedInstanceState Bundle con los últimos datos suministrados
 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_remix);
		nMinas = 99;
		mpDeactivate = newAudio(audioDeactivate);
		@SuppressWarnings("deprecation")
		final CargarDatos data = (CargarDatos) getLastNonConfigurationInstance();
	    if (data == null) {
	        relojTask = new RelojBarrier(this);
	        tableroAdapter = new TableroDificil(this, showTheMetrics());
	    } else{
	    	relojTask = new RelojBarrier(this, data.getCont(), data.getBarrier());
	    	tableroAdapter = new TableroDificil(this, showTheMetrics(), data.getBoard(), data.getGraphics(), data.getRevelados());
	    	TextView relojview = (TextView) findViewById(R.id.tiempoview);
	    	vidas = data.getVidas()-1;
			combo = data.getCombo()-1;
			updateVidas();
			updateComboAtStart();
	    	relojview.setText(data.getTime());
	    	finish = data.getFinish();
	    	relojTask.updateBarrier();
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

	private void setRemixedListeners() {
		gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            //Toast.makeText(GridDemo.this, "" + position, Toast.LENGTH_SHORT).show();
	            if (!start){
	            tableroAdapter.generaMina(position);
	            startTimer();
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
	            	detenerJuego();
	            	actualizarCarita(true);
	            	playAudio(mpVictoria);
	            	//resultScreen();
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modo_remix, menu);
		return true;
	}
	
	/**
	 * Resetea el juego. Comienza una nueva actividad idéntica a esta, pero antes
	 *　libera la memoria de los efectos de sonidos y cierra la actividad actual.
	 * @param  view El view al cual se le dio click
	 */
	public void resetGame(View view){
		Intent intent = new Intent(this, ModoRemix.class);
		deleteMP();
		startActivity(intent);
		finish();
	}
	/**
	 * Funcion que decide si debe de cambiar el layout a uno sin scrollBar horizontal
	 * tras haber determinado que la pantalla tiene el tamaño necesario. La función necesita
	 * un API mayor o igual a 16 para verificar el tamaño de la pantalla antes de cambiar
	 * el layout. No hace nada ya que el modo remix no tiene soporte para scrollBars horizotales
	 * ya que es exclusivo para tablets.
	 */
	@Override
	@SuppressLint("NewApi")
	public void gravityCenterAPI16() {
		//nada	
	}
	/**
	 * Funcion que decide si debe de cambiar el layout a uno sin scrollBar horizontal
	 * tras haber determinado que la pantalla tiene el tamaño necesario. La función necesita
	 * un API mayor o igual a 8 para verificar el tamaño de la pantalla antes de cambiar
	 * el layout. No hace nada ya que el modo remix no tiene soporte para scrollBars horizotales
	 * ya que es exclusivo para tablets.
	 */
	@Override
	public void gravityCenterAPI8() {
		//nada
	}
	/**
	 * Función que resetea el contador de combos, lo coloca en cero, y actualiza el view.
	 */
	public void resetCombo(){
		TextView t = (TextView) findViewById(R.id.combo);
		combo = 0;
		t.setText(R.string.comboempty);
		t.invalidate();
	}
	/**
	 * Función que actualiza el contador de combos, lo aumenta en una unidad, y actualiza el view.
	 * Si el contador supera el valor de 15, actualiza el número de vidas.
	 */
	public void updateCombo(){
		TextView t = (TextView) findViewById(R.id.combo);
		t.setText("" + ++combo + " Hits!");
		if(combo == 1){
			t.setText("1 Hit!");
		}
		if(combo>0 && combo%15 == 0){
			updateVidas();
		}
		
		t.invalidate();
	}
	/**
	 * Función que hace lo mismo que updateCombo pero no actualiza las vidas ya que esta función
	 * se usará al comienzo de la actividad tras haber realizado un cambio de configuración y es necesario
	 * poner asignarle el valor guardado de contador de combos al view sin actualizar vidas ya que sólo es
	 * un cambio de configuración.
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
	 * Función que actualiza el contador de vidas, lo incrementa en una unidad y actualiza el view.
	 */
	public void updateVidas(){
		TextView t = (TextView) findViewById(R.id.multiplier);
		t.setText("x" + ++vidas);
	}
	/**
	 * Función que actualiza el contador de vidas, disminuyéndolo en una unidad y actualiza el view.
	 */
	public void gastarVidas(){
		TextView t = (TextView) findViewById(R.id.multiplier);
		t.setText("x" + --vidas);
	}
	/**
	 * Función que libera la memora de los reproductores de efectos de sonidos exclusivos del modo remix 
	 * y los que comparte con los modos clásicos.
	 */
	public void deleteMP(){
		super.deleteMP();
		if(mpDeactivate != null){
			mpDeactivate.stop();
			mpDeactivate.release();
		}
	}
	/**
	 * Función que controla lo que se hace al pulsar la tecla 'back'. Se libera la memoria de los 
	 * efectos de sonidos y se cierra la actividad.
	 */
	@Override
	public void onBackPressed() {
	    deleteMP();
	    finish();
	    return;
	}  
	/**
	 * Retorna un objeto de la clase cargarDatos que guarda toda la información importante del 
	 * modo remix antes de un cambio de configuración y libera la memoria de los efectos de sonido.
	 * @return un objeto de la clase cargarDatos, si la partida aún no empieza retorna null
	 */
	@Override
	public Object onRetainNonConfigurationInstance() {
		TextView marcador = (TextView) findViewById(R.id.tiempoview);
		deleteMP();
		if(!start){
			return null;
		}
	    final CargarDatos data = new CargarDatos(relojTask.getCont(),marcador.getText(),tableroAdapter.getTablero(), tableroAdapter.getGraphics(), finish, tableroAdapter.revelados,
	    		vidas, relojTask.getBarrier(), combo);
	    return data;
	}
}
	
	

