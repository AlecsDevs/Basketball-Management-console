
package Basketball_Management;

import java.util.ArrayList;


class Team {
    private String name;
    private ArrayList<Player> players;

    // Constructor
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void displayPlayers() {
        System.out.println("Players in team " + name + ":");
        if (players.isEmpty()) {
            System.out.println("No players added yet.");
        } else {
            for (Player player : players) {
                player.performRole();
            }
        }
    }

    public void displayTeam() {
        System.out.println("Team: " + name);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
