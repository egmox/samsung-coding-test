package demo;

import java.util.Random;

/*
 * This class generates random penalty shootout scores of 
 * two teams and if scores of both team tally, game 
 * enters to sudden death rounds. 
 * 
 * */

public class PenaltyShootout extends Thread {

	// constants and variables
	static final int teamA = 0;
	static final int teamB = 1;
	static int teamsScore[] = { 0, 0 };
	static boolean suddenDeathRound = false;

	// executor point of the code
	public static void main(String args[]) {
		for (int i = 0; i <= 4; i++) {
			nextRound();
			System.out.println("team A: " + teamsScore[teamA] + ". team B: " + teamsScore[teamB]);
		}
		String winner = findWinner();
		while (winner == null) {
			winner = findWinner();
		}
		System.out.println(winner);
	}

	// This method creates random score for each round waiting 1 second for each
	static void nextRound() {
		for (int i = 0; i <= 1; i++) {
			try {
				sleep(1000);
			} catch (InterruptedException exception) {
				System.out.println("could not sleep for 1 second: " + exception);
			}
			if (new Random().nextBoolean()) {
				teamsScore[i] = teamsScore[i] + 1;
			}
		}
	}

	// This method checks scores of both teams and finds winner
	static String findWinner() {
		nextRound();
		if (teamsScore[teamA] == teamsScore[teamB]) 
			return null;
		if (teamsScore[teamA] > teamsScore[teamB]) 
			return "team A is winner";
		if (teamsScore[teamA] < teamsScore[teamB]) 
			return "team B is winner";
		return null;
	}
}
