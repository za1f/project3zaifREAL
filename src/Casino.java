import java.util.Scanner;
public class Casino {
    private People char1 = new People("Kass Ino", "Female", 21, "After spending all of her money on New Jeans concerts and albums, Kass needs to find another way to pay off her student debt", "intolerable to alcohol", "will never give up", 40000);
    private People char2 = new People("Uncle Fred", "Male", 43, "After his wife divorced him for being unemployed, he needs to find a new way to take care of himself", "raging alcoholic", "raging alcoholic", 30000);
    private People char3 = new People("Alon Red", "Male", 25, "He really wants his first car to be a corvette c6", "easily influenced", "very lucky", 35000);
    private People char4 = new People("Ilahv Slottz", "Female", 19, "After failing to get into her dream college, her parents see her as a failure and kick her out of the house to live on the streets", "very fraile","incredibly smart", 50000);
    private Scanner scan = new Scanner(System.in);

    public Casino(){}

    public void charInfo(){
        System.out.println("=================[ CHARACTER 1 ]=================");
        System.out.println(char1.CharacterInfo());
        System.out.println("=================[ CHARACTER 2 ]=================");
        System.out.println(char2.CharacterInfo());
        System.out.println("=================[ CHARACTER 3 ]=================");
        System.out.println(char3.CharacterInfo());
        System.out.println("=================[ CHARACTER 4 ]=================");
        System.out.println(char4.CharacterInfo());
    }


}


