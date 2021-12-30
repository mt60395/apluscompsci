public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; // String ends with a space
        GuitarString[] strings = new GuitarString[keyboard.length()];
        for (int i = 0; i < keyboard.length(); i++) {
            double frequency = 440.0 * Math.pow(1.05956, i - 24);
            strings[i] = new GuitarString(frequency);
        }
        StdDraw.text(0.5, 0.5, "KEYBOARD | " + keyboard);
        play(keyboard, strings);
    }
    
    private static void play(String keyboard, GuitarString[] strings) {
        while (true) {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index == -1) continue;
                GuitarString string = strings[index];
                string.pluck();
            }

            // compute the superposition of the samples
            double sample = 0.0;
            for (int i = 0; i < strings.length; i++) {
                GuitarString string = strings[i];
                sample += string.sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < strings.length; i++) {
                GuitarString string = strings[i];
                string.tic();
            }
        }
    }
}
