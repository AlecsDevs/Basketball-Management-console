/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basketball_Management;

import java.util.ArrayList;

class League {
    private ArrayList<BasketballTeam> teams;
    private ArrayList<Game> games;

    public League() {
        this.teams = new ArrayList<>();
        this.games = new ArrayList<>();
    }

    public void addTeam(BasketballTeam team) {
        teams.add(team);
    }

    public void scheduleGame(BasketballTeam team1, BasketballTeam team2, String date, String time) {
        Game newGame = new Game(team1, team2, date, time);
        games.add(newGame);
    }

    // Method to update game results
    public void recordGameResult(BasketballTeam team1, BasketballTeam team2, boolean team1Won) {
        if (team1Won) {
            team1.incrementWins();
            team2.incrementLosses();
        } else {
            team1.incrementLosses();
            team2.incrementWins();
        }
    }

    // Method to display teams and their standings (wins/losses)
    public void displayStandings() {
        System.out.println("\nLeague Standings:");
        for (BasketballTeam team : teams) {
            System.out.println(team.getName() + " - Wins: " + team.getWins() + ", Losses: " + team.getLosses());
        }
    }

    public void displayTeams() {
        if (teams.isEmpty()) {
            System.out.println("No teams available.");
        } else {
            for (BasketballTeam team : teams) {
                team.displayTeam();
            }
        }
    }

    public void displayGames() {
        if (games.isEmpty()) {
            System.out.println("No games scheduled.");
        } else {
            for (Game game : games) {
                System.out.println(game.getGameDetails());
            }
        }
    }
}
