package com.avion.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class GuiInfo extends JPanel {
	public GuiInfo() {

		setLayout(new GridLayout(2, 1));

		setBackground(new Color(6, 6, 16));
		Info info = new Info();
		LifeBar lifeBar = new LifeBar();

		this.add(info);
		this.add(lifeBar);

		setVisible(true);
	}
}
