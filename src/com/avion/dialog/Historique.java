package com.avion.dialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Historique extends JFrame {

	public Historique() {
		int dialogButton = JOptionPane.CLOSED_OPTION;
		JOptionPane.showConfirmDialog(this, "Replay?", "quitter", dialogButton);
		// afficher l'historique
		System.exit(0);
	}
}
