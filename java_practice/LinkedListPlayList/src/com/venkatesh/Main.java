package com.venkatesh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Album> albumList = new ArrayList<Album>();
		Album album1 = new Album("Romantic Songs");
		album1.addSong(new Song("yad lagla",4.57d));
		album1.addSong(new Song("Tujhyat jiv rangla", 6.45d));
		albumList.add(album1);
		
		
		Album album2 = new Album("Old Songs");
		album2.addSong(new Song("ohh rahi chal",3.43d));
		album2.addSong(new Song("yuhi chala chal rahi",2.11d));
		albumList.add(album2);
		
		Album album3 = new Album("DJ Songs");
		album3.addSong(new Song("Zingat",3.43d));
		album3.addSong(new Song("Shitti",7.47d));
		album3.addSong(new Song("DJ lav",6.12d));
		albumList.add(album3);
		
		LinkedList<Song> playList = new LinkedList<>();
		
		playList.add(albumList.get(0).getSongList().get(1));
		playList.add(albumList.get(2).getSongList().get(0));
		playList.add(albumList.get(1).getSongList().get(0));
		playList.add(albumList.get(2).getSongList().get(2));
		playList.add(albumList.get(2).getSongList().get(1));
		
		
		ListIterator<Song> songIterator = playList.listIterator();
		if(playList.size()>0) {
			if(songIterator.hasNext()) {
				System.out.println("Now playing "+songIterator.next().getTitle());
			}
		}
	
		boolean choice = true;
		boolean goingForward = true;
		
		while(choice) {
			
			printMenu();
			
			int ans = sc.nextInt();
			switch(ans) {
			case 1:
				System.out.println("Quiting..");
				choice  = false;
				break;
			
			case 2:
				if(!goingForward) {
					if(songIterator.hasNext()) {
						songIterator.next();
					}
					goingForward = true;
				} 
				if(songIterator.hasNext()) {
					System.out.println("Now playing "+songIterator.next().getTitle());
				} else {
					System.out.println("We are at the end of the playlist");
					goingForward = false;
				}
				
				break;
				
			case 3:
				if(goingForward) {
					if(songIterator.hasPrevious()) {
						songIterator.previous();
					}
					goingForward = false;
				} 
				if(songIterator.hasPrevious()) {
					System.out.println("Now playing "+songIterator.previous().getTitle());
				} else {
					System.out.println("We are at the start of the playlist");
					goingForward = true;
				}
				
				break;
				
			case 4:
				if(goingForward) {
					if(songIterator.hasPrevious()) {
						System.out.println("Now replaying "+songIterator.previous().getTitle());
						goingForward = false;
					} else {
						System.out.println("We are at the start of the playlist");
						
					}
					System.out.println();
				} else if(!goingForward) {
					if(songIterator.hasNext()) {
						System.out.println("Now replaying "+songIterator.next().getTitle());
						goingForward = true;
					} else {
						System.out.println("We are at the start of the playlist");
					}
				}
				break;
				
			case 5:
				printList(playList);
				break;
			
			case 6:
				if(playList.size()>0) {
					songIterator.remove();
					if(songIterator.hasNext() && goingForward) {
						songIterator.next();
					} else if(songIterator.hasPrevious() && !goingForward) {
						songIterator.previous();
					}
				} else {
					System.out.println("Play List is empty");
				}
				break;
				
			case 7:
				printMenu();
				break;
			
			}
		}
		
	}
	
	private static void printMenu() {
		System.out.println("1.Quit\n"+
				"2.Skip forward to the next song\n"+
				"3.Skip backward to the previous song\n"+
				"4.Replay the current song\n"+
				"5.List the songs in the playList\n"+
				"6.Remove current song in the playlist");
	}
	
	private static void printList(LinkedList<Song> tmpPlayList) {
		ListIterator<Song> i = tmpPlayList.listIterator();
		System.out.println("=====================================");
		while(i.hasNext())
			System.out.println(i.next().getTitle());
		System.out.println("=====================================");
		
		
	}

}
