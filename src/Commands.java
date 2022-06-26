import java.util.Scanner;

public class Commands {

    private final Scanner scanner = new Scanner(System.in);
    private final String name;
    private final String[] commands;


    public Commands(String name, String[] commands) {
        this.name = name;
        this.commands = commands;
    }

    public void printMessage(String message){
        System.out.println(message);
    }
    public void printCommands(){
        for (int i = 0; i < commands.length; i++){
            printMessage((i + 1) + " : " + commands[i]);
        }
    }


    public double getUserMoney() {
        double input = 0;
        boolean hasEnteredMoney = true;
        while(hasEnteredMoney){
            printMessage("Please enter the amount of money you have?");
            double userInput = scanner.nextDouble();
            if (userInput < 1) {
                printMessage("Your gonna need more than that!");
            } else {
                input = userInput;
                hasEnteredMoney = false;
            }
        }
        return input;
    }

    public int getUserChoice() {
        int userChoice = 0;
        boolean isActive = true;
        while(isActive){
            printMessage("Please choose an option");
            int userInput = scanner.nextInt();
            if (userInput > 0 && userInput <= commands.length) {
                isActive = false;
                userChoice = userInput;
            } else {
                printMessage(("please select a valid number from the list"));
            }
        }
        scanner.nextLine();
        return userChoice;
    }
}

