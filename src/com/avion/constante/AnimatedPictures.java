package com.avion.constante;

public abstract class AnimatedPictures {

	public static String[] tVaisseau = { "/images/vaisseau/vaisseau_top.png", "/images/vaisseau/vaisseau_left.png",
			"/images/vaisseau/vaisseau_right.png" };

	public static String[] tExplosion = { "/images/explosion/explosion.gif" };

	public static String[] tReacteur = { "/images/reacteur/reacteur_03.gif" };

	public static String[] getTab(int index) {
		switch (index) {
		case 0:
			return tVaisseau;
		case 1:
			return tExplosion;
		case 2:
			return tReacteur;
		}
		return null;
	}

}
