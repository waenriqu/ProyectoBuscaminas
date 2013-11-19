package com.example.practica1;

import java.util.ArrayList;

public class TableroMetodos {
    ArrayList tabla[][];
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
    
    public void llenarTableroMinas(){
        int i = 0;
        int x;
        int y;
        
        while(numMinas< i){
            x = random()%tamañoX; 
            y = random()%tamañoY;
            if(tabla[x][y]==0){
                tabla[x][y]=9;
                minas.add(x,y);
                i++;
            }  
        }
    }
    
    public void llenarTableroNum(){
        int numMinasLados;
 
        for(int i=0; i<tabla.length; i++){
            for(int j=0; j<tabla.length; j++){
                numMinasLados=0;
                if((i+1)<tabla.length){
                    //Sacar valor de casilla i+1,j
                    numMinasLados = hayMina(i+1,j,numMinasLados);
                    
                    if((j+1)<tabla.length){
                        //Sacar valor de casilla i+1,j+1
                    numMinasLados = hayMina(i+1,j+1,numMinasLados);
                    }
                    
                    if((j-1)>0){
                        //Sacar valor de casilla i+1,j-1
                        numMinasLados = hayMina(i+1,j-1,numMinasLados);
                    }
                    
                }
                if((i-1)<0){
                    //Sacar valor de casilla i-1,j
                    numMinasLados = hayMina(i-1,j,numMinasLados);
                    
                    if((j+1)<tabla.length){
                        //Sacar valor de casilla i-1,j+1
                        numMinasLados = hayMina(i-1,j+1,numMinasLados);
                    }
                    
                    if((j-1)>0){
                        //Sacar valor de casilla i-1,j-1
                        numMinasLados = hayMina(i-1,j-1,numMinasLados);
                    }
                
                }
                
                if((j+1)<tabla.length){
                        //Sacar valor de casilla i,j+1
                        numMinasLados = hayMina(i,j+1,numMinasLados);
                }
                
                if((j-1)>0){
                    //Sacar valor de casilla i-1,j+1
                    numMinasLados = hayMina(i,j-1,numMinasLados);
                    
                }
                
                tabla[i][j].tipo = numMinasLados;
                
                //i+1,j
                //i+1,j+1
                //i+1,j-1
                //i-1,j
                //i-1,j+1
                //i-1,j-1
                //i,j+1
                //i,j-1
                
               
                
                
            }
        }
       
        
    }
    
    public int hayMina(int x, int y, int numMina){
        if(tabla[x][y]==9){
            return numMina++;           
        }
        else{
            return numMina;
        }
    }
    
}