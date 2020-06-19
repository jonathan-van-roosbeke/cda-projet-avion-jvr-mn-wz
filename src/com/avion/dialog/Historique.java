package com.avion.dialog;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.avion.constante.Constante;
import com.avion.outils.Outils;

public class Historique extends JFrame {

	public Historique() {
		setTitle("Record Top 20");

		setBounds(Constante.CENTER_SCREEN + 75, 200, 600, 400);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		String str = "";
		String[][] tab = new String[Outils.readFile().size()][4];
		String[][] result = new String[Outils.readFile().size()][4];

		for (int i = 0; i < Outils.readFile().size(); i++) {
			str = (String) Outils.readFile().get(i);
			tab[i] = str.split(",");
			for (int j = 0; j < tab[i].length; j++) {
				result[i][0] = Integer.toString(i + 1);
				result[i][j + 1] = tab[i][j];
			}
		}

		String[] colName = { "Rank", "Score", "Name", "Date" };

		JTable table = new JTable(result, colName);
		JScrollPane scroll = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		getContentPane().add(scroll);
		setVisible(true);
	}
}
