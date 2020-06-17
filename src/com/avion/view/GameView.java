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
		// setBounds(Constante.CENTER_SCREEN, 0, Constante.WIDTH, Constante.HEIGHT);
		this.setSize(Constante.WIDTH, Constante.HEIGHT);
		this.setLocation(900, 20);
		this.setTitle("avion");
		setLayout(new BorderLayout());
		// setResizable(false);

		// Controller controller = new Controller(guiClavier);
		// ScrollingBackground background = new ScrollingBackground();
		// addKeyListener(controller);
		// getContentPane().add(background);
		// add(guiInfo, "North");
		// guiInfo.setPreferredSize(new Dimension(Constante.WIDTH, 60));

		this.getContentPane().add(new GuiInfo(), BorderLayout.NORTH);
		this.getContentPane().add(new SpaceGame(), BorderLayout.CENTER);
		this.getContentPane().add(new GuiClavier(), BorderLayout.SOUTH);

		// add(guiClavier, "South");
		setVisible(true);
	}

//	public static void main(String[] args) {
//		new GameView();
//	}
}
