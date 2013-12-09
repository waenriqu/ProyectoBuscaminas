package com.example.practica1;

import java.util.ArrayList;
import java.util.List;

import com.example.practica1.Puntuaciones.TablaRanking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class PuntuacionesDataSourceRemix extends PuntuacionesDataSource{
	int hits;
	
	public PuntuacionesDataSourceRemix(Context context, int h){
		super(context);
		this.hits=h;
	}

	
    public void open() {
        db = dbHelper.getWritableDatabase();
    }
 
    public void close() {
        dbHelper.close();
    }
 
    public void crearRegistro(String nombre, String tiempo, int hits) {
        ContentValues values = new ContentValues();
        values.put(TablaRanking.columna_nombre, nombre);
        db.insert(TablaRanking.tabla_ranking, null, values);
        values.put(TablaRanking.columna_tiempo, tiempo);
        db.insert(TablaRanking.tabla_ranking, null, values);
        //values.put(TablaRanking.columna_hits, hits);
        //db.insert(TablaRanking.tabla_ranking, null, values);
    }
 
    public List<Jugador> getAllRanking() {
        List <Jugador>listaJugadores = new ArrayList<Jugador>();
 
        Cursor cursor = db.rawQuery("SELECT nombre, tiempo, hits FROM " +
                "puntuaciones ORDER BY hits", null);
        		/*db.query(TablaRanking.tabla_ranking, columnas, null, null,
                null, null, null);*/
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Jugador nuevoJugador = cursorToJugador(cursor);
            listaJugadores.add(nuevoJugador);
            cursor.moveToNext();
        }
 
        cursor.close();
        return listaJugadores;
    }
 
    private Jugador cursorToJugador(Cursor cursor) {
    	Jugador jugador = new Jugador();
    	jugador.setNombre(cursor.getString(0));
    	jugador.setTiempo(cursor.getString(0));
    	//jugador.setHits(cursor.getInt(0));
        return jugador;
    }
}
