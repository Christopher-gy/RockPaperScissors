import java.util.Scanner;

public class MyProgram
{
    // Constants to represent choices
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        // Ask user how many rounds to play
        System.out.print("Enter how many rounds you want to play: ");
        int rounds = scanner.nextInt();
        
        // Arrays to store the choices made by user and computer in each round
        int[] userChoices = new int[rounds];
        int[] compChoices = new int[rounds];
        
        // Counters for wins and ties
        int userWins = 0, compWins = 0, ties = 0;
        
        
        // Loop through each round
        for (int i = 0; i < rounds; i++)
        {
            // Prompt user to enter choice
            System.out.print("Enter 1=Rock, 2=Paper, 3=Scissors: ");
            int userChoice = scanner.nextInt();
            
            // Generate random choice for computer between 1 and 3
            int compChoice = (int)(Math.random() * 3) + 1;
            
            // Store choices in arrays
            userChoices[i] = userChoice;
            compChoices[i] = compChoice;
            
            // Determine the result of the round
            if (userChoice == compChoice)
            {
                ties++;
            }
            else if    ((userChoice == ROCK && compChoice == SCISSORS) ||
                       (userChoice == PAPER && compChoice == ROCK) ||
                       (userChoice == SCISSORS && compChoice == PAPER))
            {
                userWins++;
            }
            else
            {
                compWins++;
            }
            
            // Print the choices for this round in string form
            System.out.println("You: " + choiceToString(userChoice) + " | Computer: " + choiceToString(compChoice));
        }
        
        // After all rounds, print the final results
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        System.out.println("Ties: " + ties);
        
        // Close scanner
        scanner.close();
    }
    
    public static String choiceToString(int choice)
    {
        if (choice == ROCK) return "Rock";
        if (choice == PAPER) return "Paper";
        if (choice == SCISSORS) return "Scissors";
        return "invalid";
    }
    
}