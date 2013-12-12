package com.example.buscaminasremix;
/**
 * Clase que modela las casillas del juego Buscaminas. Abstrae la casilla
 * para solo saber que tipo es, si esta oculta o descubierta, y si es una
 * mina.
 * 
 * @author      Wilson Enriquez
 */
public class Casilla {
    int tipo;
    Boolean oculta;
    Boolean esMina;
    public static final int mina = 9;
    
    /**
     * Crea un nuevo objeto casilla oculta y que no es mina.
     * 
     * @return El objeto casilla.
     */
    public Casilla(){
        tipo = 0;
        oculta = true;
        esMina = false;
    }
    /**
     * Cambia el tipo de la casilla.
     * @param el nuevo tipo de la casilla
     */
    public void cambiarTipo(int nuevoTipo){
    tipo = nuevoTipo;
    }
    /**
     * Cambia el estado de la casilla. Pasa a ser una casilla descubierta
     * así que su atributo oculta es false.
     */
    public void cambiarEstado(){
        oculta = false;
    }
    /**
     * Notifica si la casilla esta oculta o no.
     * return true si está oculta, false si ya la descubrieron
     */
    public boolean isOculto(){
    	return oculta;
    }
    /**
     * Notifica si la casilla contiene una mina o no.
     * return true si tiene la mina, de lo contrario false
     */
    public boolean getEsMina(){
    	return esMina;
    }
    /**
     * Coloca una mina en la casilla si el argumento es true.
     * @param Un boolean para decidir si se coloca o no se coloca la mina.
     */
    public void setEsMina(boolean esMina){
    	this.esMina = esMina;
    }
    
   
    
}
