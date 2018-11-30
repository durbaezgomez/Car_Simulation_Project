import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int choiceMenu=0;
        do {
            RunMenu();
            Scanner liczba = new Scanner(System.in);
            choiceMenu=liczba.nextInt();

            switch (choiceMenu)
            {
                case 1:
                    System.out.println("TEST1");
                    break;
                case 2:
                    System.out.println("TEST2");
                    break;
                case 3:
                    System.out.println("TEST3");
                    break;
                case 4:
                    System.out.println("TEST4");
                    break;
            }

        }while(choiceMenu !=5);

        System.out.println("EXITING...");

    }

    public static void RunMenu() {
        System.out.println("CHOOSE OPTION:");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5 - END PROGRAM");
    }
}

class Car{

    float engineThrotle;
    int gear;
    float acceleration;
    boolean breakOn;
    boolean engineOn;

}