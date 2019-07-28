/* Programming and Software Development - COMP90041 - Project C
 *
 * Student name:    Hai Ho Dac
 * Student ID:      1050369
 *
 * File name:       NimPlayer.java
 * Description:     This file contains attributes & methods of the player.
 *
 * Written:         May 6th, 2019
 * Last updated:    May 28th, 2019
 */

import java.util.Scanner;

public abstract class NimPlayer {

    // Declare private variables of this class
    private String username;
    private String given_name;
    private String family_name;
    private int numberOfGamesPlayed;
    private int numberOfGamesWon;
    private boolean turn;
    private String type;

    // Constructors of NimPlayer
    // Constructor 1: Set player's default information
    public NimPlayer() {
        this.username = "username";
        this.given_name = "given_name";
        this.family_name = "family_name";
        this.numberOfGamesPlayed = 0;
        this.numberOfGamesWon = 0;
        this.turn = false;
        this.type = "default";
    }

    // Constructor 2: Set player's username, family name and given name as input
    public NimPlayer(String username, String family_name, String given_name) {
        this.username = username;
        this.given_name = given_name;
        this.family_name = family_name;
        this.numberOfGamesPlayed = 0;
        this.numberOfGamesWon = 0;
        this.turn = false;
        this.type = "default";
    }

    // Constructor 3: Set player's username, family name and given name as input
    public NimPlayer(String username) {
        this.username = username;
        this.given_name = "given_name";
        this.family_name = "family_name";
        this.numberOfGamesPlayed = 0;
        this.numberOfGamesWon = 0;
        this.turn = false;
        this.type = "default";
    }

    // Constructor 3: Set player's full details as input
    public NimPlayer(String username, String family_name, String given_name,
                     int gamePlayed, int gameWon) {
        this.username = username;
        this.given_name = given_name;
        this.family_name = family_name;
        this.numberOfGamesPlayed = gamePlayed;
        this.numberOfGamesWon = gameWon;
        this.turn = false;
        this.type = "default";
    }

    // Get player username
    public String getUsername() { return username; }

    // Get player given name
    public String getGivenname() {
        return given_name;
    }

    // Get player family name
    public String getFamilyname() {
        return family_name;
    }

    // Get player number of games played
    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    // Get player number of games won
    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    // Get player winning ratio
    public float getWinningRatio() {
        float winningRatio;
        if (numberOfGamesPlayed != 0) {
            winningRatio = ((float)numberOfGamesWon / (float)numberOfGamesPlayed) * 100;
            return winningRatio;
        } else return 0;
    }

    // Get player username
    public String getType() { return this.type; }

    // Set player user name
    public void setUsername(String newName) {
        this.username = newName;
    }

    // Set player given name
    public void setGivenname(String newName) {
        this.given_name = newName;
    }

    // Set player family name
    public void setFamilyname(String newName) {
        this.family_name = newName;
    }

    // Set player number of games played
    public void setNumberOfGamesPlayed(int newGamesPlayed) {
        this.numberOfGamesPlayed = newGamesPlayed;
    }

    // Set player number of games won
    public void setNumberOfGamesWon(int newGamesWon) {
        this.numberOfGamesWon = newGamesWon;
    }

    // Set player username
    public void setType(String type) { this.type = type; }

    // Set player's turn
    public void setTurn(String onoff) {
        if (onoff.equalsIgnoreCase("ON")) turn = true;
        else turn = false;
    }

    // Get player's turn
    public String getTurn() {
        if (turn) return "ON";
        else return "OFF";
    }

    // Flip player's turn
    public void flipTurn() {
        turn = !turn;
    }

    // If it is player's turn, remove current stone number
    public abstract int removeStone(int currentStone, int removeStone, Scanner keyboard)
            throws InvalidMoveException, NumberFormatException;
    public abstract int removeStone2(int currentStone, int removeStone)
            throws InvalidMoveException, NumberFormatException;
    public abstract void removeStoneAdvanced(boolean[] stoneAvailable, Scanner keyboard);

    // toString
    @Override
    public String toString() {
        return getUsername() + "," + getFamilyname() + "," + getGivenname() + "," +
            getNumberOfGamesPlayed() + "," + getNumberOfGamesWon();
    }
}
