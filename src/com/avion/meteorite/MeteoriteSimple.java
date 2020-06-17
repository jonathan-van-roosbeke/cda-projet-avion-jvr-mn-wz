package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;

public class MeteoriteSimple extends Meteorite {

	public MeteoriteSimple() {
		super();
	}

	@Override
	public int getVitesse() {
		return Properties.METEORITE_SIMPLE.getVitesse();
	}

	@Override
	public int getTaille() {
		return Properties.METEORITE_SIMPLE.getTaille();
	}

	@Override
	public int getDegat() {
		return Properties.METEORITE_SIMPLE.getDegat();
	}

	@Override
	public int getValeur() {
		return Properties.METEORITE_SIMPLE.getValeur();
	}

	@Override
	public NoAnimatedPictures getImageUrl() {
		// TODO Auto-generated method stub
		return NoAnimatedPictures.METEOR_SIMPLE;
	}

}
