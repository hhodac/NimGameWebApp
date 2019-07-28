/* Programming and Software Development - COMP90041 - Project C
 *
 * Student name:    Hai Ho Dac
 * Student ID:      1050369
 *
 * File name:       NimHumanPlayer.java
 * Description:     This file contains attributes & methods of the player.
 *
 * Written:         May 11th, 2019
 * Last updated:    May 28th, 2019
 */

import java.util.Scanner;

public class NimHumanPlayer extends NimPlayer {
    // Constructors
    public NimHumanPlayer() {
        super();
        setType("H");    // H: Human
    }

    public NimHumanPlayer(String username, String familyname, String givenname) {
        super(username, familyname, givenname);
        setType("H");    // H: Human
    }

    public NimHumanPlayer(String username, String familyname, String givenname,
                          int gamesPlayed, int gamesWon) {
        super(username, familyname, givenname, gamesPlayed, gamesWon);
        setType("H");    // H: Human
    }

    public NimHumanPlayer(String username) {
        super(username);
        setType("H");    // H: Human
    }

    @Override
    public int removeStone(int currentStone, int upperbound, Scanner keyboard)
            throws InvalidMoveException, NumberFormatException {
        System.out.println(getGivenname() + "'s turn - remove how many?");
        String removeStoneStr = keyboard.nextLine();
        if (removeStoneStr.isEmpty()) {
            if (currentStone < upperbound) throw new InvalidMoveException(currentStone);
            else throw new InvalidMoveException(upperbound);
        }
        int removeStone = Integer.parseInt(removeStoneStr);
        if (removeStone <= 0) {
            if (currentStone < upperbound) throw new InvalidMoveException(currentStone);
            else throw new InvalidMoveException(upperbound);
        } else if (removeStone > upperbound) throw new InvalidMoveException(upperbound);
        else if (removeStone > currentStone) throw new InvalidMoveException(currentStone);
        flipTurn();
        return removeStone;
    }

    @Override
    public int removeStone2(int currentStone, int upperbound)
            throws InvalidMoveException, NumberFormatException {
        System.out.println(getGivenname() + "'s turn - remove how many?");

        return 0;
    }

    @Override
    public void removeStoneAdvanced(boolean[] stoneAvailable, Scanner keyboard) {
        int count = 0;
        for (int i = 0; i < stoneAvailable.length; i++) {
            if (stoneAvailable[i]) count++;
        }
        System.out.println(getGivenname() + "'s turn - which to remove?");
        String removeStoneStr = keyboard.nextLine();
        try {
            String[] stone = removeStoneStr.split(" ");
            int stone1 = Integer.parseInt(stone[0]);
            int stone2 = Integer.parseInt(stone[1]);

            if (stone2 == 2) {
                if (stone1 - 1 >= stoneAvailable.length) {
                    throw new Exception("Invalid move.");
                }
                if ((!stoneAvailable[stone1 - 1]) || (!stoneAvailable[stone1])) {
                    throw new Exception("Invalid move.");
                }
                stoneAvailable[stone1 - 1] = false;
                stoneAvailable[stone1] = false;
            } else {
                if (stone1 - 1 > stoneAvailable.length) {
                    throw new Exception("Invalid move.");
                }
                if (!stoneAvailable[stone1 - 1]) {
                    throw new Exception("Invalid move.");
                }
                stoneAvailable[stone1 - 1] = false;
            }
            flipTurn();
        }
        catch (Exception e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }
    }

    // toString
    @Override
    public String toString() {
        return getUsername() + "," + getFamilyname() + "," + getGivenname() + "," +
                getNumberOfGamesPlayed() + "," + getNumberOfGamesWon() + ",H";
    }
}
