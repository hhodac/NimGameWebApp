/*
	NimAIPlayer.java
	
	This class is provided as a skeleton code for the tasks of 
	Sections 2.4, 2.5 and 2.6 in Project C. Add code (do NOT delete any) to it
	to finish the tasks. 
*/

import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.Random;
import java.util.Scanner;

public class NimAIPlayer extends NimPlayer implements Testable {
	// you may further extend a class or implement an interface
	// to accomplish the tasks.	
	private boolean goFirst = true;

	// Constructors
	public NimAIPlayer() {
		super("computer", "Player", "AI");
		setType("C");    // C: Computer
	}

	public NimAIPlayer(String username, String familyname, String givenname) {
		super(username, familyname, givenname);
		setType("C");    // C: Computer
	}

	public NimAIPlayer(String username, String familyname, String givenname,
						  int gamesPlayed, int gamesWon) {
		super(username, familyname, givenname, gamesPlayed, gamesWon);
		setType("C");    // C: Computer
	}

	public NimAIPlayer(String username) {
		super(username);
		setType("C");    // C: Computer
	}

	@Override
	public int removeStone(int currentStone, int upperbound, Scanner keyboard) {
		int k = 0;
		int louise = 1;
		while ((currentStone > upperbound) && (louise < currentStone)) {
			k++;
			louise = k * (upperbound + 1) + 1;
		}
		boolean randomPlay;
		if ((k * (upperbound + 1) + 1) == currentStone) randomPlay = true;
		else randomPlay = false;

		System.out.println(getGivenname() + "'s turn - remove how many?");
		flipTurn();
		if (randomPlay) {
			return removeRandom(currentStone, upperbound);
		} else return removeSmart(currentStone, upperbound, k);
	}

	@Override
	public int removeStone2(int currentStone, int upperbound)
			throws InvalidMoveException, NumberFormatException {
		System.out.println(getGivenname() + "'s turn - remove how many?");

		return 0;
	}

	private int removeRandom(int currentStone, int upperbound) {
		int removeStone;
		Random rand = new Random();
		if (currentStone < upperbound) {
			removeStone = rand.nextInt(currentStone) + 1;
		}
		else {
			removeStone = rand.nextInt(upperbound) + 1;
		}
		return removeStone;
	}

	private int removeSmart(int currentStone, int upperbound, int k) {
		int removeStone;
		if (currentStone <= upperbound) {
			if (currentStone == 1) removeStone = currentStone;
			else removeStone = currentStone - 1;
		} else {
			removeStone = currentStone - ((k - 1) * (upperbound + 1) + 1);
		}
		return removeStone;
	}

	@Override
	public void removeStoneAdvanced(boolean[] stoneAvailable, Scanner keyboard) {

	}

	// toString
	@Override
	public String toString() {
		return getUsername() + "," + getFamilyname() + "," + getGivenname() + "," +
				getNumberOfGamesPlayed() + "," + getNumberOfGamesWon() + ",C";
	}
	
	public String advancedMove(boolean[] available, String lastMove) {
		// the implementation of the victory
		// guaranteed strategy designed by you
		String move = "";
		
		return move;
	}

}
