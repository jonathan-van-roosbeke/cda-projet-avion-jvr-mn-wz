package com.avion.collision;

import java.awt.Point;

import com.avion.constante.Constante;
import com.avion.model.Spacecraft;

public abstract class CalculateDistance {
	private CalculateDistance() {

	}

	public static int calculDistance(int meteoriteX, int meteoriteY, int meteoriteTaille, Spacecraft spacecraft) {
		Point spacecraftPoint = new Point(spacecraft.getX() + (Constante.VAISSEAU_WIDTH) / 2,
				spacecraft.getY() + (Constante.VAISSEAU_HEIGHT) / 2);

		Point meteoritePoint = new Point(meteoriteX + (meteoriteTaille / 2), meteoriteY + (meteoriteTaille / 2));

		return (int) Math.sqrt(Math.pow(spacecraftPoint.getX() - meteoritePoint.getX(), 2)
				+ Math.pow(spacecraftPoint.getY() - meteoritePoint.getY(), 2));
	}

	public static boolean isCollided(int meteoriteX, int meteoriteY, int meteoriteTaille, Spacecraft spacecraft) {
		int distance = calculDistance(meteoriteX, meteoriteY, meteoriteTaille, spacecraft);
		int diagonale = (int) (Math.sqrt(Math.pow(Constante.VAISSEAU_HEIGHT, 2) + Math.pow(Constante.VAISSEAU_WIDTH, 2))
				/ 2);

		return Constante.VAISSEAU_HEIGHT / 2 + (meteoriteTaille / 2) > distance + 20
				|| Constante.VAISSEAU_WIDTH / 2 + (meteoriteTaille / 2) > distance + 20 || diagonale > distance + 20;
	}
}
