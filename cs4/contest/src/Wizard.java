import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Wizard {
    // lengths indices don't work must use arrays
    private static final String[] qwertyCaps = new String[]
            {"!","@","#","$","%","^","&","*","(", ")","_","+","Q","W","E","R","T","Y","U","I","O","P","{","A","S","D","F","G","H","J","K","L",":","\"","Z","X","C","V","B","N","M","<",">","?"};
    private static final String[] dvorakCaps = new String[]
            {"!","@","#","$","%","^","&","*","(",")","[","+","\"","<",">","P","Y","F","G","C","R","L","?","A","O","E","U","I","D","H","T","N","S","_",":","Q","J","K","X","B","M","W","V","Z"};
    private static final String[] qwertyLower = new String[]
            {"1","2","3","4","5","6","7","8","9","0","-","=","q","w","e","r","t","y","u","i","o","p","[","a","s","d","f","g","h","j","k","l",";","\'","z","x","c","v","b","n","m",",",".","/", " "};
    private static final String[] dvorakLower = new String[]
            {"1","2","3","4","5","6","7","8","9","0","]","=","'",",",".","p","y","f","g","c","r","l","/","a","o","e","u","i","d","h","t","n","s","-",";","q","j","k","x","b","m","w","v","z"," "};

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("wizard.dat");
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            System.out.println(dvorakToQwerty(s.nextLine()));
        }
    }
    private static String dvorakToQwerty(String s) {
        StringBuffer buffer = new StringBuffer();
        for (char c: s.toCharArray()) {
            if (indexOf(dvorakCaps, c) != -1) {
                buffer.append(qwertyCaps[indexOf(dvorakCaps, c)]);
            }
            else if (indexOf(dvorakLower, c) != -1) {
                buffer.append(qwertyLower[indexOf(dvorakLower, c)]);
            }
            else {
                System.out.println("?" + c);
            }
        }
        return buffer.toString();
    }

    public static int indexOf(String[] arr, char element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(String.valueOf(element))) {
                return i;
            }
        }
        return -1;
    }
}
