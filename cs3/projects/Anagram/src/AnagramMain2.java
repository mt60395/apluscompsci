import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AnagramMain2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("demo.txt"));
        List<String> dictionary = new ArrayList<String>();
        while (input.hasNextLine()) {
            dictionary.add(input.nextLine());
        }
        List<String> dictionary2 = Collections.unmodifiableList(dictionary);
        Anagrams solver = new Anagrams(dictionary2);
        System.out.println();
        solver.print("eleven plus two", 0);
    }
}
