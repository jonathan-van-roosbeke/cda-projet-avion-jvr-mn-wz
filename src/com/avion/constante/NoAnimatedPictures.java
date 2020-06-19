package com.avion.constante;

public enum NoAnimatedPictures {

	BACKGROUND("/images/background/background_space.jpg"), METEOR_SIMPLE("/images/meteor/meteor_simple.png"),
	METEOR_FEUX("/images/meteor/meteor_feux.png"), METEOR_GLACE("/images/meteor/meteor_glace.png"),
	METEOR_ICEBERG("/images/meteor/meteor_iceberg.png"), METEOR_ZIGZAG("/images/meteor/meteor_zigzag.png"),
	FLECHE_OFF("/images/fleche/fleche_off.jpg"), FLECHE_ON("/images/fleche/fleche_on.jpg"),
	VIE_01_OFF("/images/vie/01_vie_off.png"), VIE_01_ON("/images/vie/01_vie_on.png"),
	VIE_02_OFF("/images/vie/02_vie_off.png"), VIE_02_ON("/images/vie/02_vie_on.png"),
	VIE_03_OFF("/images/vie/03_vie_off.png"), VIE_03_ON("/images/vie/03_vie_on.png"),
	VIE_04_OFF("/images/vie/04_vie_off.png"), VIE_04_ON("/images/vie/04_vie_on.png"),
	VIE_05_OFF("/images/vie/05_vie_off.png"), VIE_05_ON("/images/vie/05_vie_on.png");

	private String url;

	private NoAnimatedPictures(String pUrl) {
		this.url = pUrl;
	}

	public String getUrl() {
		return url;
	}
}
