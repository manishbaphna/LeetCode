import java.util.Scanner;

public class Formatter {
    public static void main( String []args ) {
        Scanner scan = new Scanner(System.in);

        for (int i=0; i< 3;++i){
            String s1 = scan.next();
            int num = scan.nextInt();

            System.out.printf("%-15s%03d\n", s1, num);
        }

    }
}
