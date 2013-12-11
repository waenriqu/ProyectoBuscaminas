package com.example.buscaminasremix;


import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
/**
 * ModoPadre es una clase abstracta que dicta el comportamiento de las actividades de 
 * cada dificultad. Todas las actividades de los modos de juego heredan de esta clase.
 * ModoPadre principalmente controla la interfaz grafica del juego, el comportamiento
 * tras un cambio de configuración y maneja los listeners de los clicks y longClicks
 *  definiendo el procedimiento del juego.
 * 
 * @author      Gabriel Aumala
 */
public abstract class ModoPadre extends Activity{
	GridView gridview;
	ImageAdapter tableroAdapter;
	Reloj relojTask;
	Timer timer;
	Boolean start = false, finish = false;
	int nMinas;
	final int audioBandera = R.raw.bandera, audioVictoria = R.raw.victoria, audioDeactivate = R.raw.deactivated;
	final int audioDerrota = R.raw.gameover;
	MediaPlayer mpBandera, mpVictoria, mpDeactivate, mpDerrota;
	public final static String TIEMPO_MESSAGE = "com.example.myfirstapp.TIEMPO";
	public final static String CLASS_MESSAGE = "com.example.myfirstapp.CLASS";
	/**
	 * Inicializa los reproductores de efectos de sonidos justo cuando se crea la actividad.
	 * @param  savedInstanceState Bundle con los últimos datos suministrados
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mpBandera = newAudio(audioBandera);
		mpVictoria = newAudio(audioVictoria);
		mpDerrota = newAudio(audioDerrota);
		
		}
	/**
	 * Coloca los listeners  de Click y longClick al GridView.
	 * <p>
	 * Al hacer click en una casilla primero verifica si la partida a comenzado. Si aún
	 * no lo hace inicializa el tablero colocando minas en posiciones aleatoria distintas
	 * a la posición en la que se dio el primer click.
	 * <p>
	 *  Una vez que la partida ya se ha inicializado primero verifica que la casilla este oculta,
	 *  de no ser así el procedimiento acaba. Luego verifica si la casilla es una mina. De ser así
	 *  finaliza el juego notificandole al jugador que perdió. Si no es una mina entonces calcula el
	 *  número de minas adyacentes y realiza las acciones pertinentes.
	 *  Para finalizar verifica si el jugador ya ganó, de ser así finaliza el juego y le notifica al
	 *  jugador que ha ganado y posteriormente lo manda a la actividad que guarda las puntuaciones.
	 *  <p>
	 *  Al hacer longClick primero se verifica que la casilla este oculta, de no ser así el 
	 *  procedimiento acaba. Si esta oculta le coloca una bandera, o se la quita si ya tiene una.
	 *  Posteriormente se reproduce un sonido que notifica al jugador que su longClick ha sido
	 *  satisfactorio.
	 */
	protected void setListeners(){
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
	            if(tableroAdapter.getTablero()[position].getEsMina()){
	            	tableroAdapter.revelarTodasMinas();
	            	detenerJuego();
	            	actualizarCarita(false);
	            	gridview.invalidateViews();
	            	playAudio(mpDerrota);
	            	return;
	            }
	            
	             seleccionarNumero(position);
	            gridview.invalidateViews();
	            
	            if(tableroAdapter.isVictoria()){
	            	detenerJuego();
	            	actualizarCarita(true);
	            	playAudio(mpVictoria);
	            	resultScreen();
	            }
	        }

	    });
	    
	    gridview.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if(!tableroAdapter.getTablero()[position].isOculto()){
					return true;
				}
				tableroAdapter.changeImgAfterLongClicked(position);
				playAudio(mpBandera);
	            gridview.invalidateViews();
				return true;
			}
	    	
	    });
	    
	}
	/**
	 * Calcula el número de minas adyacentes y en base a eso toma una decisión sobre
	 * que debe de hacer. Si el número es cero, entonces revela la casilla y todas las
	 * adyacentes. Si es un número mayor entonces cambia la imagen de la casilla por una
	 * que tenga el número correspondiente.
	 */
	public void seleccionarNumero(int pos){
		switch(tableroAdapter.calcularMinas(pos)){
		case 0:
			tableroAdapter.changeImgAfterClicked(pos, 0);
			tableroAdapter.revelarAdy(pos);
			break;
		case 1:
			tableroAdapter.changeImgAfterClicked(pos, 1);
			break;
		case 2:
			tableroAdapter.changeImgAfterClicked(pos, 2);
			break;
		case 3:
			tableroAdapter.changeImgAfterClicked(pos, 3);
			break;
		case 4:
			tableroAdapter.changeImgAfterClicked(pos, 4);
			break;
		case 5:
			tableroAdapter.changeImgAfterClicked(pos, 5);
			break;
		case 6:
			tableroAdapter.changeImgAfterClicked(pos, 6);
			break;
		case 7:
			tableroAdapter.changeImgAfterClicked(pos, 7);
			break;
		case 8:
			tableroAdapter.changeImgAfterClicked(pos, 8);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modo_padre, menu);
		return true;
	}
	/**
	 * Calcula el tamaño máximo de las casillas dependiendo de la densidad de la
	 * pantalla.
	 */
	public int showTheMetrics(){
		 int density= getResources().getDisplayMetrics().densityDpi;

		 switch(density)
		 {
		 case DisplayMetrics.DENSITY_LOW:
			return 27;
		case DisplayMetrics.DENSITY_MEDIUM:
			return 36;
		 case DisplayMetrics.DENSITY_HIGH:
			 return 54;
		 case DisplayMetrics.DENSITY_XHIGH:
			 return 72;
		 case DisplayMetrics.DENSITY_XXHIGH:
			 return 108;
		 case DisplayMetrics.DENSITY_XXXHIGH:
			 return 144;
		     
		 }
		 dispResolution("none");
		 return 72;
	}
	
	public abstract void resetGame(View view);
	/**
	 * Muestra un Toast. Sólo se usa para pruebas en diferentes dispositivos.
	 * @param text el texto que se muestra en el toast.
	 */
	public void dispResolution(CharSequence text){
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	/**
	 * Retorna un objeto de la clase cargarDatos que guarda toda la información importante de
	 * los modos clásicos antes de un cambio de configuración y libera la memoria de los 
	 * efectos de sonido.
	 * @return un objeto de la clase cargarDatos, si la partida aún no empieza retorna null
	 */
	@Override
	public Object onRetainNonConfigurationInstance() {
		TextView marcador = (TextView) findViewById(R.id.tiempoview);
		deleteMP();
		if(!start){
			return null;
		}
	    final CargarDatos data = new CargarDatos(relojTask.getCont(),marcador.getText(),tableroAdapter.getTablero(), tableroAdapter.getGraphics(), finish, tableroAdapter.revelados);
	    return data;
	}
	/**
	 * Inicializa el hilo que controla el reloj del juego. y las acciones que deben de realizarse
	 * periodicamente.
	 */	
	public void startTimer(){
		final Handler handler = new Handler(); 
		timer = new Timer(); 
	    TimerTask testing = new TimerTask() {
	        public void run() { 
	            handler.post(new Runnable() {
	                public void run() {
	                    relojTask.run();
	                }

	            });


	        }
	    };
	    timer.schedule(testing, 1000, 1000);
	}
	/**
	 * Detiene el juego. Remueve los listener de click y longClick y cancela el hilo.
	 * Ademñas asigna true a la variable finish para actualizar el estado del juego.
	 */	
	public void detenerJuego(){
		gridview.setOnItemClickListener(null);
		gridview.setOnItemLongClickListener(null);
		timer.cancel();
		timer = null;
		finish = true;
	}
	/**
	 * Actualiza la imagen del botón de reset dependiendo de si el jugador ganó o no.
	 * Cada resultado asigna una imagen distinta.
	 * @param 'true' si el jugador ganó, 'false' si el jugador perdió
	 */
	public void actualizarCarita(boolean victoria){
		ImageButton ib = (ImageButton)findViewById(R.id.resetButton);
		if(victoria){
			ib.setImageResource(R.drawable.clicked);
		}else{
		ib.setImageResource(R.drawable.yoonsad);
		}
		ib.invalidate();
	}
	
	@SuppressLint("NewApi")
	public abstract void gravityCenterAPI16();
	
	public abstract void gravityCenterAPI8();
	/**
	 * Verifica el API del dispositivo en el cual está corriendo el juego y ejecuta
	 * las funciones que determina que layout debe de usarse dependiendo del tamaño de
	 * la pantalla. Esto es necesario ya que los métodos para obtener el tamaño de la 
	 * pantalla cambiaron a partir del API 16.
	 */
	public void cambiarContentViews(){
		if(Integer.valueOf(android.os.Build.VERSION.SDK) >= 16){
			gravityCenterAPI16();
		} else{
			gravityCenterAPI8();
		}
	}
	/**
	 * Resetea combos, se implementa exclusivamente en el modo remix.
	 */
	public void resetCombo() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Crea un nuevo objeto de la clase MediaPlayer para reproducir efectos de sonidos.
	 * @param file el archivo de audio que se reproducirá
	 * @return el objeto MediaPlayer con el sonido especificado. Si no habían recursos disponibles
	 * a bajo nivel para crear el objeto, retorna null y le notifica al usuario con un Toast que tiene
	 * problemas de memoria
	 */
	public MediaPlayer newAudio(int file){
		try{
			return MediaPlayer.create(getApplicationContext(), file);
		} 	catch(Exception e){
			Toast.makeText(ModoPadre.this, "Error: Insufieciente memoria para sonidos", Toast.LENGTH_SHORT).show();
			return null;
		}
	}
	/**
	 * Reproduce el sonido de un MediaPlayer. Si el mismo MediaPlayer ya esta reproduciendo un sonido,
	 * lo pausa, y lo vuelve a reproducir desde el inicio. Si el MediaPlayer no ha sido inicializado
	 * correctamente le notifica al usuario con un Toast que tiene problemas de memoria
	 * @param mp el MediaPlayer cuyo sonido se reproducirá
	 */
	public void playAudio(MediaPlayer mp){
		try{
			if(mp.isPlaying()){
				mp.pause();
				mp.seekTo(0);
				mp.start();
			} else{
				mp.start();
			}
		}catch(Exception e){
			e.printStackTrace();
			Toast.makeText(ModoPadre.this, "Error: Insufieciente memoria para sonidos", Toast.LENGTH_SHORT).show();
		}
	}
	/**
	 * Función que libera la memora de los reproductores de efectos de sonidos de los modos clásicos.
	 */
	public void deleteMP(){
		if(mpBandera != null){
			mpBandera.stop();
			mpBandera.release();
		}
		if(mpVictoria != null){
			mpVictoria.stop();
			mpVictoria.release();
		}
		if(mpDerrota != null){
			mpDerrota.stop();
			mpDerrota.release();
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
	 * Comienza ela actividad de las puntuaciones y le manda el String con el tiempo que le tomó
	 * ganar al jugador.
	 */
	public void resultScreen(){
		if(this instanceof ModoFacil){
			Intent intent = new Intent(this, ResultScreenFacil.class);
			TextView tw = (TextView)findViewById(R.id.tiempoview);
			intent.putExtra(TIEMPO_MESSAGE, tw.getText().toString());
			startActivity(intent);
		} else if (this instanceof ModoNormal){
			Intent intent = new Intent(this, ResultScreenNormal.class);	
			TextView tw = (TextView)findViewById(R.id.tiempoview);
			intent.putExtra(TIEMPO_MESSAGE, tw.getText().toString());
			startActivity(intent);
		} else if (this instanceof ModoDificil){
			Intent intent = new Intent(this, ResultScreenDificil.class);	
			TextView tw = (TextView)findViewById(R.id.tiempoview);
			intent.putExtra(TIEMPO_MESSAGE, tw.getText().toString());
			startActivity(intent);
		} else{
			Intent intent = new Intent(this, ResultScreenRemix.class);
			TextView tw = (TextView)findViewById(R.id.tiempoview);
			intent.putExtra(TIEMPO_MESSAGE, tw.getText().toString());
			startActivity(intent);
		}
		
	}
	
}