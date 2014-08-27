package com.example.buscaminasremix;

import android.content.Context;
/**
 * Esta clase hereda de ImageAdapter. simplemente crea el tablero con las dimensiones
 * y n�mero de minas que corresponden al modo normal para que la clase ImageAdapter
 * se encargue de las reglas de juego y de crear el View. Ofrece un constructor adicional
 * para crear tableros con valores guardados anteriormente 
 * 
 * @author      Gabriel Aumala
 * @author		Wilson Enriquez
 */
public class TableroNormal extends ImageAdapter{
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
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //90
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //100
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //110
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //120
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //130
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //140
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //150
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //160
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //170
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //180
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //190
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //200
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //210
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //220
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //230
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //240
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            //250
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto,
	            R.drawable.oculto, R.drawable.oculto
	            
	             
	             
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
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //90
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //100
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //110
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //120
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //130
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //140
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //150
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //160
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //170
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //180
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //190
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //200
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //210
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //220
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //230
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //240
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            //250
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla(),
	            new Casilla(), new Casilla()
	            
	             
	             
	    };
	 /**
		 * Crea un tablero normal con casillas ocultas nuevas. Usa un arreglo de imagenes nuevo,
		 * le asigna el valor de 16 al n�mero de columnas del tablero, inicializa en cero
		 * el n�mero de casillas reveladas, y asigna el valor de 40 al n�mero de minas del tablero.
		 * @param  context El contexto de la actividad que usar� el tablero
		 * @param imgSize El tama�o m�ximo de las casillas del tablero
		 * @return  Tablero normal con casillas ocultas.
		 */	
	public TableroNormal(Context c, int imgSize){
		super(c,imgSize);
		mThumbIds = graphics;
		tablero = emptyBoard;
		distX = 16;
		revelados = 0;
		nMinas = 40;
		
	}
	 /**
	 * Crea un tablero normal con casillas guardadas anteriormente. Le asigna el valor de 16 
	 * al n�mero de columnas del tablero, inicializa en cero el n�mero de casillas reveladas, 
	 * y asigna el valor de 40 al n�mero de minas del tablero.
	 * @param  context El contexto de la actividad que usar� el tablero
	 * @param imgSize El tama�o m�ximo de las casillas del tablero
	 * @param array El arreglo de casillas (Model) guardado anteriormente
	 * @param graphics El arreglo de im�genes (View) guardado anteriormente
	 * @p�ram revelados El n�mero de casillas reveladas guardado anteriormente
	 * @return  Tablero normal con casillas guardadas anteriormente.
	 */	
	public TableroNormal(Context c, int imgSize, Casilla[] array, Integer[] graphics, int revelados){
		super(c,imgSize);
		tablero = array;
		mThumbIds = graphics;
		this.graphics = null;
		this.emptyBoard = null;
		distX = 16;
		nMinas = 40;
		this.revelados = revelados;
	}}
