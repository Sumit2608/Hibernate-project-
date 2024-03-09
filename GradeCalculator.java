import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Subjects: ");
        int ts = sc.nextInt();

        double tm = 0;
        for (int i = 1; i <= ts; i++) {
            System.out.print("Enter marks of every subject out of 100 " + i + ": ");
            double marks = sc.nextDouble();
            tm += marks;
        }
        double avg;
        avg = tm / ts;
        System.out.println("Average Marks: "+avg);

        if (avg >= 33) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
    }
}

