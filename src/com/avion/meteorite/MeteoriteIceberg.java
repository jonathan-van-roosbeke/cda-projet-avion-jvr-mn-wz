package com.avion.meteorite;

import com.avion.constante.NoAnimatedPictures;
import com.avion.model.Position;

public class MeteoriteIceberg extends MeteoriteDeGlace {

	public MeteoriteIceberg(Position position, NoAnimatedPictures image, int vitesse, int degat, int taille,
			int valeurPoint) {
		super(position, image, 2, 2, 5, 2);
	}

}
