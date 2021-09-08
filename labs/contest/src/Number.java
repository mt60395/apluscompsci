import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Number {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("number.dat");
        Scanner s = new Scanner(f);
        while (s.hasNextInt()) {
            int n = s.nextInt();
            check(n);
        }
    }
    public static void check(int n) {
        ArrayList<String> words = new ArrayList<>();
        // Perfect: equal to the sum of its proper divisors
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        if (sum == n) {
            words.add("Perfect");
        }
        // Deficient: greater than the sum of its proper divisors
        if (n > sum) {
            words.add("Deficient");
        }
        // Abundant: less than the sum of its proper divisors
        if (n < sum) {
            words.add("Abundant");
        }
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for (char c: binary.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        // Evil: positive integer which contains an even number of 1s when written in binary
        if (count % 2 == 0) {
            words.add("Evil");
        }
        // Odious: positive integer which contains an odd number of 1s when written in binary
        else {
            words.add("Odious");
        }
        // thanks mr thomas
        Map<Long, Integer> primeCount = new TreeMap();
        long num = n, i = 2;
        if (!isPrime(num)) {
            while (n != 1) {
                if (n % i == 0) {
                    primeCount.put(i, 1);
                    while (n % i == 0) {
                        primeCount.put(i, primeCount.get(i) + 1);
                        n /= i;
                    }
                }
                while (!isPrime(++i)) {
                }
            }
        } else
            primeCount.put(num, 1);
        Set<Long> keys = primeCount.keySet();
        long digits = 0;
        i = 0;
        for (Long N : keys) {
            // Ugly: positive integer whose only prime factors are 2, 3, or 5
            if (i == keys.size() - 1 && N <= 5) {
                words.add("Ugly");
            }
            if (N > 10)
                digits += (N + "").length();
            else
                digits++;
            if (primeCount.get(N) > 1) {
                digits++;
            }
            i++;
        }
        String s = "" + num;
        if (s.length() == digits) {
            // Equidigital: positive integer which contains an odd number of 1s when written in binary
            words.add("Equidigital");
        } else if (s.length() < digits) {
            // Wasteful: positive integer which has fewer digits than the number of digits in its prime factorization
            words.add("Wasteful");
        } else
            // Frugal: positive integer which has more digits than the number of digits in its prime factorization
            words.add("Frugal");

        Collections.sort(words);
        for (String w: words) {
            System.out.println(w);
        }
        System.out.println("");
    }
    public static boolean isPrime(long n) {
        if (n > 100)
            n = n % 100;
        int count = 0;
        for (long i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }
        return count == 2;
    }
}
