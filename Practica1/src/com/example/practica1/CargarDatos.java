package com.example.practica1;

public class CargarDatos {
	int cont;
	String time;
	Object [] board;
	
	public CargarDatos(int c, String r, Object [] t){
		this.cont=c;
		this.time=r;
		this.board=t;
	}

	public int getCont() {
		return cont;
	}

	public String getTime() {
		return time;
	}

	public Object[] getBoard() {
		return board;
	}

	
}
