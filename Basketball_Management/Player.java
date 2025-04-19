
package Basketball_Management;

class Player implements Person {
    private String name;
    private int number;
    private int pointsScored;
    private int gamesPlayed;

    // Constructor
    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.pointsScored = 0; // Initialize points to 0
        this.gamesPlayed = 0; // Initialize games played to 0
    }

    // Method to update points scored by the player
    public void addPoints(int points) {
        this.pointsScored += points;
    }

    // Method to update games played by the player
    public void addGamePlayed() {
        this.gamesPlayed++;
    }

    // Getter methods for statistics
    public int getPointsScored() {
        return pointsScored;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
    
    @Override
    public String toString() {
        return name + " (" + number + ") - Points: " + pointsScored + ", Games Played: " + gamesPlayed;
        
    }
    
     @Override
    public void performRole() {
        System.out.println(name + " is playing in the game.");
    }
}

