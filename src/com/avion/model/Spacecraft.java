package com.avion.model;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.avion.constante.AnimatedPictures;

public class Spacecraft extends JPanel {

	public Spacecraft() {

		this.setLayout(new GridBagLayout());
//		this.setLocation(Constante.WIDTH / 2, Constante.HEIGHT / 3 * 2);
//		setBounds(100, 100, 20, 20);

		JLabel scraft = new JLabel();
		Icon img = new ImageIcon(AnimatedPictures.tVaisseau[0]);
		scraft.setIcon(img);
		scraft.setPreferredSize(new Dimension(20, 20));
//		scraft.getPreferredSize();

		JLabel reactor = new JLabel();
		Icon img2 = new ImageIcon(AnimatedPictures.tReacteur[2]);
		reactor.setIcon(img2);
		scraft.setPreferredSize(new Dimension(20, 20));
//		reactor.getPreferredSize();

		GridBagConstraints consSpacecraft = new GridBagConstraints();
		consSpacecraft.gridx = 0;
		consSpacecraft.gridy = 0;
		this.add(scraft, consSpacecraft);

		GridBagConstraints consReactor = new GridBagConstraints();
		consReactor.gridx = 0;
		consReactor.gridy = 1;
		this.add(reactor, consReactor);
	}
}
