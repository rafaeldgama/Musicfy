package com.unicamp.mc322.lab02;

public class Duration {
	
	private Integer minutes;
	private Integer seconds;
	
	public Duration(String lenght) {
		String[] aux = lenght.split(":");
		minutes = Integer.parseInt(aux[0]);
		seconds = Integer.parseInt(aux[1]);
	}
	
	public Integer getMinutes() {
		return minutes;
	}
	
	public Integer getSeconds() {
		return seconds;
	}
	
	public String toString() {
		return minutes + ":" + seconds;
	}

}
