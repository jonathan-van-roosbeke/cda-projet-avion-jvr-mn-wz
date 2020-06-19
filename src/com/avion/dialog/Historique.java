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
		setSize(400, 400);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JList<String> rec = new JList<>((String[]) Outils.readFile().toArray(new String[0]));
		JScrollPane scroll = new JScrollPane(rec);
		getContentPane().add(scroll);
		setLocation(Constante.CENTER_SCREEN + 150, 200);
		setVisible(true);
	}
}
