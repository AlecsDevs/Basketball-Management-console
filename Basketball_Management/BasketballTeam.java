/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Basketball_Management;


class BasketballTeam extends Team implements Person  {
    private String coach;
    private int wins;
    private int losses;

    public BasketballTeam(String name, String coach) {
        super(name); // Call the base class constructor
        this.coach = coach;
        this.wins = 0;
        this.losses = 0;
    }

    // Getter and setter for coach
    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    // Getter for wins and losses
    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    // Methods to increment wins and losses
    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }

    // Override displayTeam to include coach and wins/losses
    @Override
    public void displayTeam() {
        super.displayTeam(); // Call the base class display method
        System.out.println("Wins: " + wins + ", Losses: " + losses);
        performRole();
    }
    
     // Implementing the performRole method from Person interface
    @Override
    public void performRole() {
        System.out.println("The coach " + coach + " is managing the team of " + super.getName());
    }
}