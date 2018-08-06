package com.venkat;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<T> {
	private String name;
	int won = 0;
	int lost = 0;
	int tied = 0;
	int played = 0;
	
	private ArrayList<T> members = new ArrayList<T>();
	
	public Team(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean addPlayer(T player) {
		if(members.contains(player)) {
			System.out.println(player.getName() + " is already on the Team " + this.name);
			return false;
		} else {
			members.add(player);
			System.out.println(player.getName() + " picked for team " + this.name);
			return true;
		}
		
	}
	
	public int numPlayers() {
		return this.members.size();
	}
	
	
	public void matchResult (Team<T> opponent, int ourScore, int theirScore) {
		String message;
		if(ourScore > theirScore) {
			won++;
			message = " beat ";
		} else if(ourScore == theirScore) {
			tied++;
			message = " drew with ";
		} else {
			lost++;
			message = " lost to ";
		}
		played++;
		if(opponent != null) {
			System.out.println(this.getName() + message + opponent.getName());
			opponent.matchResult(null, ourScore, theirScore);
		}

	}
	
	
	
	public int ranking() {
		return (won * 2) + tied;
	}

	public int compareTo(Team<T> team) {
		if(this.ranking() > team.ranking())
			return -1;
		else if(this.ranking() < team.ranking())
			return 1;
		else
			return 0;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
