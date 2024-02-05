package com.unicamp.mc322.lab02;

public class Song {
	
	private String name;
	private String musicalGender;
	private String artist;
	private Duration musicLenght;
	
	public Song(String name, String musicalGender, String artist) {
		this.name = name;
		this.musicalGender = musicalGender;
		this.artist = artist;
		musicLenght = null;
	}
	
	public Song(String name, String musicalGender, String artist, String lenght) {
		this.name = name;
		this.musicalGender = musicalGender;
		this.artist = artist;
		musicLenght = new Duration(lenght);
	}
	
	public String getName() {
		return name;
	}
	
	public String getMusicalGender() {
		return musicalGender;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public Integer getMusicLenght() {
		if(musicLenght != null)
			return 60*musicLenght.getMinutes() + musicLenght.getSeconds();
		else
			return null;
	}
	
	public String printMusicLenght() {
		if(musicLenght != null)
			return musicLenght.toString();
		else
			return null;
	}

	public String toString() {
		return "- " + name + " - " + artist + ";";
	}
}
