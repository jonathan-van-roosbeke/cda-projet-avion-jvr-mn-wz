package com.avion.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LifeBar extends JPanel {

	public LifeBar() {
		setLayout(new GridLayout(1, 5));

		setBackground(new Color(6, 6, 16));

		for (int i = 0; i < 5; i++) {
			JLabel label = new JLabel();
			label.setIcon(new ImageIcon("resources/images/vie/0" + (i + 1) + "_vie_on.png"));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			this.add(label);
		}

		setVisible(true);
	}
}
