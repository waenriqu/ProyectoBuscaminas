package com.example.buscaminasremix;
/**
 * El Reloj controla los métodos que se deben de ejecutar periódicamente
 * en el juego. La función principal es contar el tiempo que transcurre en
 * la partida y mostrárselo al jugador por pantalla, en el formato de un
 * reloj normal.
 * 
 * @author      Gabriel Aumala
 * @author		Wilson Enriquez
 */
import android.widget.TextView;

public class Reloj {
	public String minutos = "00", segundos = "00";
	int cont = 0;
	
	public ModoPadre activity;
	/**
	 * Crea un nuevo objeto Reloj inicializando en cero todos los valores.
	 * @param  activity el activity que usará el reloj
	 * @return  Objeto reloj
	 */
	Reloj(ModoPadre activity){
		this.activity = activity;
	}
	/**
	 * Crea un nuevo objeto Reloj inicializando el contador de
	 * segundos con un valor distinto a cero.
	 * @param  activity El activity que usará el reloj
	 * @param  cont El valor que se le asignará al contador de segundos 
	 * @return  Objeto reloj
	 */
	Reloj(ModoPadre activity, int cont){
		this.activity = activity;
		this.cont = cont;
	}
	/**
	 * Función que el reloj ejecuta periodicamente. Incrementa el contador de
	 * segundos en una unidad y actualiza el view del reloj.
	 */
	public void run() {
		// TODO Auto-generated method stub
		TextView relojview = (TextView)activity.findViewById(R.id.tiempoview);
		minutos = calcularMinutos(++cont);
		segundos = calcularSegundos(cont);
		relojview.setText(minutos + ":" + segundos);
		relojview.invalidate();
		
				
	}
	/**
	 * Calcula los minutos de juego que han transcurrido desde que comenzo la
	 * partida.
	 * @param cont La cantidad de segundos que han transcurrido
	 * @return El String con la cantidad de minutos transcurridos
	 */
	public String calcularMinutos(int cont){
		int minutos = cont/60;
		if(minutos < 10){
			return "0" + Integer.toString(minutos);
		}
		return Integer.toString(minutos);
		
	}
	/**
	 * Devuelve la diferencia entre los segundos transcurridos y los minutos transcurridos.
	 * Este valor se imprime en el view del reloj como el segundero.
	 * @param cont La cantidad de segundos que han transcurrido
	 * @return El String con la cantidad de segundos
	 */
	public String calcularSegundos(int cont) {
		int segundos = cont%60;
		if(segundos < 10){
			return "0" + Integer.toString(segundos);
		}
		return Integer.toString(segundos);
					
		}
	/**
	 * Retorna el contador de segundos
	 * @return Entero con el contador de segundos
	 */
	public int getCont() {
		return cont;
	}
	/**
	 * Sube la barra de combos a 100. Se implementa en la clase hija RelojBarrier para el
	 * modo remix.
	 */
	public void subirBarrier() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Retorna el valor actual de la barra de combos. Se implementa en la clase hija 
	 * RelojBarrier para el modo remix.
	 */
	public double getBarrier() {
		return 0;
	}
	/**
	 * Incrementa el valor la barra de combos tras colocar una bandera. Se implementa en la 
	 * clase hija RelojBarrier para el modo remix.
	 */
	public void subirBarrierBandera() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Actualiza la barrera de combos. Se implementa en la clase hija RelojBarrier para el modo remix.
	 */
	public void updateBarrier() {
		// TODO Auto-generated method stub
		
	}


}
