import static java.lang.System.*;

public class Triples {
    private int number;

    public Triples() {
        this(0);
    }

    public Triples(int num) {
        number = num;
    }

    public void setNum(int num) {
        number = num;
    }

    public int[] getFactors(int num) {
        int factors[] = new int[num];
        int index = 0;
        double i = 2.0;
        for (i = 2.0; i < num; i++) {
            if (num / i == (int) (num / i)) {
                factors[index] = (int) i;
                index += 1;
            }
        }
        return factors;
    }

    private int greatestCommonFactor(int a, int b, int c) {
        int max = 0;
        for (int A : getFactors(a)) {
            for (int B : getFactors(b)) {
                for (int C : getFactors(c)) {
                    if (A == B && A == C && A != 0) {
                        max = A;
                    }
                }
            }
        }
        return max;
    }

    public String toString() {
        String output = "";
        for (int a = 1; a < number; a++) {
            for (int b = 1; b < number; b++) {
                for (int c = 1; c < number; c++) {
                    if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2)) {
                        if ((a % 2 == 0) ^ (b % 2 == 0) && c % 2 != 0) {
                            //if (greatestCommonFactor(a, b, c) != 0)
                            output += "" + a + " " + b + " " + c + "\n";
                        }
                    }
                }
            }
        }
        return output + "\n";
    }
}
