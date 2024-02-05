package com.unicamp.mc322.lab02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayList {

	private String name;
	private String playListGender;
	private Integer musicQuantity;
	private List<Song> playList = new ArrayList<>();
	private Song currentMusic;
	
	public PlayList(String name, String playListGender) {
		this.name = name;
		this.playListGender = playListGender;
		musicQuantity = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPlayListGender() {
		return playListGender;
	}
	
	public void setPlayListGender(String playListGender) {
		this.playListGender = playListGender;
	}
	
	public Integer getmusicQuantity() {
		return musicQuantity;
	}
	
	public Song getCurrentMusic() {
		return currentMusic;
	}
	
	public void addSong(Song music) {
		if(playList.isEmpty() == true)
			playList.add(music);
		else {
			Song result = playList.stream().filter(x -> music.getName().compareTo(x.getName()) < 0).findFirst().orElse(null);
			if(result == null)
				playList.add(music);
			else {
				Integer index = playList.indexOf(result);
				playList.add(index, music);
			}
		}
		musicQuantity++;
	}
	
	public void addSong(Song music, User user) {
		if(user.getSubscriber() == true) {
			if(musicQuantity < 100) {
				if(playList.isEmpty() == true)
					playList.add(music);
				else {
					Song result = playList.stream().filter(x -> music.getName().compareTo(x.getName()) < 0).findFirst().orElse(null);
					if(result == null)
						playList.add(music);
					else {
						Integer index = playList.indexOf(result);
						playList.add(index, music);
					}
				}
				musicQuantity++;
			}
			else
				System.out.println("Playlist is already full.");
		}
		else {
			if(musicQuantity < 10) {
				if(playList.isEmpty() == true)
					playList.add(music);
				else {
					Song result = playList.stream().filter(x -> music.getName().compareTo(x.getName()) < 0).findFirst().orElse(null);
					if(result == null)
						playList.add(music);
					else {
						Integer index = playList.indexOf(result);
						playList.add(index, music);
					}
				}
				musicQuantity++;
			}
			else
				System.out.println("Playlist is already full.");
		}
	}
	
	public void removeSong(Song music) {
		playList.remove(music);
		musicQuantity--;
	}
	
	public void removeSong(String musicName) {
		Song music = playList.stream().filter(x -> x.getName().equals(musicName)).findAny().orElse(null);
		if (music == null)
			System.out.println("This music does not exist on the playlist.");
		else {
			playList.remove(music);
			musicQuantity--;
		}
	}
	
	public Song biggerLenghtMusic() {
		if(playList.isEmpty() == false) {	
			int biggerLenght = playList.get(0).getMusicLenght();
			int musicIndex = 0;
			for(Song music : playList)
				if(music.getMusicLenght() > biggerLenght) {
					musicIndex = playList.indexOf(music);
					biggerLenght = music.getMusicLenght();
				}
			return playList.get(musicIndex);
		}
		else {
			System.out.println("Playlist is empty.");
			return null;
		}
	}
	
	public Song lowestLenghtMusic() {
		if(playList.isEmpty() == false) {
			int lowestLenght = playList.get(0).getMusicLenght();
			int musicIndex = 0;
			for(Song music : playList)
				if(music.getMusicLenght() < lowestLenght) {
					musicIndex = playList.indexOf(music);
					lowestLenght = music.getMusicLenght();
				}
			return playList.get(musicIndex);
		}
		else {
			System.out.println("Playlist is empty.");
			return null;
		}
	}
	
	public String playListAverageMusicLenght() {
		Integer acc = 0;
		for(Song music : playList)
			if (music.getMusicLenght() != null)
				acc += music.getMusicLenght();
		Integer average = acc/playList.size();
		Integer minutes = average/60;
		Integer seconds = average - minutes*60;
		return "Average music lenght: " + minutes + ":" + seconds;
	}
	
	public String playListTotalLenght() {
		Integer acc = 0;
		for(Song music : playList)
			if (music.getMusicLenght() != null)
				acc += music.getMusicLenght();
		Integer minutes = acc/60;
		Integer seconds = acc - minutes*60;
		return "Total music lenght: " + minutes + ":" + seconds;
	}
	
	public String artistWithMostSongs() {
		List<Song> aux = playList.stream().filter(x -> x.getArtist().equals(playList.get(0).getArtist())).collect(Collectors.toList());
		Integer numberOfSongs = aux.size();
		String artist = playList.get(0).getArtist();
		for(Song music : playList) {
			aux = playList.stream().filter(x -> x.getArtist().equals(music.getArtist())).collect(Collectors.toList());
			if(aux.size() > numberOfSongs) {
				artist = music.getArtist();
				numberOfSongs = aux.size();
			}
		}
		return "Artist who has more songs on the playlist: " + artist;
	}
	
	public Song play(boolean shuffle) {
		if(shuffle == false) {
			if(currentMusic == null) {
				currentMusic = playList.get(0);
				return currentMusic;
			}
			else {
				Integer NextSongIndex = playList.indexOf(currentMusic) + 1;
				currentMusic = playList.get(NextSongIndex);
				return currentMusic;
			}
		}
		else {
			Integer nextSongIndex = (int) (Math.random() * musicQuantity);
			while(currentMusic != null && nextSongIndex == playList.indexOf(currentMusic))
				nextSongIndex = (int) (Math.random() * musicQuantity);
			currentMusic = playList.get(nextSongIndex);
			return currentMusic;
		}
	}
	
	public void showPlayList() {
		System.out.println("	" + "Songs: ");
		for(Song music : playList)
			System.out.println("	" + music.toString());
	}
	
	public void songIndex(Song song) {
		System.out.println(playList.indexOf(song));
	}
	
	
}
