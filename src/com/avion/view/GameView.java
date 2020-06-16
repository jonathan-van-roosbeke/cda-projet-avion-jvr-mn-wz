package com.avion.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.avion.constante.Constante;

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
		JPanel jTop = new JPanel();
		JPanel jBottom = new JPanel();

		jTop.setBackground(Color.BLUE);
		add(jTop, "North");
		jTop.setPreferredSize(new Dimension(Constante.WIDTH, 40));
		jBottom.setBackground(Color.RED);
		add(jBottom, "South");
		jBottom.setPreferredSize(new Dimension(Constante.WIDTH, 40));
		setVisible(true);
	}
}
