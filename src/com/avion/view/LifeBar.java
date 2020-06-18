package com.avion.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.avion.model.MeteoritesMoving;

public class LifeBar extends JPanel {

	static JLabel l1;
	static JLabel l2;
	static JLabel l3;
	static JLabel l4;
	static JLabel l5;

	public LifeBar() {
		setLayout(new GridLayout(1, 5));

		setBackground(new Color(6, 6, 16));

		l1 = new JLabel();
		l1.setIcon(new ImageIcon("resources/images/vie/01_vie_on.png"));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l1);

		l2 = new JLabel();
		l2.setIcon(new ImageIcon("resources/images/vie/02_vie_on.png"));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l2);

		l3 = new JLabel();
		l3.setIcon(new ImageIcon("resources/images/vie/03_vie_on.png"));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l3);

		l4 = new JLabel();
		l4.setIcon(new ImageIcon("resources/images/vie/04_vie_on.png"));
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l4);

		l5 = new JLabel();
		l5.setIcon(new ImageIcon("resources/images/vie/05_vie_on.png"));
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(l5);

		setVisible(true);
	}

	public static void setLifeBar(int nb) {
		nb = MeteoritesMoving.getLife();
		if (nb < 80) {
			l5.setIcon(new ImageIcon("resources/images/vie/01_vie_off.png"));
			l5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (nb < 60) {
			l4.setIcon(new ImageIcon("resources/images/vie/01_vie_off.png"));
			l4.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (nb < 40) {
			l3.setIcon(new ImageIcon("resources/images/vie/01_vie_off.png"));
			l3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (nb < 20) {
			l2.setIcon(new ImageIcon("resources/images/vie/01_vie_off.png"));
			l2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if (nb < 5) {
			l1.setIcon(new ImageIcon("resources/images/vie/01_vie_off.png"));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
}
