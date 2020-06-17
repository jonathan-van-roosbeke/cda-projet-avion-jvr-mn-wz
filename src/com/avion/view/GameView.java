package com.avion.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.avion.constante.Constante;
import com.avion.controleur.Controller;
import com.avion.model.ScrollingBackground;

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
		ScrollingBackground background = new ScrollingBackground();
		addKeyListener(controller);
		getContentPane().add(background);
		add(guiInfo, "North");
		guiInfo.setPreferredSize(new Dimension(Constante.WIDTH, 60));

		// Spacecraft spacecraft = new Spacecraft();
		Container c = getContentPane();
		// c.add(spacecraft);

		add(guiClavier, "South");
		setVisible(true);
	}

	public static void main(String[] args) {
		new GameView();
	}
}