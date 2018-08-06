package com.venkat;

public class Main {

	public static void main(String[] args) {
		FootballPlayer venky = new FootballPlayer("Venkatesh");
		FootballPlayer kitty = new FootballPlayer("Supirya");
		FootballPlayer parth = new FootballPlayer("Parth");
		SoccerPlayer sajjan = new SoccerPlayer("Sajjan");
		SoccerPlayer kausy = new SoccerPlayer("Kaussy");
		
		
		FootballPlayer leena = new FootballPlayer("Leena");
		
		Team<FootballPlayer> palusPanthers = new Team<FootballPlayer>("Palus Panthers");
		palusPanthers.addPlayer(kitty);
		palusPanthers.addPlayer(parth);
		palusPanthers.addPlayer(venky);
		palusPanthers.addPlayer(venky);
		//System.out.println(palusPanthers.numPlayers());
		
		Team<SoccerPlayer> palusKoilas = new Team<SoccerPlayer>("Palus Koilas");
		palusKoilas.addPlayer(sajjan);
		palusKoilas.addPlayer(kausy);
		//System.out.println(palusKoilas.numPlayers());
		
		Team<FootballPlayer> sangliTuskers = new Team<FootballPlayer>("Sangli Tuskers");
		sangliTuskers.addPlayer(leena);
		
		palusPanthers.matchResult(sangliTuskers, 6, 5);
		
		System.out.println("Rankings:");
		System.out.println(palusPanthers.getName() + ": " + palusPanthers.ranking());
		System.out.println(palusKoilas.getName() + ": " + palusKoilas.ranking());
		System.out.println(sangliTuskers.getName() + ": " + sangliTuskers.ranking());
		
		
		
		
	}

}
