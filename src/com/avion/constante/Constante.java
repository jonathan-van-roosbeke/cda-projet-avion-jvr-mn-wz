package com.avion.constante;

import java.awt.Color;
import java.awt.Toolkit;

public class Constante {

	public static final int WIDTH = 768;
	public static final int HEIGHT = 1000;
	public static final int CENTER_SCREEN = (Toolkit.getDefaultToolkit().getScreenSize().width - WIDTH) / 2;

	public static final int MIN_NAME_LENGTH = 3;
	public static final int MAX_NAME_LENGTH = 6;
	public static final Color BACKGROUND_COLOR = new Color(6, 6, 16);
	public static final Color TEXT_COLOR = new Color(242, 242, 242);

	public static final int BACKGROUND_HEIGHT = 1729;
	public static final int BACKGROUD_SPEED = 1;

	public static final int VAISSEAU_SPEED = 10;
	public static final int VAISSEAU_WIDTH = 80;
	public static final int VAISSEAU_HEIGHT = 66;

	public static final int HEIGHT_CLAVIER = 130;

	public enum DIRECTION {
		UP, RIGHT, DOWN, LEFT, UP_RIGHT, DOWN_RIGHT, UP_LEFT, DOWN_LEFT
	}

	public enum HORIZONTAL {
		LEFT, RIGHT
	}

	public enum VERTICAL {
		UP, DOWN
	}
}
