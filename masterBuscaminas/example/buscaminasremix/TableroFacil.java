package com.example.buscaminasremix;

import android.content.Context;
/**
 * Esta clase hereda de ImageAdapter. simplemente crea el tablero con las dimensiones
 * y n�mero de minas que corresponden al modo f�cil para que la clase ImageAdapter
 * se encargue de las reglas de juego y de crear el View. Ofrece un constructor adicional
 * para crear tableros con valores guardados anteriormente 
 * 
 * @author      Gabriel Aumala
 * @author		Wilson Enriquez
 */
public class TableroFacil extends ImageAdapter{
	
	protected Integer[] graphics = {
            //00
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            //10
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            //20
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            //30
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            //40
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            //50
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            //60
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            //70
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            R.drawable.oculto, R.drawable.oculto,
            //80
            R.drawable.oculto,
             
             
    };
	
	protected Casilla[] emptyBoard = {
            //00
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //10
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //20
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //30
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //40
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //50
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //60
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //70
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            new Casilla(), new Casilla(),
            //80
            new Casilla()
             
             
    };
	
	/**
	 * Crea un tablero f�cil con casillas ocultas nuevas. Usa un arreglo de imagenes nuevo,
	 * le asigna el valor de 9 al n�mero de columnas del tablero, inicializa en cero
	 * el n�mero de casillas reveladas, y asigna el valor de 9 al n�mero de minas del tablero.
	 * @param  context El contexto de la actividad que usar� el tablero
	 * @param imgSize El tama�o m�ximo de las casillas del tablero
	 * @return  Tablero f�cil con casillas ocultas.
	 */	
	public TableroFacil(Context c, int imgSize){
		super(c,imgSize);
		mThumbIds = graphics;
		tablero = emptyBoard;
		distX = 9;
		revelados = 0;
		nMinas = 9;
	}
	
	/**
	 * Crea un tablero f�cil con casillas guardadas anteriormente. Le asigna el valor de 9 
	 * al n�mero de columnas del tablero, inicializa en cero el n�mero de casillas reveladas, 
	 * y asigna el valor de 9 al n�mero de minas del tablero.
	 * @param  context El contexto de la actividad que usar� el tablero
	 * @param imgSize El tama�o m�ximo de las casillas del tablero
	 * @param array El arreglo de casillas (Model) guardado anteriormente
	 * @param graphics El arreglo de im�genes (View) guardado anteriormente
	 * @p�ram revelados El n�mero de casillas reveladas guardado anteriormente
	 * @return  Tablero f�cil con casillas guardadas anteriormente.
	 */	
	public TableroFacil(Context c, int imgSize, Casilla[] array, Integer[] graphics, int revelados){
		super(c,imgSize);
		tablero = array;
		mThumbIds = graphics;
		this.graphics = null;
		this.emptyBoard = null;
		distX = 9;
		nMinas = 9;
		this.revelados = revelados;
	}
	
	
	

}
