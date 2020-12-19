import static java.lang.System.*;

public class TriangleWordRunner
{
    public static void main(String args[])
    {
        TriangleWord word = new TriangleWord("FUN");
        out.print(word);

        word.setWord("COMPUTER");
        out.print(word);

        word.setWord("A");
        out.print(word);

        word.setWord("IT");
        out.print(word);

        word.setWord("TOAD");
        out.print(word);

	}
}
