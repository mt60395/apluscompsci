import static java.lang.System.*;

public class BoxRunner
{
    public static void main( String args[] )
    {
        Box box = new Box(3);
        out.println(box.toString());
        box.setSize(4);
        out.println(box.toString());
        box.setSize(5);
        out.println(box.toString());
        box.setSize(2);
        out.println(box.toString());
        box.setSize(1);
        out.println(box.toString());
    }
}
