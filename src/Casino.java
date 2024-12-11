import java.util.Scanner;
import java.util.Random;

public class Casino {
    private People char1 = new People("Kass Ino", "Female", 21, "After spending all of her money on New Jeans concerts and albums, Kass needs to find another way to pay off her student debt", "intolerable to alcohol", "will never give up", 40000);
    private People char2 = new People("Uncle Fred", "Male", 43, "After his wife divorced him for being unemployed, he needs to find a new way to take care of himself", "raging alcoholic", "raging alcoholic", 30000);
    private People char3 = new People("Alon Red", "Male", 25, "He really wants his first car to be a Corvette C6", "easily influenced", "very lucky", 35000);
    private People char4 = new People("Ilahv Slottz", "Female", 19, "After failing to get into her dream college, her parents see her as a failure and kick her out of the house to live on the streets", "very frail", "incredibly smart", 50000);
    private static Scanner scanner = new Scanner(System.in); // Shared Scanner instance
    private static double money = 1000.00;
    private static double bet;
    private static People mainChar = new People("a","a",0,"a","3","3",3);

    public static double getMoney1() {
        return money;
    }

    public static double getTarg(){
        return mainChar.getMoney();
    }

    public void intro(){
        System.out.println("============[ CHARACTER 1 ]============");
        System.out.println(char1.CharacterInfo());
        System.out.println("============[ CHARACTER 2 ]============");
        System.out.println(char2.CharacterInfo());
        System.out.println("============[ CHARACTER 3 ]============");
        System.out.println(char3.CharacterInfo());
        System.out.println("============[ CHARACTER 4 ]============");
        System.out.println(char4.CharacterInfo());
        System.out.println("Who would you like to pick? (1/2/3/4): ");
        int select = scanner.nextInt();
        if (select == 1){
            mainChar = char1;
        } else if (select == 2){
            mainChar = char2;
        } else if (select == 3){
            mainChar = char3;
        } else {
            mainChar = char4;
        }

        System.out.println("You have selected: " + mainChar.getName());

    }
    public void playSlotMachine() {
            Random random = new Random();
            String[] symbols = {"\uD83C\uDF52", "\uD83C\uDF4B", "\uD83C\uDF4A", "\uD83D\uDD14", "⭐", "\uD83D\uDC8E"};

            String reel1 = symbols[random.nextInt(symbols.length)];
            String reel2 = symbols[random.nextInt(symbols.length)];
            String reel3 = symbols[random.nextInt(symbols.length)];
            System.out.println("==[ WELCOME TO THE SLOT MACHINE ]==");
            System.out.println("Current balance: " + money);
            System.out.println("How much would you like to bet: ");
            bet = scanner.nextDouble();
            if (bet > money){
                System.out.println("you are not that rich");
            } else {
                System.out.println("Spinning...");
                System.out.println("Results: " + reel1 + " | " + reel2 + " | " + reel3);
                if (reel1.equals(reel2) && reel2.equals(reel3)) {
                    System.out.println("YOU HIT THE JACKPOT WITH: " + reel1 + "!");
                    money = (money - bet) + (bet * 3);
                } else if (reel1.equals(reel2) || reel2.equals(reel3) || reel1.equals(reel3)) {
                    System.out.println("mediocre but good job");
                    money = (money - bet) + (bet * 1.5);
                } else {
                    System.out.println("loser idiot");
                    money = money - bet;
                }
            }
        System.out.println(money);
        }

        public void playRoulette() {
            Random random = new Random();

            System.out.println("==[ WELCOME TO THE ROULETTE TABLE ]==");
            System.out.println("Current balance: " + money);
            System.out.println("How much would you like to bet: ");
            bet = scanner.nextDouble();
            if (bet > money){
                System.out.println("you are not that rich");
            } else {
                System.out.println("Place your bet:");
                System.out.println("1. Bet on a color");
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
                        money = (money - bet) + (bet * 2);
                    } else {
                        System.out.println("You lose. Better luck next time.");
                        money = money - bet;
                    }
                } else if (choice == 2) {
                    System.out.println("Choose a number (0-36):");
                    int numberBet = scanner.nextInt();
                    int spinResult = random.nextInt(37);
                    System.out.println("The ball landed on: " + spinResult);
                    if (spinResult == numberBet) {
                        System.out.println("You win! Your number bet was correct.");
                        money = (money - bet) + (bet * 7);
                    } else {
                        System.out.println("You lose. Better luck next time.");
                        money = money - bet;
                    }
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

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

        public void playBlackjack() {
            Random random = new Random();

            int[] playerHand = new int[11];
            int[] dealerHand = new int[11];

            int playerCardCount = 2;
            int dealerCardCount = 2;

            playerHand[0] = drawCard(random);
            playerHand[1] = drawCard(random);
            dealerHand[0] = drawCard(random);
            dealerHand[1] = drawCard(random);

            System.out.println("==[ WELCOME TO BLACK JACK ]==");
            System.out.println("Current balance: " + money);
            System.out.println("How much would you like to bet: ");
            bet = scanner.nextDouble();
            if (bet > money){
                System.out.println("you are not that rich");
            } else {
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
                    money = money - bet;
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
                    money = (money - bet) + (bet * 2);
                } else if (playerTotal > dealerTotal) {
                    System.out.println("You win with " + playerTotal + " against dealer's " + dealerTotal + "!");
                    money = (money - bet) + (bet * 3);
                } else if (playerTotal < dealerTotal) {
                    System.out.println("Dealer wins with " + dealerTotal + " against your " + playerTotal + "!");
                    money = money - bet;
                } else {
                    System.out.println("It's a tie at " + playerTotal + "!");
                }
            }
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

        public void bar(){
        int beers = (int) (Math.random() * 8) + 1;;
        if (mainChar.getAge() == 43) {
            beers = (int) (Math.random() * 31943) + 29285;;
        }
        if (mainChar.getAge() < 21){
            System.out.println("you are NOT old enough to get into this bar");
            } else {
            System.out.println("Welcome to the Bar!");
            System.out.println("you are offered to drink " + beers + " glasses of beer for a bet and you agree. How much do you bet? (Balance: " + money + "):");
            bet = scanner.nextDouble();
            if (bet > money) {
                System.out.println("you're not that rich");
            } else {
                if (mainChar.getAge() == 21) {
                    System.out.println("You get really drunk and you are escorted out of the bar :(");
                    money = money - bet;
                } else if (mainChar.getAge() == 25) {
                    if (beers <= 3){
                        System.out.println("You drank them without getting tipsy at all");
                        money = money + bet;
                    } else {
                        System.out.println("Yikes, you got drunk and you're escorted out");
                        money = money - bet;
                    }
                } else {
                    System.out.println("everyone doubts you'll drink them, but you are UNCLE FRED and you drink the " + beers + " glasses of beer like a champ");
                    money = money + bet;
                    System.out.println("Unfortunately you are a raging alcoholic, so you get into a fight with the guy who bet on you");
                    int chance = (int) (Math.random() * 9) + 1;
                    if (chance == 1){
                        System.out.println("You win and keep your money");
                    } else if (chance <= 4){
                        System.out.println("The dude wins but he is nice enough and takes only his money");
                        money = money - bet;
                    } else {
                        System.out.println("You lose and he takes the earnings for himself");
                        money = money - (bet * 2);
                    }
                }
            }
        }
        }

        public void viewBalance(){
            System.out.println("Your current balance is: $" + money);
        }
    }

