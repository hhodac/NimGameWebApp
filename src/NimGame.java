/* Programming and Software Development - COMP90041 - Project C
 *
 * Student name:    Hai Ho Dac
 * Student ID:      1050369
 *
 * File name:       NimGame.java
 * Description:     This file contains attributes & methods to control game.
 *
 * Written:         May 6th, 2019
 * Last updated:    May 28th, 2019
 */

import java.util.Scanner;

public class NimGame {
    private NimHumanPlayer player1;
    private NimHumanPlayer player2;
    private int initStone;
    private int upperbound;
    private int currentStone;

    public NimGame() {
        player1 = new NimHumanPlayer();
        player2 = new NimHumanPlayer();
        initStone = 0;
        upperbound = 0;
        currentStone = 0;
    }

    public NimGame(NimHumanPlayer player1, NimHumanPlayer player2, int initStone, int upperbound) {
        this.player1 = player1;
        this.player2 = player2;
        this.initStone = initStone;
        this.upperbound = upperbound;
        this.currentStone = initStone;
    }

    public NimHumanPlayer getPlayer1() {
        return player1;
    }

    public NimHumanPlayer getPlayer2() {
        return player2;
    }

    public int getInitStone() {
        return initStone;
    }

    public int getUpperbound() {
        return upperbound;
    }

    public int getCurrentStone() {
        return currentStone;
    }

    public void setCurrentStone(int stone) {
        this.currentStone = stone;
    }

    // startGame: controls game
    public void startGame() {
        player1.setTurn("ON");
        player2.setTurn("OFF");
    }
    /*
    public void startGame() {
        player1.setTurn("ON");
        player2.setTurn("OFF");

        int currentStone = initStone;

        while (currentStone > 0) {
            if (player1.getTurn().equals("ON")) {
                while (player1.getTurn().equals("ON")) {
                    try{
                        printStones(currentStone);
                        currentStone = currentStone -
                                player1.removeStone2(currentStone, upperbound);
                    }
                    catch (InvalidMoveException e) {
                        System.out.println();
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\nNumber of stone remove is not integer type.");
                        System.out.println();
                    }
                }
            } else player1.flipTurn();
            if (player2.getTurn().equals("ON")) {
                while (player2.getTurn().equals("ON")) {
                    try {
                        printStones(currentStone);
                        currentStone = currentStone -
                                player2.removeStone2(currentStone, upperbound);
                    }
                    catch (InvalidMoveException e) {
                        System.out.println();
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\nNumber of stone remove is not integer type.");
                        System.out.println();
                    }
                }
            } else player2.flipTurn();
            System.out.println();
        }

        System.out.println("Game Over");
        if (player1.getTurn().equalsIgnoreCase("ON")) {
            System.out.println(player1.getGivenname() + " "
                    + player1.getFamilyname() + " wins!");
            player1.setNumberOfGamesWon(player1.getNumberOfGamesWon() + 1);
        } else {
            System.out.println(player2.getGivenname() + " "
                    + player2.getFamilyname() + " wins!");
            player2.setNumberOfGamesWon(player2.getNumberOfGamesWon() + 1);
        }
    }*/

    // printStone: prints the number of stones as '*' asterisk symbol
    private void printStones(int numberOfStones) {
        System.out.printf("%d stones left:", numberOfStones);
        for (int i = 1; i <= numberOfStones; i++){
            System.out.print(" *");
        }
        System.out.print("\n");
    }

    // startAdvancedGame: controls advanced game
    public void startAdvancedGame(int initStone, NimPlayer player1, NimPlayer player2,
                                  Scanner keyboard) {
        boolean[] stoneAvailable = new boolean[initStone];
        for (int i = 0; i < stoneAvailable.length; i++) {
            stoneAvailable[i] = true;
        }

        System.out.println();
        System.out.printf("Initial stone count: %d\n", initStone);
        System.out.printf("Stones display:");
        for (int i = 0; i < stoneAvailable.length; i++){
            if (stoneAvailable[i]) System.out.printf(" <%d,*>",i+1);
            else System.out.printf(" <%d,x>",i+1);
        }
        System.out.print("\n");
        System.out.printf("Player 1: %s %s\n", player1.getGivenname(), player1.getFamilyname());
        System.out.printf("Player 2: %s %s\n", player2.getGivenname(), player2.getFamilyname());

        player1.setNumberOfGamesPlayed(player1.getNumberOfGamesPlayed()+1);
        player2.setNumberOfGamesPlayed(player2.getNumberOfGamesPlayed()+1);

        player1.setTurn("ON");
        player2.setTurn("OFF");

        System.out.println();
        int currentStone = initStone;

        while (currentStone > 0) {
            if (player1.getTurn().equals("ON")) {
                while (player1.getTurn().equals("ON")) {
                    printAdvancedStones(stoneAvailable);
                    player1.removeStoneAdvanced(stoneAvailable, keyboard);
                }
            } else player1.flipTurn();
            if (player2.getTurn().equals("ON")) {
                while (player2.getTurn().equals("ON")) {
                    printAdvancedStones(stoneAvailable);
                    player2.removeStoneAdvanced(stoneAvailable, keyboard);
                }
            } else player2.flipTurn();
            currentStone = countAdvancedStone(stoneAvailable);
            System.out.println();
        }
        // End game. Check who wins.
        System.out.println("Game Over");
        if (player1.getTurn().equalsIgnoreCase("ON")) {
            System.out.println(player2.getGivenname() + " "
                    + player2.getFamilyname() + " wins!");
            player2.setNumberOfGamesWon(player2.getNumberOfGamesWon() + 1);
        } else {
            System.out.println(player1.getGivenname() + " "
                    + player1.getFamilyname() + " wins!");
            player1.setNumberOfGamesWon(player1.getNumberOfGamesWon() + 1);
        }
    }

    // countAdvancedStone: count remaining stones in advanced game
    private int countAdvancedStone(boolean[] stone) {
        int count = 0;
        for (int i = 0; i < stone.length; i++) {
            if (stone[i]) count++;
        }
        return count;
    }

    // printAdvancedStone: prints the number of stones in advanced game
    private void printAdvancedStones(boolean[] stoneAvailable) {
        int numberOfStones = countAdvancedStone(stoneAvailable);
        System.out.printf("%d stones left:", numberOfStones);
        for (int i = 0; i < stoneAvailable.length; i++){
            if (stoneAvailable[i]) System.out.printf(" <%d,*>",i+1);
            else System.out.printf(" <%d,x>",i+1);
        }
        System.out.print("\n");
    }
}
