// 89 due to runtime inefficiency in the recursion
import java.util.ArrayList;
import java.util.List;

public class Anagrams {
    public List<String> dictionary, prunedDictionary;
    public Anagrams(List<String> dict) {
        dictionary = dict;
    }
    public void print(String text, int max) {
        if (max < 0) throw new IllegalArgumentException();
        prunedDictionary = new ArrayList<>();
        LetterInventory inventory = new LetterInventory(text);
        for (String s: dictionary) {
            if (inventory.subtract(new LetterInventory(s)) != null) {
                prunedDictionary.add(s);
            }
        }
        recurse(new LetterInventory(text), "", 0, max == 0? Integer.MAX_VALUE:max);
    }

    public void recurse(LetterInventory inv, String text, int count, int max) {
        for (String s: prunedDictionary) {
            LetterInventory sub = inv.subtract(new LetterInventory(s));
            if (sub != null) {
                if (sub.size() == 0) {
                    if (count < max) {
                        System.out.println(text + s + " ");
                    }
                }
                else {
                    recurse(sub, text + s + " ", count + 1, max);
                }
            }
        }
    }
}
