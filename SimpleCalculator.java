import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        int n;
        do {
            System.out.print("Enter First number: ");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();

            System.out.print("Enter Second number: ");
            int y = sc.nextInt();

            System.out.println("Enter 1 for Addition ");
            System.out.println("Enter 2 for Subtraction ");
            System.out.println("Enter 3 for Multiplication ");
            System.out.println("Enter 4 for Division ");
            System.out.print("Enter Choice: ");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Addition:" + (x + y));
                    break;
                case 2:
                    System.out.println("Subtraction:" + (x - y));
                    break;
                case 3:
                    System.out.println("Multiplication:" + (x * y));
                    break;
                case 4:
                    System.out.println("Division:" + (x / y));
                    break;
                default:
                    System.out.println("Invalid Choice. Exiting..");
                    break;
            }
        }
        while (n != 5);
    }
}


