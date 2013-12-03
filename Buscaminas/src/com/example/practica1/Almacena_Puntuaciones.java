package com.example.practica1;

import java.util.Vector;

public interface Almacena_Puntuaciones {
	public void guardarPuntuacion(int puntos, String nombre, long fecha);
	public Vector<String> listaPuntuaciones(int cantidad);

}
