import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Games {
    private String[] gameNames = {"Game1", "Game2", "Game3", "Game4"};
    private double[] gamePrices = {29.99, 49.99, 19.99, 39.99};
    private List<String> selectedGames = new ArrayList<>();
    private List<Double> selectedPrices = new ArrayList<>();
    private double totalPrice = 0.0;

    // Method to display games along with prices
    void display() {
        System.out.println("Available Games:");
        for (int i = 0; i < gameNames.length; i++) {
            System.out.println((i + 1) + ". " + gameNames[i] + ": ₹" + gamePrices[i]);
        }
    }

    // Method to take inputs from user to select games by serial number and add each game price to a variable
    void Showdetails() {
        Scanner scanner = new Scanner(System.in);
        int selectedGameNumber;
        System.out.println("Enter the serial number of the game you want to select (type 0 to finish):");

        while (true) {
            selectedGameNumber = scanner.nextInt();
            if (selectedGameNumber == 0) {
                break;
            }
            switch (selectedGameNumber) {
                case 1:
                case 2:
                case 3:
                case 4:
                    String selectedGame = gameNames[selectedGameNumber - 1];
                    if (!selectedGames.contains(selectedGame)) {
                        selectedGames.add(selectedGame);
                        selectedPrices.add(gamePrices[selectedGameNumber - 1]);
                        totalPrice += gamePrices[selectedGameNumber - 1];
                        System.out.println(selectedGame + " added to your selection.");
                    } else {
                        System.out.println(selectedGame + " has already been selected.");
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please select a valid game number.");
                    break;
            }
        }
        scanner.close();
    }

    // Method to display the final invoice with the selected games and total price
    void displayFinalInvoice() {
        System.out.println("\nFinal Invoice:");
        for (int i = 0; i < selectedGames.size(); i++) {
            System.out.println(selectedGames.get(i) + ": ₹" + selectedPrices.get(i));
        }
        System.out.println("Total Price for selected games: ₹" + totalPrice);
    }

    public static void main(String[] args) {
        Games games = new Games();
        games.display();
        games.Showdetails();
        games.displayFinalInvoice();
    }
}