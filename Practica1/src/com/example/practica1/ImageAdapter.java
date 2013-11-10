package com.example.practica1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
	
	private Context mContext;
	private int imgSize;;
	protected Integer[] mThumbIds;
	private int clicked = R.drawable.mina;
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
		return mThumbIds.length;
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

	public void changeImgAfterClicked(int position){
		mThumbIds[position] = clicked;
	}
	
	public void resetTablero(){
		
		for(int i : mThumbIds){
			mThumbIds[i] = R.drawable.oculto;
			
		}
	}

	}
	
	


