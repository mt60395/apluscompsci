public class Word implements ComparableWord<Word> {
    private String word;

    public Word(String s) {
        word = s;
    }

    public int compareTo(Word rhs) {
        int l = Integer.compare(word.length(), rhs.toString().length());
        if (l == 0) {
            return word.compareTo(rhs.toString());
        }
        return l;
    }

    public String toString() {
        return word;
    }
}
