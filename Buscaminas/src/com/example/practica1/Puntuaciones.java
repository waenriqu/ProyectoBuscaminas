package com.example.practica1;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Puntuaciones extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "ranking";
    private static final int DATABASE_VERSION = 1;
     
    public static class TablaRanking{
        public static String tabla_ranking = "puntuaciones";
        public static String columna_nombre = "nombre";
        public static String columna_tiempo = "tiempo";
    }
     
    private static final String DATABASE_CREATE = "create table "
            + TablaRanking.tabla_ranking + "(" + TablaRanking.columna_nombre
            + " integer primary key autoincrement, " + TablaRanking.columna_tiempo
            + " text not null);";
     
	
	
	public Puntuaciones(Context context) {
        super(context, DATABASE_NAME, null, 1);
  }

	/*@Override
	public void guardarPuntuacion(String tiempo, String nombre, long fecha) {
		SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO puntuaciones VALUES ( null, " + "" +tiempo+", "+nombre+")");
        db.close();
		
	}

	@Override
	public Vector<String> listaPuntuaciones(int tiempo) {
		Vector<String> result = new Vector<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT nombre, tiempo FROM " +
         "puntuaciones ORDER BY tiempo" +tiempo, null);
        while (cursor.moveToNext()){
                      result.add(cursor.getInt(0)+" " +cursor.getString(1));
         }
        cursor.close();
        db.close();
        return result;
	}*/

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("delete table if exists " + TablaRanking.tabla_ranking);
	    onCreate(db);
		// TODO Auto-generated method stub
		
	}

}
