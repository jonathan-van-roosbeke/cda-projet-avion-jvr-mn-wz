package com.avion.view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.avion.constante.Constante;
import com.avion.constante.NoAnimatedPictures;
import com.avion.controleur.Controller;
import com.avion.model.SpaceGame;

public class GameView extends JFrame {

	Image img;

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
		GuiClavier clavier = new GuiClavier();
		SpaceGame spacegame = new SpaceGame();
		Controller controller = new Controller(clavier, spacegame.getVaisseau());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		this.getContentPane().add(guiInfo, BorderLayout.NORTH);
		this.getContentPane().add(spacegame, BorderLayout.CENTER);
		this.getContentPane().add(clavier, BorderLayout.SOUTH);

		this.addKeyListener(controller);
		setVisible(true);
	}
}
