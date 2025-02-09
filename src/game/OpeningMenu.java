package game;

import java.util.Scanner;

public class OpeningMenu {

    private static final Scanner scanner = new Scanner(System.in);


    public static Player showOpeningMenu() {

        while (true) {
            System.out.println("=== Welcome to the Game ===\n1. New Game\n2. Load Saved Game\n3. Settings\n4. Exit\nChoose an option: ");
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    // New game
                    System.out.println("Starting New Game...\n\nYou wake up confused and unsure of your surroundings...\nYou try to remember your own name..? ");
                    System.out.println("Enter your name: ");
                    String name = scanner.next();
                    return new Player(name);
                case '2':
                    // Saved game
                    Player player = GameThread.load();
                    if (player != null) {return player;}
                    else {break;}
                case '3':
                    // Settings (placeholder)
                    System.out.println("=== Settings ===\nSettings placeholder...");
                    break;
                case '4':
                    // Exit
                    System.out.println("Exiting the game.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}