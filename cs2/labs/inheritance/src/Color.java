public class Color {
    private int red, green, blue;
    public Color() {
        red = green = blue = 0;
    }
    public Color(int r, int g, int b) {
        if (r < 0 || g < 0 || b < 0) {
            throw new IllegalArgumentException();
        }
        if (r > 255 || g > 255 || b > 255) {
            throw new IllegalArgumentException();
        }
        red = r;
        green = g;
        blue = b;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int r) {
        if (r >= 0 && r <= 255) {
            this.red = r;
        }
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int g) {
        if (g >= 0 && g <= 255) {
            this.green = g;
        }
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int b) {
        if (b >= 0 && b <= 255) {
            this.blue = b;
        }
    }

    public String toString() {
        return String.format("#(%d,%d,%d)", red, green, blue);
    }
}
