package com.avion.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.avion.constante.Constante;
import com.avion.model.SpaceGame;

public class GameView extends JFrame {

	public GameView() {
		init();
	}

	public void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(Constante.WIDTH, Constante.HEIGHT);
		this.setLocation(900, 20);
		this.setTitle("avion");
		setLayout(new BorderLayout());
		this.getContentPane().add(new GuiInfo(), BorderLayout.NORTH);
		this.getContentPane().add(new SpaceGame(), BorderLayout.CENTER);
		this.getContentPane().add(new GuiClavier(), BorderLayout.SOUTH);

		setVisible(true);
	}
// 
//	public static void main(String[] args) {
//		new GameView();
//	}
}
