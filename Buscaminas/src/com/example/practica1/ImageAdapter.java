package com.example.practica1;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	
	private Context mContext;
	private int imgSize;
	protected Casilla[] tablero;
	protected Integer[] mThumbIds;
	private int longclicked = R.drawable.bandera;
	protected int distX;
	
	/**
	 * @param args
	 */
	
	 public ImageAdapter(Context c, int imgSize) {
	        mContext = c;
	        this.imgSize = imgSize;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tablero.length;
	}
	
	//Llena de minas el tablero de forma aleatoria. Primero verfica que la casilla no tenga mina para luego colocarla. También evita colocar minas en la posición donde se dio el primer click
	public void generaMina(int nminas, int pos){
		
	int r; 

	
	
	for(int i = 0; i<nminas; i++){
		do{
			r = ((int)(Math.random()*tablero.length));
		}while(tablero[r].getEsMina() || r == pos);
		
		tablero[r].setEsMina(true);
	}
	
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO Auto-generated method stub
        ImageView imageView;
        if (arg1 == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(imgSize, imgSize));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) arg1;
        }
 
        imageView.setImageResource(mThumbIds[arg0]);
        return imageView;
    }

	
	//Pone la imagen de la mina.
	public void changeImgAfterClicked(int position, int tipo){
		switch (tipo){
		case 0:
			tablero[position].cambiarTipo(0);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina0;
			break;
		case 1:
			tablero[position].cambiarTipo(1);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina1;
			break;
		case 2:
			tablero[position].cambiarTipo(2);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina2;
			break;
		case 3:
			tablero[position].cambiarTipo(3);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina3;
			break;
		case 4:
			tablero[position].cambiarTipo(4);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina4;
			break;
		case 5:
			tablero[position].cambiarTipo(5);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina5;
			break;
		case 6:
			tablero[position].cambiarTipo(6);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina6;
			break;
		case 7:
			tablero[position].cambiarTipo(7);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina7;
			break;
		case 8:
			tablero[position].cambiarTipo(8);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina8;
			break;
		case Casilla.mina:
			tablero[position].cambiarTipo(Casilla.mina);
			tablero[position].cambiarEstado();
			mThumbIds[position] = R.drawable.mina;
			break;
		}
	}
	
	
	//Pone la imagen de la bandera.
	public void changeImgAfterLongClicked(int position){
		mThumbIds[position]=longclicked;
	}
	
	
	//Pone todo en el tablero como oculto.
	

	public Casilla[] getTablero() {
		return tablero;
	}
	
	public Integer[] getGraphics() {
		return mThumbIds;
	}
	
	//Llena el tablero de imagenes de celdas ocultas.
	public void llenarOcultos(){
		
	}
	
	
	
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
	 		
	        
	 		if((pos7>0)&&(pos7%distX-pos8%distX == 1)&&(tablero[pos7].tipo == 0)){
	 		numMinasLados++;
	 		}
	 		
	 		
	 		if((pos8>0)&&(tablero[pos8].tipo == 0)){
	 		numMinasLados++;
	 		}
	 		
	 		
	 		if((pos9>0)&&(pos9%distX-pos8%distX==1)&&(tablero[pos9].tipo == 0)){
	 		numMinasLados++;
	 		}
	 		
	 		if((pos4>9)&&(pos4%distX-posicion%distX==1)&&(tablero[pos4].tipo == 0)){
	 		numMinasLados++;
	 		}
	 		
	 		if((pos6<tablero.length)&&(pos6%distX-posicion%distX==1)&&(tablero[pos6].tipo == 0)){
	 		numMinasLados++;
	 		}
	 		
	 		if((pos1<tablero.length)&&(pos1%distX-pos2%distX==1)&&(tablero[pos1].tipo == 0)){
	 		numMinasLados++;
	 		}
	 		
	        if((pos2<tablero.length)&&(tablero[pos2].tipo == 0)){
	 		numMinasLados++;
	 		}
	 		
	 		if((pos3<tablero.length)&&(pos3%distX - pos2%distX==1)&&(tablero[pos3].tipo == 0)){
	 		numMinasLados++;
	 		}
	 		
	 		
	 		return numMinasLados;        
	                
	                
	        }


	}
	
	


