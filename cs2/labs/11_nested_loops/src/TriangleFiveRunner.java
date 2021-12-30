import static java.lang.System.*;

public class TriangleFiveRunner
{
    public static void main(String args[])
    {
        TriangleFive fv = new TriangleFive('C', 4);
        out.print(fv);

        fv.setLetter('A');
        fv.setAmount(5);
        out.print(fv);

        fv.setLetter('B');
        fv.setAmount(7);
        out.print(fv);

        fv.setLetter('X');
        fv.setAmount(6);
        out.print(fv);

        fv.setLetter('Z');
        fv.setAmount(8);
        out.print(fv);

	}
}
