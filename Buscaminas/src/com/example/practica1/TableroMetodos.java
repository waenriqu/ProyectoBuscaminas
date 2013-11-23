package com.example.practica1;

import java.util.ArrayList;
import java.util.Random;

public class TableroMetodos {
	/*
	 * 
	 * FACIL = 9 x 9
	 * 
	 * NORMAL = 9 x 16
	 * 
	 * DIFICIL = 30 x 16
	 * 
	 *
	 * 
	 * 
    ArrayList tabla[];
    int numMinas;
    int tamañoX;
    int tamañoY;
    ArrayList minas;

    public void inicializarTablero(){
        for(int i = 0; i< tamañoX; i++){
            for(int j =0; j< tamañoY; j++){
                tabla[i][j]= 0;
            }
        }
    }
    

//Método para llenar de minas el tablero.    
    public void llenarTableroMinas(){
        int i = 0;
        int posicion;
        int tamaño;
        
        while(numMinas< i){

             
             posicion = ((int)(Math.random()*tamaño));
				
        
            if(tabla[posicion]==0){
                tabla[posicion]=9;
                minas.add(posicion);
                i++;
            }  
        }
    }
    
    
    //METODO PARA LLENAR EL TABLERO
    
    public int calcularMinas(int posicion){
    int pos7 = posicion - distX -1;
    int pos8 = posicion - distX;
    int pos9 = posicion - distX+1;
    int pos4 = posicion - 1;
    int pos6 = posicion + 1;
    int pos1 = posicion + distX-1;
    int pos2 = posicion + distX;
    int pos3 = posicion + distX+1;
    
    
    
    
        int numMinasLados = 0;
 		
 		//Falta hacer validaciones para bordes y que no tome en cuenta valores de la siguiente columna
 		
        
 		if((pos7>0)&&(pos7%distX-pos8%distX == 1)&&(tabla[pos7].tipo == 0)){
 		numMinasLados++;
 		}
 		
 		
 		if((pos8>0)&&(tabla[pos8].tipo == 0)){
 		numMinasLados++;
 		}
 		
 		
 		if((pos9>0)&&(pos9%distX-pos8%distX)&&(tabla[pos9].tipo == 0)){
 		numMinasLados++;
 		}
 		
 		if((pos4>9)&&(pos4%distX-posicion%distX==1)&&(tabla[pos4].tipo == 0)){
 		numMinasLados++;
 		}
 		
 		if((pos6<tabla.length())&&(pos6%distX-posicion%distX==1)&&(tabla[pos6].tipo == 0)){
 		numMinasLados++;
 		}
 		
 		if((pos1<tabla.length())&&(pos1%distX-pos2%distX==1)&&(tabla[pos1].tipo == 0)){
 		numMinasLados++;
 		}
 		
        if((pos2<tabla.length())&&(tabla[pos2].tipo == 0)){
 		numMinasLados++;
 		}
 		
 		if((pos3<tabla.length())&&(pos3%distX - pos2%distX==1)&&(tabla[pos3].tipo == 0)){
 		numMinasLados++;
 		}
 		
 		
 		return numMinasLados;        
                
                
        }
        
        */
        }
       
        
    
    
