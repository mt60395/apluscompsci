import static java.lang.System.*;

public class TriangleFourRunner
{
   public static void main( String args[] )
   {
      TriangleFour f = new TriangleFour(3, "R");
      out.print(f.toString());

      f.setTriangle("B", 4);
      out.print(f.toString());

      f.setTriangle("X", 5);
      out.print(f.toString());

      f.setTriangle("E", 2);
      out.print(f.toString());

      f.setTriangle("T", 1);
      out.print(f.toString());
   }
}
