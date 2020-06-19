package com.avion.dialog;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.avion.view.GameView;

public class WelcomeController extends MouseAdapter implements KeyListener {

	private JTextField saisie;
	private JLabel error;
	private static String date;
	private static String name;

	public WelcomeController(JTextField saisie, JLabel error) {
		this.error = error;
		this.saisie = saisie;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (saisie.getText() != null && WelcomeModel.canPlay(saisie.getText())) {
			SwingUtilities.getWindowAncestor(((JLabel) e.getSource()).getParent()).dispose();
			name = saisie.getText();
			new GameView();
		} else {
			saisie.setText("");
			error.setText("Erreur de saisie");
		}
	}

	public static String getDate() {
		return date;
	}

	public static String getName() {
		return name;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// empty
	}

	@Override
	public void keyPressed(KeyEvent e) {
		error.setText("");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (saisie.getText() != null && WelcomeModel.canPlay(saisie.getText())) {
				SwingUtilities.getWindowAncestor(((JTextField) e.getSource()).getParent()).dispose();
				name = saisie.getText();
				new GameView();
			} else {
				saisie.setText("");
				error.setText("Erreur de saisie");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// empty
	}
}
