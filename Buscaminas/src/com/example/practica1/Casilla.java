package com.example.practica1;

public class Casilla {
    int tipo;
    Boolean oculta;
    int posX;
    int posY;
    
    public Casilla(){
        tipo = 0;
        oculta = true;
    }
    
    public void cambiarTipo(int nuevoTipo){
    tipo = nuevoTipo;
    }

    public void cambiarEstado(){
        oculta = false;
    }
    
    
    //M�todo para conseguir la posici�n X de la casilla.
    public int getPosX(){
    	return posX;
    }
    
    
    //M�todo para conseguir la posici�n Y de la casilla.
    public int getPosY(){
    	return posY;
    }

    //M�todo para asignar posicion x de la casilla
    public void setPosX(int x){
    	posX = x;
    }
    
    //M�todo para determinar la posici�n de la casilla en el tablero.
    public void obtenerPosicion(int x, String dif){
    	
    	
    	
    }
    
}
