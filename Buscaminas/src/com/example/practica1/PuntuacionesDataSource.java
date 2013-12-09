package com.example.practica1;

import java.util.ArrayList;
import java.util.List;

import com.example.practica1.Puntuaciones.TablaRanking;
import com.example.practica1.Jugador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class PuntuacionesDataSource {
	private SQLiteDatabase db;
    private Puntuaciones dbHelper;
    private String[] columnas = { TablaRanking.columna_nombre,
    		TablaRanking.columna_tiempo };
 
    public PuntuacionesDataSource(Context context) {
        dbHelper = new Puntuaciones(context);
    }
 
    public void open() {
        db = dbHelper.getWritableDatabase();
    }
 
    public void close() {
        dbHelper.close();
    }
 
    public void crearRegistro(String nombre, String tiempo) {
        ContentValues values = new ContentValues();
        values.put(TablaRanking.columna_nombre, nombre);
        db.insert(TablaRanking.tabla_ranking, null, values);
        values.put(TablaRanking.columna_tiempo, tiempo);
        db.insert(TablaRanking.tabla_ranking, null, values);
    }
 
    public List<Jugador> getAllRanking() {
        List <Jugador>listaJugadores = new ArrayList<Jugador>();
 
        Cursor cursor = db.query(TablaRanking.tabla_ranking, columnas, null, null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Jugador nuevoJugador = cursorToJugador(cursor);
            listaJugadores.add(nuevoJugador);
            cursor.moveToNext();
        }
 
        cursor.close();
        return listaJugadores;
    }
 
    public void borrarNota(Jugador jugador) {
        String id = jugador.getNombre();
        db.delete(TablaRanking.tabla_ranking, TablaRanking.columna_nombre + " = " + id,
                null);
    }
 
    private Jugador cursorToJugador(Cursor cursor) {
    	Jugador jugador = new Jugador();
    	jugador.setNombre(cursor.getString(0));
    	jugador.setTiempo(cursor.getString(1));
        return jugador;
    }

}
