package com.avion.model;

import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.avion.constante.AnimatedPictures;

public class Spacecraft extends JPanel {
	private boolean bool = true;

	public Spacecraft() {

		setLayout(new GridLayout(2, 1));

		JLabel scraft = new JLabel();
		Icon img = new ImageIcon(AnimatedPictures.tVaisseau[0]);
		scraft.setSize(img.getIconWidth(), img.getIconHeight());
		scraft.setIcon(img);
		this.add(scraft);

		JLabel reactor = new JLabel();
		Icon img2 = new ImageIcon(AnimatedPictures.tReacteur[0]);
		reactor.setSize(img2.getIconWidth(), img2.getIconHeight());
		reactor.setIcon(img2);
		this.add(reactor);
	}

}
