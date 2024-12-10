import java.util.Scanner;
import java.util.Random;

public class Casino {
    private People char1 = new People("Kass Ino", "Female", 21, "After spending all of her money on New Jeans concerts and albums, Kass needs to find another way to pay off her student debt", "intolerable to alcohol", "will never give up", 40000);
    private People char2 = new People("Uncle Fred", "Male", 43, "After his wife divorced him for being unemployed, he needs to find a new way to take care of himself", "raging alcoholic", "raging alcoholic", 30000);
    private People char3 = new People("Alon Red", "Male", 25, "He really wants his first car to be a corvette c6", "easily influenced", "very lucky", 35000);
    private People char4 = new People("Ilahv Slottz", "Female", 19, "After failing to get into her dream college, her parents see her as a failure and kick her out of the house to live on the streets", "very fraile", "incredibly smart", 50000);
    private Scanner scan = new Scanner(System.in);

    public Casino() {
    }

    public void charInfo() {
        System.out.println("=================[ CHARACTER 1 ]=================");
        System.out.println(char1.CharacterInfo());
        System.out.println("=================[ CHARACTER 2 ]=================");
        System.out.println(char2.CharacterInfo());
        System.out.println("=================[ CHARACTER 3 ]=================");
        System.out.println(char3.CharacterInfo());
        System.out.println("=================[ CHARACTER 4 ]=================");
        System.out.println(char4.CharacterInfo());
    }

    public static void playSlotMachine() {
        Random random = new Random();
        String[] symbols = {"Cherry", "Lemon", "Orange", "Bell", "Star", "Diamond"};

        String reel1 = symbols[random.nextInt(symbols.length)];
        String reel2 = symbols[random.nextInt(symbols.length)];
        String reel3 = symbols[random.nextInt(symbols.length)];

        System.out.println("Welcome to the Slot Machine!");
        System.out.println("Spinning...");
        System.out.println("Results: " + reel1 + " | " + reel2 + " | " + reel3);

        if (reel1.equals(reel2) && reel2.equals(reel3)) {
            System.out.println("Congratulations! You hit the jackpot with " + reel1 + "!");
        } else if (reel1.equals(reel2) || reel2.equals(reel3) || reel1.equals(reel3)) {
            System.out.println("You won! Two of the same symbols!");
        } else {
            System.out.println("Sorry, you lost. Better luck next time!");
        }

    }

    public static void playRoulette() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Roulette Table!");
        System.out.println("Place your bet:");
        System.out.println("1. Bet on a color (Red, Black, Green)");
        System.out.println("2. Bet on a number (0-36)");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Choose a color (Red, Black, Green):");
            String colorBet = scanner.nextLine().toLowerCase();
            int spinResult = random.nextInt(37);
            String colorResult = getColor(spinResult);
            System.out.println("The ball landed on: " + spinResult + " (" + colorResult + ")");
            if (colorResult.equalsIgnoreCase(colorBet)) {
                System.out.println("You win! Your color bet was correct.");
            } else {
                System.out.println("You lose. Better luck next time.");
            }
        } else if (choice == 2) {
            System.out.println("Choose a number (0-36):");
            int numberBet = scanner.nextInt();
            int spinResult = random.nextInt(37);
            System.out.println("The ball landed on: " + spinResult);
            if (spinResult == numberBet) {
                System.out.println("You win! Your number bet was correct.");
            } else {
                System.out.println("You lose. Better luck next time.");
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }

    private static String getColor(int number) {
        if (number == 0) {
            return "Green";
        } else if ((number >= 1 && number <= 10) || (number >= 19 && number <= 28)) {
            return number % 2 == 0 ? "Black" : "Red";
        } else {
            return number % 2 == 0 ? "Red" : "Black";
        }
    }

    public static void playBlackjack() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] playerHand = new int[11];
        int[] dealerHand = new int[11];

        int playerCardCount = 2;
        int dealerCardCount = 2;

        playerHand[0] = drawCard(random);
        playerHand[1] = drawCard(random);
        dealerHand[0] = drawCard(random);
        dealerHand[1] = drawCard(random);

        System.out.println("Welcome to Blackjack!");
        System.out.println("Your cards: " + displayHand(playerHand, playerCardCount) + " (Total: " + calculateHandValue(playerHand, playerCardCount) + ")");
        System.out.println("Dealer's visible card: " + dealerHand[0]);

        while (calculateHandValue(playerHand, playerCardCount) < 21) {
            System.out.println("Do you want to (1) Hit or (2) Stand?");
            int choice = scanner.nextInt();

            if (choice == 1) {
                playerHand[playerCardCount++] = drawCard(random);
                System.out.println("Your cards: " + displayHand(playerHand, playerCardCount) + " (Total: " + calculateHandValue(playerHand, playerCardCount) + ")");
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }

        int playerTotal = calculateHandValue(playerHand, playerCardCount);
        if (playerTotal > 21) {
            System.out.println("You busted with " + playerTotal + ". Dealer wins!");
            return;
        }

        System.out.println("Dealer's turn...");
        System.out.println("Dealer's cards: " + displayHand(dealerHand, dealerCardCount) + " (Total: " + calculateHandValue(dealerHand, dealerCardCount) + ")");
        while (calculateHandValue(dealerHand, dealerCardCount) < 17) {
            dealerHand[dealerCardCount++] = drawCard(random);
            System.out.println("Dealer draws a card. Dealer's cards: " + displayHand(dealerHand, dealerCardCount) + " (Total: " + calculateHandValue(dealerHand, dealerCardCount) + ")");
        }

        int dealerTotal = calculateHandValue(dealerHand, dealerCardCount);
        if (dealerTotal > 21) {
            System.out.println("Dealer busted with " + dealerTotal + ". You win!");
        } else if (playerTotal > dealerTotal) {
            System.out.println("You win with " + playerTotal + " against dealer's " + dealerTotal + "!");
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins with " + dealerTotal + " against your " + playerTotal + "!");
        } else {
            System.out.println("It's a tie at " + playerTotal + "!");
        }

        scanner.close();
    }

    private static int drawCard(Random random) {
        return random.nextInt(10) + 1;
    }

    private static int calculateHandValue(int[] hand, int cardCount) {
        int total = 0;
        for (int i = 0; i < cardCount; i++) {
            total += hand[i];
        }
        return total;
    }

    private static String displayHand(int[] hand, int cardCount) {
        StringBuilder handDisplay = new StringBuilder();
        for (int i = 0; i < cardCount; i++) {
            handDisplay.append(hand[i]).append(i < cardCount - 1 ? ", " : "");
        }
        return handDisplay.toString();
    }
}


