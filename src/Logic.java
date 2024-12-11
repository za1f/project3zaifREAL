import java.util.Scanner;

public class Logic {
    private static Casino casino = new Casino();

    public Logic (){}

    public static void game(){
        Scanner scan1 = new Scanner(System.in);
        int choice = 0;
        casino.intro();
        double money = casino.getMoney1();
        double targ = casino.getTarg();
        while (money < targ && money > 0){
            System.out.println("What would you like to do:");
            System.out.println("1. Black Jack");
            System.out.println("2. Roulette");
            System.out.println("3. Slot Machine");
            System.out.println("4. Go to the Bar");
            System.out.println("5. View Balance");
            System.out.println("Enter (1/2/3/4/5): ");
            choice = scan1.nextInt();
            if (choice == 1){
                casino.playBlackjack();
            } else if (choice == 2){
                casino.playRoulette();
            } else if (choice == 3){
                casino.playSlotMachine();
            } else if (choice == 4){
                casino.bar();
            } else if (choice == 5) {
                casino.viewBalance();
            } else {
                System.out.println("That is not a valid option.");
            }
            money = casino.getMoney1();
        }
        if (money == 0){
            System.out.println("Wonderful you are BROKE! GAME OVER!");
            System.out.println("Balance: " + money);
        } else {
            System.out.println("Hey you actually reached your goal, good for you! GAME OVER!");
            System.out.println("Balance: " + money);
        }
    }
}
