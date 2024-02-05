package com.unicamp.mc322.lab02;


public class Date {
	
	private Integer day;
	private Integer month;
	private Integer year;
	
	public Date(String date) {
		String[] aux = date.split("/");
		day = Integer.parseInt(aux[0]);
		month = Integer.parseInt(aux[1]);
		year = Integer.parseInt(aux[2]);
	}
	
	public Integer getDay() {
		return day;
	}
	
	public Integer getMonth() {
		return month;
	}

	public Integer getYear() {
		return year;
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}

}
