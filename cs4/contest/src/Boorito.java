import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Boorito {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("boorito.dat");
        Scanner s = new Scanner(f);
        int lines = s.nextInt();
        s.nextLine();
        for (int i = 0; i < lines; i++) {
            String line = s.nextLine();
            String costume = line.substring(0, line.lastIndexOf(" "));
            String time = line.substring(line.lastIndexOf(" ") + 1);
            System.out.println(check(costume, time));
        }
    }
    private static String check(String costume, String time) {
        if (costume.equals("Self")) return "BURRITNO";
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]) + Integer.parseInt(split[1])/100;
        if (hours < 17 || hours > 22) return "BURRITNO";
        return "BOORITO";
    }
}
