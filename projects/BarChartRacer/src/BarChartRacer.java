import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BarChartRacer {
    public static void main(String[] args) {
        // StdAudio.loop("soundtrackA.wav"); // errors with autograder
        int k = Integer.parseInt(args[1]); // bars to display is the second command line argument
        Scanner file; // read the file provided by the first command line argument
        try {
            file = new Scanner(new File(args[0]));
        }
        catch (FileNotFoundException ex) {
            return;
        }

        // create the bar chart from the headers
        String title = file.nextLine();
        String xAxis = file.nextLine();
        String source = file.nextLine();
        BarChart chart = new BarChart(title, xAxis, source);
        StdDraw.setCanvasSize(1000, 700); // this doesn't need to be done multiple times. only once, before the racer starts.
        StdDraw.enableDoubleBuffering();
        while (file.hasNextLine()) {
            file.nextLine();
            int set = file.nextInt(); // amount of bars for one set/year, likely to stay consistent
            file.nextLine();
            String caption = ""; // only one caption
            Bar[] bars = new Bar[set];
            for (int i = 0; i < set; i++) {
                String currentBar = file.nextLine(); // data for one bar/line
                String[] barStats = currentBar.split(","); // split the data to be usable
                caption = barStats[0];
                String city = barStats[1]; // the label
                int value = Integer.parseInt(barStats[3]); // the value
                String category = barStats[4]; // the category
                bars[i] = new Bar(city, value, category);
            }
            chart.setCaption(caption);
            Arrays.sort(bars); // sort with compareTo
            Collections.reverse(Arrays.asList(bars)); // it will be sorted in ascending. make it descending for the racer.

            for (int i = 0; i < k; i++) { // show up to k bars (provided as a command line argument)
                Bar b = bars[i];
                chart.add(b.getName(), b.getValue(), b.getCategory());
            }

            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
            StdDraw.clear();
        }
    }
}
