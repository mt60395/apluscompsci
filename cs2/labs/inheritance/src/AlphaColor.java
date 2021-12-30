import static java.lang.System.*;

public class AlphaColor extends Color {
    private int alpha; // represents the degree of transparency of the color
    public AlphaColor(int r, int g, int b, int a) {
        super(r, g, b);
        alpha = a;
    }
    public AlphaColor(double c, double m, double y, double k, int a) {
        super(cmykToRGB(k, c), cmykToRGB(k, m), cmykToRGB(k, y));
        alpha = a;
    }

    private static int cmykToRGB(double black, double color) { // helper method to convert CMYK format to RGB format
        double white = 1 - black;
        return (int) Math.round(255 * white * (1 - color));
    }

    public void dissolve() { // fade
        if (alpha < 255) {
            alpha++;
            if (getRed() < 255) {
                setRed(getRed() + 1);
            }
            if (getBlue() < 255) {
                setBlue(getBlue() + 1);
            }
            if (getGreen() < 255) {
                setGreen(getGreen() + 1);
            }
        }
    }

    public void precipitate() {
        if (alpha > 0) {
            alpha--;
            if (getRed() > 0) {
                setRed(getRed() - 1);
            }
            if (getBlue() > 0) {
                setBlue(getBlue() - 1);
            }
            if (getGreen() > 0) {
                setGreen(getGreen() - 1);
            }
        }
    }

    @Override
    public String toString() {
        String degree;
        if (alpha <= 100) {
            degree = "transparent";
        }
        else if (alpha <= 200) {
            degree = "translucent";
        }
        else {
            degree = "opaque";
        }
        return super.toString() + String.format("(%s:%d)", degree, alpha);
    }

    public static void main(String[] args) {
        // Create a red color
        Color c = new Color(255, 0, 0);
        out.println(c);

        // change it to white
        c.setBlue(255);
        c.setGreen(255);
        out.println(c);

        // Create an AlphaColor green that is opaque
        AlphaColor green = new AlphaColor(0, 255, 0, 255);
        out.println(green);

        // test dissolve/precipitate
        green.precipitate();
        out.println(green);
        green.dissolve();
        out.println(green);

        // Create an AlphaColor using the CMYK constructor
        AlphaColor magenta = new AlphaColor(0.0, 1.0, 0.0, 0.0, 0);
        out.println(magenta);

        // Create an AlphaColor using the CMYK constructor
        AlphaColor orange = new AlphaColor(0.0, 0.4392156862745098, 1.0, 0.0, 200);
        out.println(orange);
    }
}
