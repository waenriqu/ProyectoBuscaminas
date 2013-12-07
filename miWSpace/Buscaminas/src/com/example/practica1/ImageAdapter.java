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
	protected int distX, nMinas, revelados;
	
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
	public void generaMina(int pos){
		
	int r; 
		
	for(int i = 0; i<nMinas; i++){
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
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina0;
			break;
		case 1:
			tablero[position].cambiarTipo(1);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina1;
			break;
		case 2:
			tablero[position].cambiarTipo(2);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina2;
			break;
		case 3:
			tablero[position].cambiarTipo(3);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina3;
			break;
		case 4:
			tablero[position].cambiarTipo(4);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina4;
			break;
		case 5:
			tablero[position].cambiarTipo(5);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina5;
			break;
		case 6:
			tablero[position].cambiarTipo(6);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina6;
			break;
		case 7:
			tablero[position].cambiarTipo(7);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina7;
			break;
		case 8:
			tablero[position].cambiarTipo(8);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina8;
			break;
		case Casilla.mina:
			tablero[position].cambiarTipo(Casilla.mina);
			descubrirModelCasilla(position);
			mThumbIds[position] = R.drawable.mina;
			break;
		}
	}
	
	
	
	//Pone la imagen de la bandera.
	public void changeImgAfterLongClicked(int position){
		if(mThumbIds[position]==longclicked){
			mThumbIds[position] = R.drawable.oculto;
		} else{
			mThumbIds[position]=longclicked;
		}
	}
	
	public boolean changeImgAfterLongClickedRemixed(int position){
		if (mThumbIds[position]==R.drawable.oculto){
			mThumbIds[position]=longclicked;
		    return true;
		}
		return false;
	}
	
	public void changeImgAfterExplosion(int position){
			mThumbIds[position] = R.drawable.explotado;
			descubrirModelCasilla(position);
			revelados--;
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
	 		
	 		
	        
	 		if((pos7>=0)&&((pos7%distX)-(pos8%distX) == -1)&&(tablero[pos7].getEsMina())){
	 		numMinasLados++;
	 		}
	 		
	 		
	 		if((pos8>=0)&&(tablero[pos8].getEsMina())){
	 		numMinasLados++;
	 		}
	 		
	 		
	 		if((pos9>0)&&(pos9%distX-pos8%distX==1)&&(tablero[pos9].getEsMina())){
	 		numMinasLados++;
	 		}
	 		
	 		if((pos4>=0)&&(pos4%distX-posicion%distX==-1)&&(tablero[pos4].getEsMina())){
	 		numMinasLados++;
	 		}
	 		
	 		if((pos6<tablero.length)&&(pos6%distX-posicion%distX==1)&&(tablero[pos6].getEsMina())){
	 		numMinasLados++;
	 		}
	 		
	 		if((pos1<tablero.length)&&(pos1%distX-pos2%distX==-1)&&(tablero[pos1].getEsMina())){
	 		numMinasLados++;
	 		}
	 		
	        if((pos2<tablero.length)&&(tablero[pos2].getEsMina())){
	 		numMinasLados++;
	 		}
	 		
	 		if((pos3<tablero.length)&&(pos3%distX - pos2%distX==1)&&(tablero[pos3].getEsMina())){
	 		numMinasLados++;
	 		}
	 		
	 		
	 		return numMinasLados;        
	                
	                
	        }

	public void revelarAdy(int posicion){
	    int pos7 = posicion - distX -1;
	    int pos8 = posicion - distX;
	    int pos9 = posicion - distX+1;
	    int pos4 = posicion - 1;
	    int pos6 = posicion + 1;
	    int pos1 = posicion + distX-1;
	    int pos2 = posicion + distX;
	    int pos3 = posicion + distX+1;
	    
	        
	 		if((pos7>=0)&&((pos7%distX)-(pos8%distX) == -1) && (tablero[pos7].isOculto())){
		 		changeImgAfterClicked(pos7, calcularMinas(pos7));	
		 		if(calcularMinas(pos7)==0){
		 			revelarAdy(pos7);
		 		}
	 		}
	 		
	 		
	 		if((pos8>=0)&& (tablero[pos8].isOculto())){
	 			changeImgAfterClicked(pos8, calcularMinas(pos8));	
		 		if(calcularMinas(pos8)==0){
		 			revelarAdy(pos8);
		 		}
	 		}
	 		
	 		
	 		if((pos9>0)&&(pos9%distX-pos8%distX==1)&& (tablero[pos9].isOculto())){
	 			changeImgAfterClicked(pos9, calcularMinas(pos9));	
		 		if(calcularMinas(pos9)==0){
		 			revelarAdy(pos9);
		 		}
	 		}
	 		
	 		if((pos4>=0)&&(pos4%distX-posicion%distX==-1)&& (tablero[pos4].isOculto())){
	 			changeImgAfterClicked(pos4, calcularMinas(pos4));	
		 		if(calcularMinas(pos4)==0){
		 			revelarAdy(pos4);
		 		}
	 		}
	 		
	 		if((pos6<tablero.length)&&(pos6%distX-posicion%distX==1)&& (tablero[pos6].isOculto())){
	 			changeImgAfterClicked(pos6, calcularMinas(pos6));	
		 		if(calcularMinas(pos6)==0){
		 			revelarAdy(pos6);
		 		}
	 		}
	 		
	 		if((pos1<tablero.length)&&(pos1%distX-pos2%distX==-1)&& (tablero[pos1].isOculto())){
	 			changeImgAfterClicked(pos1, calcularMinas(pos1));	
		 		if(calcularMinas(pos1)==0){
		 			revelarAdy(pos1);
		 		}
	 		}
	 		
	        if((pos2<tablero.length)&& (tablero[pos2].isOculto())){
	        	changeImgAfterClicked(pos2, calcularMinas(pos2));	
		 		if(calcularMinas(pos2)==0){
		 			revelarAdy(pos2);
		 		}
	 		}
	 		
	 		if((pos3<tablero.length)&&(pos3%distX - pos2%distX==1)&& (tablero[pos3].isOculto())){
	 			changeImgAfterClicked(pos3, calcularMinas(pos3));	
		 		if(calcularMinas(pos3)==0){
		 			revelarAdy(pos3);
		 		}
	 		}
	 		
	 		     
	                
	                
	        }

	
	public void revelarTodasMinas(){
		for(int i = 0; i < tablero.length; i++){
			if(tablero[i].getEsMina()){
				changeImgAfterClicked(i, Casilla.mina);
			}
		}
	}
	
	public void descubrirModelCasilla(int position){
		tablero[position].cambiarEstado();
		revelados++;
	}
	
	public Boolean isVictoria(){
		if(revelados == (tablero.length - nMinas)){
			return true;
		}
		return false;
	}

	public int getDistX() {
		return distX;
	}
	
	public int getRevelados(){
		return revelados;
	}
	}

	
	


