/*
 * Note: these methods are public in order for them to be used by other files
 * in this assignment; DO NOT change them to private.  You may add additional
 * private methods to implement required functionality if you would like.
 *
 * You should remove the stub lines from each method and replace them with your
 * implementation that returns an updated image.
 */

import java.util.ArrayList;

public class Images implements ImageConversions {

    public GImage flipHorizontal(GImage source) {
        int[][] pixels = source.getPixelArray();
        int[][] flipped = new int[pixels.length][pixels[0].length];
        for (int i = 0; i < flipped.length; i++) {
            for (int j = 0; j < flipped[i].length; j++) {
                int X = flipped[i].length - 1 - j; // mirror
                flipped[i][j] = pixels[i][X];
            }
        }
        return new GImage(flipped);
    }

    public GImage rotateLeft(GImage source) {
        int[][] pixels = source.getPixelArray();
        int[][] rotated = new int[pixels[0].length][pixels.length];
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[i].length; j++) {
                int col = pixels[0].length - 1 - i;
                rotated[i][j] = pixels[j][col];
            }
        }
        return new GImage(rotated);
    }

    public GImage rotateRight(GImage source) {
        int[][] pixels = source.getPixelArray();
        int[][] rotated = new int[pixels[0].length][pixels.length];
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[i].length; j++) {
                int row = pixels.length - 1 - j;
                rotated[i][j] = pixels[row][i];
            }
        }
        return new GImage(rotated);
    }

    public GImage greenScreen(GImage source) {
        int[][] pixels = source.getPixelArray();
        for (int[] i: pixels) {
            for (int j = 0; j < i.length; j++) {
                int r = GImage.getRed(i[j]);
                int g = GImage.getGreen(i[j]);
                int b = GImage.getBlue(i[j]);
                if (g >= (2 * Math.max(r, b))) { // not all are perfect green
                    i[j] = GImage.createRGBPixel(r, g, b, 0);
                }
            }
        }
        return new GImage(pixels);
    }

    public GImage equalize(GImage source) {
        int[][] pixels = source.getPixelArray(); // will be returning this by modifying existing pixels
        ArrayList<Integer> luminosity = new ArrayList<>();
        for (int[] i: pixels) {
            for (int j: i) {
                int r = GImage.getRed(j);
                int g = GImage.getGreen(j);
                int b = GImage.getBlue(j);
                luminosity.add(computeLuminosity(r, g, b));
            }
        }
        int[] histogram = getHistogram(luminosity); // 20 lines guideline so 2 helper methods
        int[] cumulative = getCumulative(histogram);
        int index = 0; // for the luminosity arraylist
        for (int[] i: pixels) {
            for (int j = 0; j < pixels[0].length; j++) {
                int count = cumulative[luminosity.get(index++)];
                int total = pixels.length * pixels[0].length;
                int rgbValues = 255 * count / total;
                i[j] = GImage.createRGBPixel(rgbValues, rgbValues, rgbValues);
            }
        }
        return new GImage(pixels);
    }
    
    public int[] getHistogram(ArrayList<Integer> luminosity) {
        int[] histogram = new int[256]; // 0 to 255 inclusive
        luminosity.forEach(i -> {
            histogram[i]++;
        });
        return histogram;
    }
    
    public int[] getCumulative(int[] histogram) {
        int[] cumulative = new int[256];
        int sum = 0; // snowball effect
        for (int i = 0; i < cumulative.length; i++) {
            sum = cumulative[i] = histogram[i] + sum;
        }
        return cumulative;
    }

    public GImage negative(GImage source) {
        int[][] pixels = source.getPixelArray();
        for (int[] i: pixels) {
            for (int j = 0; j < i.length; j++) {
                int r = GImage.getRed(i[j]);
                int g = GImage.getGreen(i[j]);
                int b = GImage.getBlue(i[j]);
                i[j] = GImage.createRGBPixel(255 - r, 255 - g, 255 - b); // the provided code ignored alpha so.
            }
        }
        return new GImage(pixels);
    }

    public GImage translate(GImage source, int dx, int dy) {
        int[][] pixels = source.getPixelArray();
        int[][] translate = new int[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                int r = (i + dy) & translate.length;
                r = r < 0 ? translate.length + r : r;
                int c = (j + dx) % translate[i].length;
                c = c < 0 ? translate[i].length + c : c;
                translate[r][c] = pixels[i][j];
            }
        }
        return new GImage(translate);
    }

    public GImage blur(GImage source) {
        int[][] pixel = source.getPixelArray();
        int[][] blurred = new int[pixel.length][pixel[0].length];
        for(int i = 0; i < blurred.length; i++) {
            for(int j = 0; j < blurred[i].length; j++) {
                int[] RGB = rgbAvg(pixel, i, j);
                blurred[i][j] = GImage.createRGBPixel(RGB[0], RGB[1], RGB[2]);
            }
        }
        return new GImage(blurred);
    }

    public int[] rgbAvg(int[][] pixels , int row, int col) {
        ArrayList<Integer> pixelsAround = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int pixel = Integer.MIN_VALUE;
                try { pixel = pixels[row + i][col + j]; } catch (Exception e) {}
                pixelsAround.add(pixel);
            }
        }
        int R, G, B, count; // sums of RGB values and
        R = G = B = count = 0; // the count of valid pixels to divide by
        for (int p: pixelsAround) {
            if (p != Integer.MIN_VALUE) { // pixels that don't actually surround
                R += GImage.getRed(p);
                G += GImage.getGreen(p);
                B += GImage.getBlue(p);
                count++;
            }
        }
        return new int[] {R / count, G / count, B / count};
    }
}
