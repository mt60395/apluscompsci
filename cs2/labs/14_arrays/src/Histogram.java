import java.util.Scanner;

public class Histogram
{
	//add and int[] array instance variable
    int[] array = new int[10];
	//constructor
    public Histogram(int[] a) {
        array = a;
    }
	//set method
    public void setArray(int[] a) {
        array = a;
    }
	//toString method
    public String toString() {
        int[] counter = new int[10];
        for (int i: array) {
            counter[i]++;
        }
        String output = "";
        for (int i = 0; i < counter.length; i++) {
            output += "" + i + " - " + counter[i] + "\n";
        }
        return output;
    }
}
