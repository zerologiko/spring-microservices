package com.in28minutes.microservices.limitserver.bean;

public class LimitConfiguration {

	private int minmum;
	private int maximum;

	protected LimitConfiguration() {

	}

	public LimitConfiguration(int minmum, int maximum) {
		super();
		this.minmum = minmum;
		this.maximum = maximum;
	}

	public int getMinmum() {
		return minmum;
	}
	public void setMinmum(int minmum) {
		this.minmum = minmum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}


}
