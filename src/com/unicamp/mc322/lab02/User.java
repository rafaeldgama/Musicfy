package com.unicamp.mc322.lab02;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private String CPF;
	private Date birthDate;
	private Character gender;
	private Boolean subscriber;
	private Integer playListsAmount;
	private List <PlayList> userPlayLists = new ArrayList<>();
	
	public User(String name, String cpf) {
		this.name = name;
		this.CPF = cpf;
		subscriber = false;
		playListsAmount = 0;
	}
	
	public User(String name, String cpf, String birthDate) {
		this.name = name;
		this.CPF = cpf;
		this.birthDate = new Date(birthDate);
		subscriber = false;
		playListsAmount = 0;
	}
	
	public User(String name, String cpf, String birthDate, char gender) {
		this.name = name;
		this.CPF = cpf;
		this.birthDate = new Date(birthDate);
		this.gender = gender;
		subscriber = false;
		playListsAmount = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return CPF;
	}
	
	public String getBirthDate() {
		return birthDate.toString();
	}
	
	public void setBirthDate(String date) {
		birthDate = new Date(date);
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public boolean getSubscriber() {
		return subscriber;
	}
	
	public void subscribe() {
		subscriber = true;
	}
	
	public void cancelSubscription() {
		subscriber = false;
	}
	
	public void showInformation() {
		System.out.println("Nome: " + name);
		System.out.println("CPF: " + CPF);
		if(birthDate == null)
			System.out.println("Data de nascimento: Não informada");
		else
			System.out.println("Data de nascimento: " + birthDate.toString());
		if(gender == null)
			System.out.println("Gênero: Não informado");
		else
			System.out.println("Gênero: " + gender);
		if(subscriber == true)
			System.out.println("Assinante: Sim");
		else
			System.out.println("Assinante: Não");
		System.out.println();
	}
	
	public void addPlayList(PlayList playList) {
		if(subscriber == true) {
			if(playListsAmount < 10) {
				if(userPlayLists.isEmpty() == true)
					userPlayLists.add(playList);
				else {
					PlayList aux = userPlayLists.stream().filter(x -> playList.getName().compareTo(x.getName()) < 0).findFirst().orElse(null);
					if(aux == null)
						userPlayLists.add(playList);
					else {
						Integer index = userPlayLists.indexOf(aux);
						userPlayLists.add(index, playList);
					}
				}
				playListsAmount++;
			}
			else
				System.out.println("Maximum number of Playlists has been reached already.");
		}
		else {
			if(playListsAmount < 3) {
				if(userPlayLists.isEmpty() == true)
					userPlayLists.add(playList);
				else {
					PlayList aux = userPlayLists.stream().filter(x -> playList.getName().compareTo(x.getName()) < 0).findFirst().orElse(null);
					if(aux == null)
						userPlayLists.add(playList);
					else {
						Integer index = userPlayLists.indexOf(aux);
						userPlayLists.add(index, playList);
					}
				}
				playListsAmount++;
			}
			else
				System.out.println("Maximum number of Playlists has been reached already.");
		}
	}
	
	public void removePlayList(PlayList playList) {
		userPlayLists.remove(playList);
		playListsAmount--;
	}
	
	public void removePlayList(String playListName) {
		userPlayLists.removeIf(x -> x.getName().equals(playListName));
		playListsAmount--;
	}
	
	public void transferPlayList(PlayList playList, User anotherUser) {
		anotherUser.addPlayList(playList);
	}
	
	public void showPlayLists() {
		System.out.print("User: ");
		System.out.println(name);
		System.out.print("Number of Playlists: ");
		System.out.println(playListsAmount);
		for(int i = 0; i < playListsAmount; ++i) {
			System.out.println("Playlist " + (i+1) + ": " + userPlayLists.get(i).getName());
			System.out.println("	Number of Songs: " + userPlayLists.get(i).getmusicQuantity());
			userPlayLists.get(i).showPlayList();
		}
	}
	
}
