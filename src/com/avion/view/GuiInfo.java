package com.avion.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.avion.constante.Constante;

public class GuiInfo extends JPanel {
	public GuiInfo() {
		setPreferredSize(new Dimension(Constante.WIDTH, 60));
		setLayout(new GridLayout(2, 1));

		setBackground(new Color(6, 6, 16));
		Info info = new Info();
		LifeBar lifeBar = new LifeBar();

		this.add(info);
		this.add(lifeBar);

		setVisible(true);
	}
}
