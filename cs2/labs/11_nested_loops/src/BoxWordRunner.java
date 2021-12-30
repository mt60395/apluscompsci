import static java.lang.System.*;

public class BoxWordRunner
{
    public static void main( String args[] )
    {
        BoxWord box = new BoxWord("SQUARE");
        out.print(box.toString());

        box.setWord("BOX");
        out.print(box.toString());

        box.setWord("A");
        out.print(box.toString());

        box.setWord("IT");
        out.print(box.toString());

        box.setWord("TOAD");
        out.print(box.toString());
	}
}
