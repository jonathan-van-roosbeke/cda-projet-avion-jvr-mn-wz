package com.avion.dialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.avion.view.GameView;

public class WelcomeController extends MouseAdapter {

	private JTextField saisie;
	private JLabel error;

	public WelcomeController(JTextField saisie, JLabel error) {
		this.error = error;
		this.saisie = saisie;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (saisie.getText() != null && WelcomeModel.canPlay(saisie.getText())) {
			SwingUtilities.getWindowAncestor(((JLabel) e.getSource()).getParent()).dispose();
			new GameView();
		} else {
			saisie.setText("");
			error.setText("Erreur de saisie");
		}
	}
}
