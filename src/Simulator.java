/*
 * Written by Nick Lauer
 */
import java.io.*;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Robot Simulator");
            System.out.println("Enter file for the Board");
            String boardFile = scanner.nextLine();

            System.out.println("Enter file for the Robot Commands");
            String commandFile = scanner.nextLine();

            // Handle IO Exception within methods and continuing the loop in case of an error
            try {
                Board board = new Board(readFile(boardFile));
                Queue<String> commands = loadCommands(commandFile);

                Robot robot = new Robot();
                boolean crashed = false;

                board.printBoard(robot);
                int commandCount = 0;

                while (!commands.isEmpty() && !crashed) {
                    String command = commands.dequeue();
                    System.out.println("\nCommand: " + commandCount);

                    switch (command) {
                        case "Move Up":
                            robot.moveUp();
                            break;
                        case "Move Down":
                            robot.moveDown();
                            break;
                        case "Move Left":
                            robot.moveLeft();
                            break;
                        case "Move Right":
                            robot.moveRight();
                            break;
                        default:
                            System.out.println("Invalid command: " + command);
                    }

                    if (!board.isValidMove(robot.getX(), robot.getY())) {
                        crashed = true;
                        System.out.println("CRASH");
                    } else {
                        board.printBoard(robot);
                    }

                    commandCount++;
                }

                System.out.println("\nSimulation end");
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
            String quit = scanner.nextLine();
            if ("true".equalsIgnoreCase(quit)) {
                break;
            }
        }
        scanner.close();
    }

    // Method to read the file
    public static String[] readFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] lines = new String[10];
            for (int i = 0; i < 10; i++) {
                lines[i] = reader.readLine();
            }
            return lines;
        }
    }

    // Method to load commands throwing IO Exception to be handled in calling method
    public static Queue<String> loadCommands(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            Queue<String> commands = new Queue<>();
            String line;
            while ((line = reader.readLine()) != null) {
                commands.enqueue(line);
            }
            return commands;
        }
    }
}