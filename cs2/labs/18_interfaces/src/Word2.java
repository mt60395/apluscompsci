public class Word2 implements ComparableWord2<Word2> {
    private String word;

    public Word2(String s) {
        word = s;
    }

    private int numVowels() {
        String vowels = "AEIOUaeiou";
        int vowelCount = 0;
        for (char c : word.toCharArray()) {
            if (vowels.contains(String.valueOf(c))) {
                vowelCount++;
            }
        }
        return vowelCount;
    }

    public int compareTo(Word2 rhs) {
        // why is numVowels private??
        String one = word;
        Integer a = numVowels();
        word = rhs.toString();
        Integer b = numVowels();
        word = one;
        // :shrug:
        int c = a.compareTo(b);
        if (c == 0) {
            return word.compareTo(rhs.toString());
        }
        return c;
    }

    public String toString() {
        return word;
    }
}
