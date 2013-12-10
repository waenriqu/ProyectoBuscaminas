package com.example.buscaminasremix;

import android.widget.ImageView;
/**
 * Esta clase hereda de Reloj y introduce más metodos a ejecutarse
 * periódicamente que se encuentran exclusivamente en el modo Remix tales
 * como actualizar la barra de combos y manipular sus valores.
 * 
 * @author      Gabriel Aumala
 * @author		Wilson Enriquez
 */
public class RelojBarrier extends Reloj {
	private double barrier;
	public final double damage = 20.00;
	public static final double explosion = 60.00;
	
	/**
	 * Crea un nuevo objeto RelojBarrier inicializando en cero la barra de combos.
	 * @param  activity el activity que usará el reloj
	 * @return  Objeto reloj
	 */
	RelojBarrier(ModoPadre activity) {
		super(activity);
		barrier = 0.00;
	}
	/**
	 * Crea un nuevo objeto Reloj inicializando el contador de
	 * segundos  y la barra de combos con valores distinto a cero.
	 * @param  activity El activity que usará el reloj
	 * @param  cont El valor que se le asignará al contador de segundos 
	 * @param  barrier El valor que se le asignará a la barra de combos
	 * @return  Objeto reloj
	 */
	RelojBarrier(ModoPadre activity, int cont, double barrier){
		super(activity,cont);
		this.barrier = barrier;
	}
	
	/**
	 * Función que el reloj ejecuta periodicamente. Ejecuta primero la función de la clase
	 * padre. Disminuye la barra de combos en un valor constante cada segundo y actualiza la
	 * barra de combos.
	 */
	public void run(){
		super.run();
			barrier -= damage;
			if(barrier<0){
				barrier = 0;
			}
			updateBarrier();
	}
	/**
	 * Actualiza la barra de combos asignando una imágen que represente el valor actual
	 */
	public void updateBarrier(){
		ImageView bar = (ImageView) activity.findViewById(R.id.barrier);
		if (barrier>90.00){
			bar.setImageResource(R.drawable.bar100);
			bar.invalidate();
			return;
		}
		if (barrier>80.00){
			bar.setImageResource(R.drawable.bar90);
			bar.invalidate();
			return;
		}
		if (barrier>70.00){
			bar.setImageResource(R.drawable.bar80);
			bar.invalidate();
			return;
		}
		if (barrier>60.00){
			bar.setImageResource(R.drawable.bar70);
			bar.invalidate();
			return;
		}
		if (barrier>50.00){
			bar.setImageResource(R.drawable.bar60);
			bar.invalidate();
			return;
		}
		if (barrier>40.00){
			bar.setImageResource(R.drawable.bar50);
			bar.invalidate();
			return;
		}
		if (barrier>30.00){
			bar.setImageResource(R.drawable.bar40);
			bar.invalidate();
			return;
		}
		if (barrier>20.00){
			bar.setImageResource(R.drawable.bar30);
			bar.invalidate();
			return;
		}
		if (barrier == 0.00){
			bar.setImageResource(R.drawable.bar00);
			activity.resetCombo();
			bar.invalidate();
			return;
		}
		bar.setImageResource(R.drawable.bar20);
		bar.invalidate();
	}
	/**
	 * Sube la barra de combos al 100% y actualiza el view
	 */
	public void subirBarrier(){
		barrier = 100;
		updateBarrier();
	}
	/**
	 * Sube la barra de combos al en un 20% si es que coloca una bandera a la 
	 * mitad de un combo y actualiza el view.
	 */
	public void subirBarrierBandera(){
		if(barrier>0){
			barrier+= damage;
			updateBarrier();
		}
	}
	/**
	 * Devuelve el valor de la barra de combos
	 * @return Un double con el valor de la barra de combos
	 */
	public double getBarrier(){
		return barrier;
	}

}
