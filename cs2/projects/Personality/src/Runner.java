import java.io.*;
import java.util.Scanner;

import static java.lang.System.out;

public class Runner {
    public static void main(String[] args) throws IOException {
        // find file
        Scanner s = new Scanner(System.in);
        String fileName = "";
        do {
            out.print("Input file name: ");
            String name = s.next();
            if (new File(name).exists()) {
                fileName = name;
            }
            else {
                out.println("Invalid file name! Make sure the input file is in the project folder.");
            }
        } while(!new File(fileName).exists());

        // read file and output to a file
        File inputFile = new File(fileName);
        Scanner input = new Scanner(inputFile);

        PrintWriter fileOut = new PrintWriter(new FileWriter("personality.out"));
        Personality p = new Personality();
        for (int i = 0; i < 9; i++) { // There are 9 pairs
            p.setName(input.nextLine());
            p.setAnswers(input.nextLine());
            fileOut.print(p);
        }
        fileOut.close();
        out.println("Your results have been saved to the file: personality.out");
    }
}
