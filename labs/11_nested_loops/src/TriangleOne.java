import static java.lang.System.*;

import java.util.Scanner;

public class TriangleOne {
    //this lab is setup with a single static method
    //there are no instance variables or additional methods / constructors

    public static String createTriangle(String let, int size) {
        String output = "";
        for (int i = 1; i <= size; i++) {
            String line = "";
            for (int length = 0; length < i; length++) {
                line += let;
            }
            output += line + "\n";
        }
        return output;
    }
}
