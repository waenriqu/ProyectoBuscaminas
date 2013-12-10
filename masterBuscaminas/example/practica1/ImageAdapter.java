package com.example.buscaminasremix;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
/**
 * ImageAdapter hereda de baseAdapter y se encarga principalmente en usar un arreglo de imagenes
 * para crear un GridView que se lo presenta al usuario como el tablero del juego. Esta clase controla
 * y conecta el modelo del juego con la parte gr�fica. Por eso contiene tambi�n m�todos que modelan 
 * la l�gica del juego. Todos los tableros: f�cil, normal y dif�cil heredan de esta clase, ya que la
 * l�gica del juego es la misma en cada dificultad, solo cambia el tama�o del tablero y el n�mero de minas. 
 * 
 * @author      Gabriel Aumala
 * @author		Wilson Enriquez
 */
public class ImageAdapter extends BaseAdapter{
	
	private Context mContext;
	private int imgSize;
	protected Casilla[] tablero;
	protected Integer[] mThumbIds;
	private int longclicked = R.drawable.bandera;
	protected int distX, nMinas, revelados;
	
	/**
	 * Crea un nuevo objeto adaptador que crea el GridView que se muestra por pantalla a partir
	 * de un arreglo de im�genes. Esta clase nunca se instancia se usa para crear tableros. Cada dificultad 
	 * tiene un tablero que hereda de esta clase. Por lo tanto las funciones que modelan el comportamiento del juego
	 * tambi�n se incluyen aqu�.
	 * @param  c  el contexto de la actividad.
	 * @param imgSize el tama�o m�ximo de cada casilla de acuerdo a la resoluci�n de la pantalla.
	 * @return      Objeto adaptador
	 */
	 public ImageAdapter(Context c, int imgSize) {
	        mContext = c;
	        this.imgSize = imgSize;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Retorna el tama�o del arreglo de im�genes usadas por el adaptador
	 * @return  Entero con la dimensi�n del arreglo
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tablero.length;
	}
	/**
	 * Llena de minas el tablero de forma aleatoria. Primero verfica que la casilla no tenga una  
	 * mina para luego colocarla. Tambi�n evita colocar minas en la posici�n donde se dio el primer click.
	 * @param  pos  La posici�n donde se di� el primer click.
	 */
	//
	public void generaMina(int pos){
		
	int r; 
		
	for(int i = 0; i<nMinas; i++){
		do{
			r = ((int)(Math.random()*tablero.length));
		}while(tablero[r].getEsMina() || r == pos);
		
		tablero[r].setEsMina(true);
	}
	
	}
	/**
	 * Funci�n que retorna null ya que no se usa, pero la clase padre BaseAdapter nos obliga a implementarla.
	 * @param  arg0 entero con una posici�n
	 * @return  null
	 */
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Funci�n que retorna 0 ya que no se usa, pero la clase padre BaseAdapter nos obliga a implementarla.
	 * @param  arg0 entero con una posici�n
	 * @return  0
	 */
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Genera cada View que se muestra por pantalla de cada casilla del tablero. Si el view no es reciclado
	 * se lo inicializa con atributos tales como el padding, el contexto de la actividad y el tama�o m�ximo
	 * de la casilla.
	 * @param  arg0 entero con la posici�n de la imagen en el arreglo que le corresponde al View en cuesti�n
	 * @param  arg1 el View actual
	 * @param  arg2 un ViewGroup que no se usa por ahora
	 * @return  el View que representa a la casilla con indice 'arg0'
	 */
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

	
	/**
	 * Funci�n que cumple el papel de controlador entre el modelo y el View. Revela la casilla colocando la
	 * imagen pertinente en el arreglo de im�genes (View) y marcando como descubierto el objeto en el arreglo de
	 * casillas con el mismo indice (Model). Ambos arreglos, Model y View, son del mismo tama�o y son sim�tricos, la
	 * casilla y su im�gen comparten el mismo indice estando en diferentes arreglos.
	 * @param  position Entero con la posicion de la casilla a ser revelada.
	 * @param  tipo Entero que muestra el n�mero que debe de ser pintado en la casilla tras ser revelado. '1-8' es
	 * para n�mero de minas adyacentes, '0' es para una casilla vac�a y '9' es para una mina.
	 */
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
	
	
	
	/**
	 * Coloca la imagen de la bandera tras un longClick. Si ya hay una bandera
	 * entonces se la remueve para que la casilla quede sin nada. Esta funci�n se
	 * usa en los modos cl�sicos.
	 * @param  position Entero con la posicion de la casilla a la cual se le dio un longClick
	 */
	public void changeImgAfterLongClicked(int position){
		if(mThumbIds[position]==longclicked){
			mThumbIds[position] = R.drawable.oculto;
		} else{
			mThumbIds[position]=longclicked;
		}
	}
	/**
	 * Coloca la imagen de la bandera tras un longClick. No permite remover banderas.
	 * Se usa en el modo remix.
	 * @param  position Entero con la posicion de la casilla a la cual se le dio un longClick
	 * @return true si se coloc� una bandera exitosamente, de lo contrario false
	 */
	public boolean changeImgAfterLongClickedRemixed(int position){
		if (mThumbIds[position]==R.drawable.oculto){
			mThumbIds[position]=longclicked;
		    return true;
		}
		return false;
	}
	/**
	 * Coloca la imagen de bandera azul, que notifica al jugador que ha pisado una mina pero que
	 * se ha salvado tras perder una de sus vidas. Se usa en el modo remix. La casilla queda descubierta,
	 * pero el n�mero de casillas reveladas no aumenta para que el juego no termine prematuramente.
	 * @param  position Entero con la posicion de la casilla a la cual se hall� una mina
	 */
	public void changeImgAfterExplosion(int position){
			mThumbIds[position] = R.drawable.explotado;
			descubrirModelCasilla(position);
			revelados--;
	}
	
	
	//Pone todo en el tablero como oculto.
	
	/**
	 * Retorna el arreglo de casillas que contienen la l�gica que modela el juego (Model).
	 * @return  el arreglo de Casillas
	 */
	public Casilla[] getTablero() {
		return tablero;
	}
	/**
	 * Retorna el arreglo de las im�genes de las casillas (View).
	 * @return  el arreglo de im�genes integers
	 */
	public Integer[] getGraphics() {
		return mThumbIds;
	}
	
	/**
	 * Funci�n que c�lcula el n�mero de minas adyacentes a una casilla procurando no tratar
	 * de entrar en posiciones invalidas del arreglo de casillas (Model).
	 * @param  posicion Entero con la posicion de la casilla a la cual se le calcular�n las minas adyacentes
	 * @return el n�mero de minas adyacentes
	 */
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
	/**
	 * Funci�n que recursivamente revela todas las casillas adyacentes tras haberse determinado que no contienen minas.
	 * @param  posicion Entero con la posicion de la casilla a la cual se le revelar�n las minas adyacentes
	 */
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

	/**
	 * Funci�n que recorre todo el arreglo de casillas (Model) en b�squeda de todas las minas. En caso de encontrar una,
	 * la revela y actualiza tanto el Model como el View, haciendo papel de controlador.
	 */
	public void revelarTodasMinas(){
		for(int i = 0; i < tablero.length; i++){
			if(tablero[i].getEsMina()){
				changeImgAfterClicked(i, Casilla.mina);
			}
		}
	}
	/**
	 * Funci�n que descubre las casillas en el modelo. les cambia el estado y aumenta el contador de casillas reveladas.
	 */
	public void descubrirModelCasilla(int position){
		tablero[position].cambiarEstado();
		revelados++;
	}
	/**
	 * Funci�n que verifica si el jugador ha ganado. El jugador gana cuando el n�mero de casillas reveladas es igual al n�mero
	 * de casillas en el arreglo menos el n�mero de minas contenidas.
	 * @return true si el jugador gan�, false si a�n no lo logra
	 */
	public Boolean isVictoria(){
		if(revelados == (tablero.length - nMinas)){
			return true;
		}
		return false;
	}
	/**
	 * Retorna el n�mero de columnas del tablero.
	 * @return Entero con el n�mero de columnas del tablero
	 */
	public int getDistX() {
		return distX;
	}
	/**
	 * Retorna el n�mero de casillas que se han revelado hasta ahora.
	 * @return Entero con el n�mero de casillas reveladas en la partida
	 */
	public int getRevelados(){
		return revelados;
	}
	
	
	}

	
	


