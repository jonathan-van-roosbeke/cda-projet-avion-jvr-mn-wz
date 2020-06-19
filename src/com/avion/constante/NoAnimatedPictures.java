package com.avion.constante;

public enum NoAnimatedPictures {

	BACKGROUND("resources/images/background/background_space.jpg"),
	METEOR_SIMPLE("resources/images/meteor/meteor_simple.png"), METEOR_FEUX("resources/images/meteor/meteor_feux.png"),
	METEOR_GLACE("resources/images/meteor/meteor_glace.png"),
	METEOR_ICEBERG("resources/images/meteor/meteor_iceberg.png"),
	METEOR_ZIGZAG("resources/images/meteor/meteor_zigzag.png"), FLECHE_OFF("resources/images/fleche/fleche_off.jpg"),
	FLECHE_ON("resources/images/fleche/fleche_on.jpg"), VIE_01_OFF("resources/images/vie/01_vie_off.png"),
	VIE_01_ON("resources/images/vie/01_vie_on.png"), VIE_02_OFF("resources/images/vie/02_vie_off.png"),
	VIE_02_ON("resources/images/vie/02_vie_on.png"), VIE_03_OFF("resources/images/vie/03_vie_off.png"),
	VIE_03_ON("resources/images/vie/03_vie_on.png"), VIE_04_OFF("resources/images/vie/04_vie_off.png"),
	VIE_04_ON("resources/images/vie/04_vie_on.png"), VIE_05_OFF("resources/images/vie/05_vie_off.png"),
	VIE_05_ON("resources/images/vie/05_vie_on.png");

	private String url;

	private NoAnimatedPictures(String pUrl) {
		this.url = pUrl;
	}

	public String getUrl() {
		return url;
	}
}
