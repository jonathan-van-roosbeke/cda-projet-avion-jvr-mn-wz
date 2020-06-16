package com.avion.constante;

public enum NoAnimatedPictures {

	BACKGROUND("resources/images/background/background_space.png"),
	METEOR_SIMPLE("resources/images/meteor/meteor_simple.png"), METEOR_FEUX("resource/images/meteor/meteor_feux.png"),
	METEOR_GLACE("resources/images/meteor/meteor_glace.png"),
	METEOR_ICEBERG("resources/images/meteor/meteor_iceberg.png"),
	METEOR_ZIGZAG("resources/images/meteor/meteor_zigzag.png"),
	FLECHE_H_OFF("resources/images/fleche/fleche_h_off.png"), FLECHE_H_ON("resources/images/fleche/fleche_h_on.png"),
	FLECHE_B_OFF("resources/images/fleche/fleche_b_off.png"), FLECHE_B_ON("resources/images/fleche/fleche_b_on.png"),
	FLECHE_G_OFF("resources/images/fleche/fleche_g_off.png"), FLECHE_G_ON("resources/images/fleche/fleche_g_on.png"),
	FLECHE_D_OFF("resources/images/fleche/fleche_d_off.png"), FLECHE_D_ON("resources/images/fleche/fleche_d_on.png"),
	VIE_01_OFF("resources/images/vie/01_vie_off"), VIE_01_ON("resources/images/vie/01_vie_off"),
	VIE_02_OFF("resources/images/vie/02_vie_off"), VIE_02_ON("resources/images/vie/02_vie_off"),
	VIE_03_OFF("resources/images/vie/03_vie_off"), VIE_03_ON("resources/images/vie/03_vie_off"),
	VIE_04_OFF("resources/images/vie/04_vie_off"), VIE_04_ON("resources/images/vie/04_vie_off"),
	VIE_05_OFF("resources/images/vie/05_vie_off"), VIE_05_ON("resources/images/vie/05_vie_off");

	private String url;

	private NoAnimatedPictures(String pUrl) {
		this.url = pUrl;
	}

	public String getUrl() {
		return url;
	}
}
