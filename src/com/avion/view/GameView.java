package com.avion.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.avion.constante.Constante;
import com.avion.model.Spacecraft;

public class GameView extends JFrame {

	public GameView() {
		init();
	}

	public void init() {
		setBounds(Constante.CENTER_SCREEN, 0, Constante.WIDTH, Constante.HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel jLeft = new JPanel();
		JPanel jRight = new JPanel();
		JPanel jBottom = new JPanel();

		// JPanel jTop = new JPanel();
		GuiInfo guiInfo = new GuiInfo();
		add(guiInfo, "North");
		guiInfo.setPreferredSize(new Dimension(Constante.WIDTH, 60));

		jBottom.setBackground(Color.RED);
		add(jBottom, "South");
		jBottom.setPreferredSize(new Dimension(Constante.WIDTH, 40));

		Container c = getContentPane();
		Spacecraft spacecraft = new Spacecraft();
		c.add(spacecraft);

		setVisible(true);
	}

	public static void main(String[] args) {
		new GameView();
	}
}
