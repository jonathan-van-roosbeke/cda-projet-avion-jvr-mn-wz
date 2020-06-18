package com.avion.dialog;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import com.avion.constante.Constante;
import com.avion.outils.Outils;

public class Historique extends JFrame {

	public Historique() {
		setTitle("Record Top 20");
		setBounds(Constante.WIDTH, Constante.HEIGHT, 400, 400);
		setLayout(new BorderLayout());

		JList<String> rec = new JList<String>((String[]) Outils.readFile().toArray(new String[0]));

		JScrollPane scroll = new JScrollPane(rec);
		getContentPane().add(scroll);

		setVisible(true);
	}

}
