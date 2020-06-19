package com.avion.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.avion.constante.Constante;

public class GuiInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	static LifeBar vLifeBar;

	public GuiInfo() {
		setPreferredSize(new Dimension(Constante.WIDTH, 60));
		setLayout(new GridLayout(2, 1));
		setBackground(new Color(6, 6, 16));

		this.add(new Info());
		this.add(new LifeBar());

		setVisible(true);
	}

}
