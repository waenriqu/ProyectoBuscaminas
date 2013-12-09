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
import android.widget.Toast;

public class ModoRemix extends ModoPadre{
int combo = 0, vidas = 0;

	
	
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
	        	int revelados1 = tableroAdapter.getRevelados();
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
	
	
	public void resetGame(View view){
		Intent intent = new Intent(this, ModoRemix.class);
		deleteMP();
		startActivity(intent);
		finish();
	}

	@Override
	@SuppressLint("NewApi")
	public void gravityCenterAPI16() {
		//nada	
	}

	@Override
	public void gravityCenterAPI8() {
		//nada
	}
	
	public void resetCombo(){
		TextView t = (TextView) findViewById(R.id.combo);
		combo = 0;
		t.setText(R.string.comboempty);
		t.invalidate();
	}
	
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
	
	public void updateComboAtStart(){
		TextView t = (TextView) findViewById(R.id.combo);
		t.setText("" + ++combo + " Hits!");
		if(combo == 1){
			t.setText("1 Hit!");
		}
		
		t.invalidate();
	}
	
	public void updateVidas(){
		TextView t = (TextView) findViewById(R.id.multiplier);
		t.setText("x" + ++vidas);
	}
	
	public void gastarVidas(){
		TextView t = (TextView) findViewById(R.id.multiplier);
		t.setText("x" + --vidas);
	}
	
	public void deleteMP(){
		super.deleteMP();
		if(mpDeactivate != null){
			mpDeactivate.stop();
			mpDeactivate.release();
		}
	}
	
	@Override
	public void onBackPressed() {
	    deleteMP();
	    finish();
	    return;
	}  
	
	@Override
	public Object onRetainNonConfigurationInstance() {
		TextView marcador = (TextView) findViewById(R.id.tiempoview);
		if(!start){
			return null;
		}
		deleteMP();
	    final CargarDatos data = new CargarDatos(relojTask.getCont(),marcador.getText(),tableroAdapter.getTablero(), tableroAdapter.getGraphics(), finish, tableroAdapter.revelados,
	    		vidas, relojTask.getBarrier(), combo);
	    return data;
	}
}
	
	

