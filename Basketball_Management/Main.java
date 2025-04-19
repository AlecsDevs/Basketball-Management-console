
package Basketball_Management;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    // List to store all teams
    static ArrayList<BasketballTeam> teams = new ArrayList<>();
    static ArrayList<Game> games = new ArrayList<>();  // List to store scheduled games
    static League league = new League(); // Create a League object

   //display methods
   static void display(){
        System.out.println("\nBasketball League Management System");
        System.out.println("-----------------------------------");
        System.out.println("1. Manage Teams");
        System.out.println("2. Schedule Games");
        System.out.println("3. View Schedule Results");
        System.out.println("4. View League Standings");
        System.out.println("5. View Player Statistics");
        System.out.println("6. Record Game Result");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");  
   } 
  

   static void manageTeams() {
    
    Scanner scan = new Scanner(System.in);
    System.out.println("\nManage Teams:");
    System.out.println("1. Add New Team");
    System.out.println("2. View Teams");
    System.out.println("3. Add Player to Team");
    System.out.println("4. Back to Main Menu");
    System.out.print("Enter your choice: ");
    int choice = scan.nextInt();
    scan.nextLine();
    
    switch (choice) {
        case 1:
            System.out.println("\nAdd New Team");
            System.out.print("\nEnter the name of the new team: ");
            String teamName = scan.nextLine();
            System.out.print("Enter the name of the coach: ");
            String coachName = scan.nextLine();
            BasketballTeam newTeam = new BasketballTeam(teamName, coachName);
            teams.add(newTeam);
            league.addTeam(newTeam);  // Add team to the league
            System.out.println("New team added: " + teamName + " (Coach: " + coachName + ")");
            break;
        case 2:
            if (teams.isEmpty()) {
                System.out.println("No teams available.");
            } else {
                for (BasketballTeam team : teams) {
                    
                    team.displayTeam();
                    
                }
            }
            break;
        case 3:
            System.out.println("\nTeams List:");
            if (teams.isEmpty()) {
                System.out.println("No teams available.");
            } else {
                for (BasketballTeam team : teams) {
                    team.displayTeam();
                }
            }
            System.out.print("Enter team name to add player to: ");
            String teamToAddPlayer = scan.nextLine();
            boolean teamFound = false;
            for (BasketballTeam team : teams) {
                if (team.getName().equalsIgnoreCase(teamToAddPlayer)) {
                    System.out.print("Enter player name: ");
                    String playerName = scan.nextLine();
                    System.out.print("Enter player jersey number: ");
                    int playerNumber = scan.nextInt();
                    scan.nextLine();  // Consume the newline character
                    Player newPlayer = new Player(playerName, playerNumber);
                    team.addPlayer(newPlayer);
                    System.out.println("Player " + playerName + " added to team " + teamToAddPlayer);
                    teamFound = true;
                    break;
                }
            }
            if (!teamFound) {
                System.out.println("Team not found!");
            }
            break;
        case 4:
            return;  // Return to the main menu
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
    }
}

   
   static void scheduleGame() {
        Scanner scan = new Scanner(System.in);
        if (teams.size() < 2) {
            System.out.println("Not enough teams to schedule a game.");
            return;
        }
        System.out.println("\nSchedule a Game:");
        System.out.println("Select two teams to play:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).getName());
        }
        System.out.print("Enter the number of the first team: ");
        int team1Index = scan.nextInt() - 1;
        System.out.print("Enter the number of the second team: ");
        int team2Index = scan.nextInt() - 1;
        scan.nextLine();  // Consume newline
        if (team1Index == team2Index) {
            System.out.println("You cannot schedule a game with the same team.");
            return;
        }
        System.out.print("Enter the game date (YYYY-MM-DD): ");
        String date = scan.nextLine();
        System.out.print("Enter the game time (HH:MM): ");
        String time = scan.nextLine();
        Game newGame = new Game(teams.get(team1Index), teams.get(team2Index), date, time);
        games.add(newGame);
        System.out.println("Game scheduled: " + newGame.getGameDetails());
        
            for (BasketballTeam team : teams) {             
                    team.displayPlayers();  
                }
           
    }

    static void viewScheduledGames() {
        if (games.isEmpty()) {
            System.out.println("No games scheduled.");
        } else {
            for (Game game : games) {
                System.out.println(game.getGameDetails());
            }
        }
    }
    
        // Method to display the standings
    static void viewLeagueStandings() {
        league.displayStandings(); // Call the League method to display standings
    }
    
    static void viewPlayerStatistics() {
        System.out.println("\nPlayer Statistics:");
        boolean hasPlayers = false;

        for (BasketballTeam team : teams) {
            ArrayList<Player> players = team.getPlayers();
            if (!players.isEmpty()) {
                hasPlayers = true;
                System.out.println("Team: " + team.getName());
                for (Player player : players) {
                    System.out.println(player.toString());
                }
                System.out.println();
            }
        }

        if (!hasPlayers) {
            System.out.println("No player statistics available. Please add players to teams.");
        }
    }
static void recordGameResult() {
    Scanner scan = new Scanner(System.in);

    if (games.isEmpty()) {
        System.out.println("No games have been scheduled yet.");
        return;
    }

    System.out.println("\nRecord Game Result:");
    System.out.println("Scheduled Games:");
    for (int i = 0; i < games.size(); i++) {
        System.out.println((i + 1) + ". " + games.get(i).getGameDetails());
    }

    System.out.print("Select a game to manage (enter number): ");
    int gameIndex = scan.nextInt() - 1;
    scan.nextLine(); // Consume newline

    if (gameIndex < 0 || gameIndex >= games.size()) {
        System.out.println("Invalid game selection.");
        return;
    }

    Game selectedGame = games.get(gameIndex);
    BasketballTeam team1 = selectedGame.getTeam1();
    BasketballTeam team2 = selectedGame.getTeam2();

    System.out.println("What would you like to do?");
    System.out.println("1. Record game winner");
    System.out.println("2. Update player points");
    System.out.print("Enter your choice: ");
    int actionChoice = scan.nextInt();
    scan.nextLine(); // Consume newline

    switch (actionChoice) {
        case 1:
            System.out.println("Who won the game?");
            System.out.println("1. " + team1.getName());
            System.out.println("2. " + team2.getName());
            System.out.print("Enter your choice: ");
            int winnerChoice = scan.nextInt();
            scan.nextLine(); // Consume newline

            if (winnerChoice == 1) {
                league.recordGameResult(team1, team2, true);
                System.out.println("Game result recorded: " + team1.getName() + " won.");
            } else if (winnerChoice == 2) {
                league.recordGameResult(team1, team2, false);
                System.out.println("Game result recorded: " + team2.getName() + " won.");
            } else {
                System.out.println("Invalid choice. No result recorded.");
            }
            break;

        case 2:
            System.out.println("Select a team to update player points:");
            System.out.println("1. " + team1.getName());
            System.out.println("2. " + team2.getName());
            System.out.print("Enter your choice: ");
            int teamChoice = scan.nextInt();
            scan.nextLine(); // Consume newline

            BasketballTeam chosenTeam = (teamChoice == 1) ? team1 : (teamChoice == 2) ? team2 : null;

            if (chosenTeam != null) {
                System.out.println("Enter points scored for players in " + chosenTeam.getName() + ":");
                for (Player player : chosenTeam.getPlayers()) {
                    System.out.print("Points scored by " + player.toString() + ": ");
                    int points = scan.nextInt();
                    scan.nextLine(); // Consume newline
                    player.addPoints(points);
                    player.addGamePlayed();
                }
            } else {
                System.out.println("Invalid team choice.");
            }
            break;

        default:
            System.out.println("Invalid choice. Returning to menu.");
            break;
    }

    // Optionally remove the game if both result and stats are updated
    System.out.print("Do you want to remove this game from the schedule? (yes/no): ");
    String removeGame = scan.nextLine().trim().toLowerCase();
    if (removeGame.equals("yes")) {
        games.remove(gameIndex);
        System.out.println("Game removed from the schedule.");
    }
}  
   public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        while (true) {
            display();
            int choice = scan.nextInt();
            scan.nextLine();
            
            switch (choice) {
                case 1:
                    manageTeams();
                    break;
                case 2:
                    scheduleGame();
                    break;
                case 3:
                    viewScheduledGames();
                    break;
                case 4:
                    viewLeagueStandings();
                    break;
                case 5:
                    viewPlayerStatistics();
                    break;
                case 6:
                    recordGameResult();
                    break;
                case 7:
                   System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
            
        }
    }

}
