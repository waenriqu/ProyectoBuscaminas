package com.example.practica1;

import android.app.Activity;
import android.widget.ImageView;

public class RelojBarrier extends Reloj {
	private double barrier;
	public final double damage = 20.00;
	public static final double explosion = 60.00;
	

	RelojBarrier(ModoPadre activity) {
		super(activity);
		barrier = 100.00;
	}
	
	RelojBarrier(ModoPadre activity, int cont, double barrier){
		super(activity,cont);
		this.barrier = barrier;
	}
	
	
	public void run(){
		super.run();
			barrier -= damage;
			if(barrier<0){
				barrier = 0;
			}
			updateBarrier();
	}
	
	public void updateBarrier(){
		ImageView bar = (ImageView) activity.findViewById(R.id.barrier);
		if (barrier>90.00){
			bar.setImageResource(R.drawable.bar100);
			bar.invalidate();
			return;
		}
		if (barrier>80.00){
			bar.setImageResource(R.drawable.bar90);
			bar.invalidate();
			return;
		}
		if (barrier>70.00){
			bar.setImageResource(R.drawable.bar80);
			bar.invalidate();
			return;
		}
		if (barrier>60.00){
			bar.setImageResource(R.drawable.bar70);
			bar.invalidate();
			return;
		}
		if (barrier>50.00){
			bar.setImageResource(R.drawable.bar60);
			bar.invalidate();
			return;
		}
		if (barrier>40.00){
			bar.setImageResource(R.drawable.bar50);
			bar.invalidate();
			return;
		}
		if (barrier>30.00){
			bar.setImageResource(R.drawable.bar40);
			bar.invalidate();
			return;
		}
		if (barrier>20.00){
			bar.setImageResource(R.drawable.bar30);
			bar.invalidate();
			return;
		}
		if (barrier == 0.00){
			bar.setImageResource(R.drawable.bar00);
			activity.resetCombo();
			bar.invalidate();
			return;
		}
		bar.setImageResource(R.drawable.bar20);
		bar.invalidate();
	}
	
	public void subirBarrier(){
		barrier = 100;
		updateBarrier();
	}
	
	public void subirBarrierBandera(){
		barrier+= damage;
		updateBarrier();
	}
	
	
	public void explosionBarrier(){
		barrier-=explosion;
		updateBarrier();
	}
	
	public double getBarrier(){
		return barrier;
	}

}
