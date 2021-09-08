import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lycanthropy {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("lycanthropy.dat");
        Scanner s = new Scanner(f);
        int lines = s.nextInt();
        for (int i = 0; i < lines; i++) {
            s.nextLine();
            double w = s.nextDouble();
            double m = s.nextDouble();
            double d = Math.pow(w * 3.14, 0.333) / Math.pow(m + 1234567890, 0.2);
            System.out.println(Math.round(d * 1000.00) / 1000.00);
        }
    }
}
