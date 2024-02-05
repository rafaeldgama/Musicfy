package com.unicamp.mc322.lab02;

public class Musicfy {

	public static void main(String[] args) {

		User user1 = new User("Marcos Paulo", "777.777.777-77");
	    User user2 = new User("Cookiezi", "111.111.11-11");
		Song song1 = new Song("Seven Nation Army", "Rock", "The White Stripes", "3:42");
		Song song2 = new Song("Crazy Train", "Rock", "Ozzy Osbourne", "3:20");
		Song song3 = new Song("Crawling", "Rock", "Linkin Park", "2:50");
		Song song4 = new Song("From The Inside", "Rock", "Linkin Park", "3:00");
		Song song5 = new Song("Anima", "Hardcore", "Xi", "3:10");
		Song song6 = new Song("Freedom Dive", "Hardcore", "Xi", "3:15");
		Song song7 = new Song("Teo", "Hardcore", "Omoi", "2:40");
		Song song8 = new Song("Sleepwalking", "Metalcore", "Bring Me The Horizon", "2:52");
		
		PlayList rockPlaylist = new PlayList("Awesome Rock Songs", "Rock");
		rockPlaylist.addSong(song1);
        rockPlaylist.addSong(song2);
        
        PlayList osuPlaylist = new PlayList("Osu Memories", "Hardcore");
        osuPlaylist.addSong(song5);
        osuPlaylist.addSong(song6);
        osuPlaylist.addSong(song7);
        osuPlaylist.addSong(song4);
        osuPlaylist.addSong(song1);
        osuPlaylist.addSong(song2);
        
        PlayList metalCorePlayList = new PlayList("Best of Metalcore", "Metalcore");
        metalCorePlayList.addSong(song8);
        metalCorePlayList.addSong(song3);
        
        user1.addPlayList(rockPlaylist);
        user1.addPlayList(metalCorePlayList);
        user2.addPlayList(osuPlaylist);
        
        user1.showPlayLists();
        System.out.println("");
        user2.showPlayLists();
        user2.showInformation();

        Song asong1 = osuPlaylist.play(false);
        Song asong2 = osuPlaylist.play(false);
        Song asong3 = osuPlaylist.play(true);
        
        System.out.println(asong1.toString());
        System.out.println(asong2.toString());
        System.out.println(asong3.toString());
        
	}

}
