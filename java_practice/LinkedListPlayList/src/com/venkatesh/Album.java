package com.venkatesh;

import java.util.ArrayList;

public class Album {
	private ArrayList<Song> songList;
	private String albumName;
	
	public Album(String albumName) {
		this.songList = new ArrayList<Song>();
		this.albumName = albumName;
	}
	
	public boolean addSong(Song song) {
		this.songList.add(song);
		return true;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
}
