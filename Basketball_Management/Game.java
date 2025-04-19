/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basketball_Management;

class Game {
    private BasketballTeam team1;
    private BasketballTeam team2;
    private String date;
    private String time;

    public Game(BasketballTeam team1, BasketballTeam team2, String date, String time) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
    }

    public String getGameDetails() {
        return team1.getName() + " vs " + team2.getName() + " on " + date + " at " + time;
    }

    // Getter methods for team1 and team2
    public BasketballTeam getTeam1() {
        return team1;
    }

    public BasketballTeam getTeam2() {
        return team2;
    }
}
