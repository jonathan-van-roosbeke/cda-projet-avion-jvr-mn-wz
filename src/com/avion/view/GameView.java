package com.avion.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.avion.constante.Constante;
import com.avion.constante.NoAnimatedPictures;
import com.avion.controleur.Controller;
import com.avion.dialog.Welcome;
import com.avion.model.SpaceGame;

public class GameView extends JFrame {

	private Image img;

	public GameView() {
		init();
	}

	public void init() {
		Image im = Toolkit.getDefaultToolkit().getImage(NoAnimatedPictures.METEOR_SIMPLE.getUrl());
		setIconImage(im);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(Constante.CENTER_SCREEN, 0, Constante.WIDTH, Constante.HEIGHT);
		this.setSize(Constante.WIDTH, Constante.HEIGHT);
		this.setTitle("avion");
		setLayout(new BorderLayout());
		setResizable(false);

		GuiInfo guiInfo = new GuiInfo();
		SpaceGame spacegame = new SpaceGame(this);

		this.getContentPane().add(guiInfo, BorderLayout.NORTH);
		this.getContentPane().add(spacegame, BorderLayout.CENTER);
		Controller controller;

		GuiClavier clavier = new GuiClavier();
		controller = new Controller(clavier, spacegame.getVaisseau());
		if (Welcome.isChecked) {
			this.getContentPane().add(clavier, BorderLayout.SOUTH);
		}

//		new Replay(gameView);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		this.addKeyListener(controller);
		setVisible(true);
	}
}
