package com.example.buscaminasremix;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
/**
 * Actividad que muestra en pantalla los rankings de todas las dificultades. Esto es
 * necesario para que el jugador pueda ver los rankings desde el menu principal, sin 
 * modificarlos.
 * @author      Gabriel Aumala
 */
public class ConsultResults extends Activity {
Jugador jugador;
	/**
	 * Al crear la actividad crea una nueva instancia de jugador con datos triviales. La usa
	 * para obtener acceso a los métodos de gestión de archivos para obtener las puntuaciones
	 * de todas las dificultades y las imprime por pantalla.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consult_results);
		jugador = new Jugador("NO ONE","INFINITY", this);
		updateRankingFacil();
		updateRankingNormal();
		updateRankingDificil();		
		updateRankingRemix();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consult_results, menu);
		return true;
	}
	/**
	 * Actualiza el ranking del modo difícil. Sólo se obtienen las 10 puntuaciones más
	 * altas del modo difícil y se las imprime por pantalla.
	 */
	public void updateRankingDificil(){
		int cont = 0;
		TextView nombresview3 = (TextView)findViewById(R.id.nombrelist3);
		TextView tiemposview3 = (TextView)findViewById(R.id.tiempolist3);
		String nombres = "";
		String tiempos = "";
		ArrayList<Jugador> list = jugador.cargarPuntuacionDificil();
		if(list!=null){
			for(Jugador j:list){
				if(cont<10){
					nombres = nombres + j.getNombre() + '\n';
					tiempos = tiempos + j.getTiempo() + '\n';
					cont++;
				}
			}
			nombresview3.setText((CharSequence)nombres);
			tiemposview3.setText((CharSequence)tiempos);
			nombresview3.invalidate();
			tiemposview3.invalidate();
		}
	}
	/**
	 * Actualiza el ranking del modo fácil. Sólo se obtienen las 10 puntuaciones más
	 * altas del modo fácil y se las imprime por pantalla.
	 */
	public void updateRankingFacil(){
		int cont = 0;
		TextView nombresview1 = (TextView)findViewById(R.id.nombrelist1);
		TextView tiemposview1 = (TextView)findViewById(R.id.tiempolist1);
		String nombres = "";
		String tiempos = "";
		ArrayList<Jugador> list = jugador.cargarPuntuacionFacil();
		if(list!=null){
			for(Jugador j:list){
				if(cont<10){
					nombres = nombres + j.getNombre() + '\n';
					tiempos = tiempos + j.getTiempo() + '\n';
					cont++;
				}
			}
			nombresview1.setText((CharSequence)nombres);
			tiemposview1.setText((CharSequence)tiempos);
			nombresview1.invalidate();
			tiemposview1.invalidate();
		}
	}
	/**
	 * Actualiza el ranking del modo normal. Sólo se obtienen las 10 puntuaciones más
	 * altas del modo normal y se las imprime por pantalla.
	 */
	public void updateRankingNormal(){
		int cont = 0;
		TextView nombresview2 = (TextView)findViewById(R.id.nombrelist2);
		TextView tiemposview2 = (TextView)findViewById(R.id.tiempolist2);
		String nombres = "";
		String tiempos = "";
		ArrayList<Jugador> list = jugador.cargarPuntuacionNormal();
		if(list!=null){
			for(Jugador j:list){
				if(cont<10){
					nombres = nombres + j.getNombre() + '\n';
					tiempos = tiempos + j.getTiempo() + '\n';
					cont++;
				}
			}
			nombresview2.setText((CharSequence)nombres);
			tiemposview2.setText((CharSequence)tiempos);
			nombresview2.invalidate();
			tiemposview2.invalidate();
		}
	}
	/**
	 * Actualiza el ranking del modo remix. Sólo se obtienen las 10 puntuaciones más
	 * altas del modo remix y se las imprime por pantalla.
	 */
	public void updateRankingRemix(){
		int cont = 0;
		TextView nombresview4 = (TextView)findViewById(R.id.nombrelist4);
		TextView tiemposview4= (TextView)findViewById(R.id.tiempolist4);
		String nombres = "";
		String tiempos = "";
		ArrayList<Jugador> list = jugador.cargarPuntuacionRemix();
		if(list!=null){
			for(Jugador j:list){
				if(cont<10){
					nombres = nombres + j.getNombre() + '\n';
					tiempos = tiempos + j.getTiempo() + '\n';
					cont++;
				}
			}
			nombresview4.setText((CharSequence)nombres);
			tiemposview4.setText((CharSequence)tiempos);
			nombresview4.invalidate();
			tiemposview4.invalidate();
		}
	}
}
