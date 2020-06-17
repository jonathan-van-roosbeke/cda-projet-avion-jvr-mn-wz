package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;
import com.avion.model.Position;

public class MeteoriteSimple extends Meteorite {
	private static NoAnimatedPictures imageUrl = NoAnimatedPictures.METEOR_SIMPLE;

	public MeteoriteSimple(Position position) {
		super(position, imageUrl, 2, 2, 5, 2);
	}
}
