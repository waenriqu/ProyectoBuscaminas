package com.example.practica1;

import java.util.Vector;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Puntuaciones extends SQLiteOpenHelper implements Almacena_Puntuaciones {
	
	public Puntuaciones(Context context) {
        super(context, "ranking", null, 1);
  }

	@Override
	public void guardarPuntuacion(int tiempo, String nombre, long fecha) {
		SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO puntuaciones VALUES ( null, " + "" +tiempo+", "+nombre+", "+fecha+")");
        db.close();
		
	}

	@Override
	public Vector<String> listaPuntuaciones(int tiempo) {
		Vector<String> result = new Vector<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT nombre, tiempo FROM " +
         "puntuaciones ORDER BY puntos DESC LIMIT " +tiempo, null);
        while (cursor.moveToNext()){
                      result.add(cursor.getInt(0)+" " +cursor.getString(1));
         }
        cursor.close();
        db.close();
        return result;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE puntuaciones ("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "tiempo INTEGER, nombre TEXT, fecha LONG)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
