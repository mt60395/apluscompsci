import static java.lang.System.*;

public class TriangleThreeRunner {
    public static void main(String args[]) {
        TriangleThree th = new TriangleThree(3, "A");
        out.print(th.toString());

        th.setTriangle("X", 7);
        out.print(th.toString());

        th.setTriangle("R", 1);
        out.print(th.toString());

        th.setTriangle("T", 5);
        out.print(th.toString());

        th.setTriangle("W", 4);
        out.print(th.toString());
    }
}
