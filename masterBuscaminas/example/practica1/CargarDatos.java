package com.example.buscaminasremix;
/**
 * CargarDatos guarda toda la informaci�n que se debe de guardar en una parrtida cl�sica 
 * de Buscaminas antes hacer cambios de configuraci�n: el tiempo que ha transcurrido desde
 * que se inici� la partida, el texto del reloj, el arreglo de casillas, el arreglo de 
 * im�genes de las casillas, el estado de la partida y el n�mero de casillas reveladas. Se 
 * usan dos costructores, uno para guardar los datos de los modos cl�sicos y otro para el
 * modo remix. El modo remix adicionalmente necesita guardar el estado de la barra de combos
 * y el contador de combos
 * 
 * @author      Kevin Zambrano
 */

public class CargarDatos {
	int cont, revelados, vidas, combo;
	double barrier;
	CharSequence time;
	Casilla [] board;
	Integer [] graphics;
	boolean finish;
	String nombres, tiempos;
	
	/**
	 * Crea un nuevo objeto CargarDatos 
	 * @param  c  Un entero con la cantidad de segundos transcurridos en la partida
	 * @param r El texto que marca el reloj
	 * @param t El arreglo de casillas del tablero (Model)
	 * @param g  El arreglo de im�genes de las casillas que se muestran en pantalla (View)
	 * @param perdiste Boolean que muestra el estado del juego, "true" si ya concluy�, de lo contrario false
	 * @param  revelados Un entero con la cantidad de casillas reveladas desde el inicio del juego
	 * @return      objeto CargarDatos con toda la informaci�n guardada antes del cambio de configuraci�n
	 */
	public CargarDatos(int c, CharSequence r, Casilla [] t, Integer[] g, boolean perdiste, int revelados){
		this.cont=c;
		this.time=r;
		this.board=t;
		this.graphics=g;
		this.finish = perdiste;
		this.revelados = revelados;
	}
	/**
	 * Crea un nuevo objeto CargarDatos con toda la informaci�n que se debe de
	 * guardar en una parrtida Remix de Buscaminas antes hacer cambios de configuraci�n:
	 * el tiempo que ha transcurrido desde que se inici� la partida, el texto del reloj, 
	 * el arreglo de casillas, el arreglo de im�genes de las casillas, el estado de la partida, 
	 * el n�mero de casillas reveladas, el estado de la barra de combo y el contador de combos.
	 * @param  c  Un entero con la cantidad de segundos transcurridos en la partida
	 * @param r El texto que marca el reloj
	 * @param t El arreglo de casillas del tablero (Model)
	 * @param g  El arreglo de im�genes de las casillas que se muestran en pantalla (View)
	 * @param perdiste Boolean que muestra el estado del juego, "true" si ya concluy�, de lo contrario false
	 * @param  revelados Un entero con la cantidad de casillas reveladas desde el inicio del juego
	 * @param barrier Un double que modela matem�ticamente la barrera de combo. La escala es as�: '0' es una barra vac�a
	 * y '100' es una barra completa.
	 * @param combo La cantidad de hits que lleva el combo actualmente
	 * @return      objeto CargarDatos con toda la informaci�n guardada antes del cambio de configuraci�n
	 */
	public CargarDatos(int c, CharSequence r, Casilla [] t, Integer[] g, boolean perdiste, int revelados, int vidas, double barrier, int combo){
		this.cont=c;
		this.time=r;
		this.board=t;
		this.graphics=g;
		this.finish = perdiste;
		this.revelados = revelados;
		this.vidas = vidas;
		this.barrier = barrier;
		this.combo = combo;
	}
	
	public CargarDatos(boolean finish, String nombres, String tiempos){
		this.finish = finish;
		this.nombres = nombres;
		this.tiempos = tiempos;
	}
	/**
	 * Retorna la cantidad de segundos transcurridos en la partida guardados en el objeto CargarDatos
	 * @return     Un entero con la cantidad de segundos transcurridos en la partida
	 */
	public int getCont() {
		return cont;
	}
	/**
	 * Retorna el texto que marca el reloj guardado en el objeto CargarDatos
	 * @return     Un CharSequence con el texto que marca el reloj
	 * en el objeto CargarDatos
	 */
	public CharSequence getTime() {
		return time;
	}
	/**
	 * Retorna el arreglo de casillas (Model) guardado en el objeto CargarDatos
	 * @return     Un arreglo de casillas
	 */
	public Casilla[] getBoard() {
		return board;
	}
	/**
	 * Retorna el arreglo de im�genes de casillas (View) guardado en el objeto CargarDatos
	 * @return     Un arreglo de im�genes Integer
	 */
	public Integer[] getGraphics() {
		return graphics;
	}
	/**
	 * Retorna el estado de la partida guardado en el objeto CargarDatos
	 * @return     Un Boolean con el estado de la partida "true" si ya concluy�, de lo contrario false
	 */
	public boolean getFinish(){
		return finish;
	}
	/**
	 * Retorna la cantidad de casillas reveladas guardada en el objeto CargarDatos
	 * @return     Un entero con la cantidad de casillas reveladas
	 */
	public int getRevelados() {
		return revelados;
	}
	/**
	 * Retorna el estado de la barrera de combos guardado en el objeto CargarDatos
	 * @return     Un double que modela matem�ticamente la barrera de combo. La escala es as�: '0' es una barra vac�a
	 * y '100' es una barra completa.
	 */
	public double getBarrier() {
		return barrier;
	}
	/**
	 * Retorna la cantidad de vidas guardada en el objeto CargarDatos
	 * @return     Un entero con la cantidad de vidas que tiene el jugador
	 */
	public int getVidas() {
		return vidas;
	}
	/**
	 * Retorna la cantidad de hits que tiene el combo actual guardada en el objeto CargarDatos
	 * @return     Un entero con la cantidad de hits del combo
	 */
	public int getCombo() {
		return combo;
	}
	
	public String getNombres(){
		return nombres;
	}
	
	public String getTiempos(){
		return nombres;
	}
	
}
