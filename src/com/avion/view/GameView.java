package com.avion.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.avion.constante.Constante;
import com.avion.controleur.Controller;
import com.avion.meteorite.RandomMeteorite;

public class GameView extends JFrame {

	public GameView() {
		init();
	}

	public void init() {
		setBounds(Constante.CENTER_SCREEN, 0, Constante.WIDTH, Constante.HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel jBottom = new JPanel();

		GuiInfo guiInfo = new GuiInfo();
		GuiClavier guiClavier = new GuiClavier();
		Controller controller = new Controller(guiClavier);
		addKeyListener(controller);
		add(new RandomMeteorite(), "Center");
		add(guiInfo, "North");
		guiInfo.setPreferredSize(new Dimension(Constante.WIDTH, 60));

		add(guiClavier, "South");
		setVisible(true);
	}

	public static void main(String[] args) {
		new GameView();
	}
}