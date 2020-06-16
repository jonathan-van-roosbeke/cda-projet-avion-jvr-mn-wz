package com.avion.constante;

public enum NoAnimatedPictures {

	BACKGROUND("/resource/images/background/background_space.png"),
	METEOR_SIMPLE("/resource/images/meteor/meteor_simple.png"), METEOR_FEUX("/resource/images/meteor/meteor_feux.png"),
	METEOR_GLACE("/resource/images/meteor/meteor_glace.png"),
	METEOR_ICEBERG("/resource/images/meteor/meteor_iceberg.png"),
	METEOR_ZIGZAG("/resource/images/meteor/meteor_zigzag.png");

	private String url;

	private NoAnimatedPictures(String pUrl) {
		this.url = pUrl;
	}

	public String getUrl() {
		return url;
	}
}
