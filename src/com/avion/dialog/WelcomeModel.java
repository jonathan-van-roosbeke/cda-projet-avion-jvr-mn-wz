package com.avion.dialog;

import com.avion.constante.Constante;

public class WelcomeModel {

	public static boolean canPlay(String name) {
		return name.replace(";", "").length() > Constante.MIN_NAME_LENGTH
				&& name.replace(";", "").length() < Constante.MAX_NAME_LENGTH;
	}
}
