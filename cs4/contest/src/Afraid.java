import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Afraid {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("afraid.dat");
        Scanner s = new Scanner(f);
        int lines = s.nextInt();
        for (int i = 0; i < lines; i++) {
            s.nextLine();
            System.out.printf("%dspooky%dme\n", s.nextInt(), s.nextInt());
        }
    }
}
