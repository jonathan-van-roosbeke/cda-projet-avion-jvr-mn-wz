package com.avion.model;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.avion.constante.AnimatedPictures;
import com.avion.constante.Constante;

public class Spacecraft extends JLabel {

	/**
	 * Generer automatiquement pour eviter les warning
	 */
	private static final long serialVersionUID = 1L;
	private JLabel vaisseau;
	private JLabel reacteur;
	private int choixImgVaisseau;

	public Spacecraft() {

		vaisseau = new JLabel(new ImageIcon(getClass().getResource(AnimatedPictures.tVaisseau[choixImgVaisseau])));
		reacteur = new JLabel(new ImageIcon(getClass().getResource(AnimatedPictures.tReacteur[0])));
		setLocation((Constante.WIDTH / 2) - (Constante.VAISSEAU_WIDTH / 2),
				(Constante.HEIGHT - Constante.HEIGHT_CLAVIER) - Constante.VAISSEAU_HEIGHT - 200);

		this.setLayout(new BorderLayout());
		this.add(vaisseau, "Center");
		this.add(reacteur, "South");

		this.setSize(Constante.VAISSEAU_WIDTH, Constante.VAISSEAU_HEIGHT + 18);
	}

	public JLabel getVaisseau() {
		return vaisseau;
	}
}
