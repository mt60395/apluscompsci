public class Personality {
    private String name = "";
    private String answers = "";
    private int[] aCount = new int[4];
    private int[] bCount = new int[4];
    private int[] percents = new int[4];

    public void setName(String n) {
        name = n;
    }

    public void setAnswers(String a) {
        answers = a;
    }

    public void useAnswers() {
        aCount = new int[4];
        bCount = new int[4];
        percents = new int[4];
        for (int p = 0; p < 10; p++) { // 10 pairs
            for (int i = 0; i < 7; i++) { // 7 choices per pair
                // 0: I/E, 1-2: S/N, 3-4:T/F, 5-6:J/P
                int choice = 0; // category
                // find the category of the current choice
                if (i == 1 || i == 2) {
                    choice = 1;
                }
                else if (i == 3 || i == 4) {
                    choice = 2;
                }
                else if (i == 5 || i == 6) {
                    choice = 3;
                }
                String currentAnswers = answers.substring(p * 7, p * 7 + 7).toLowerCase();
                char currentChar = currentAnswers.charAt(i);
                if (currentChar == 'a') {
                    aCount[choice] += 1;
                }
                else if (currentChar == 'b') {
                    bCount[choice] += 1;
                }
            }
        }
    }

    public void calculatePercentages() {
        for (int i = 0; i < 4; i++) {
            double total = aCount[i] + bCount[i]; // one double in division to make a double
            double p = (bCount[i] / (total)) * 100;
            percents[i] = (int) Math.round(p);
        }
    }

    private static final String aOptions = "ESTJ";
    private static final String bOptions = "INFP";

    public String getPersonality() {
        String personality = "";
        int category = 0;
        for (int i : percents) {
            // 0: I/E, 1: S/N, 2:T/F, 3:J/P
            if (i > 50) { // second answer, more B
                personality += bOptions.charAt(category);
            }
            else if (i < 50) { // first answer, less B
                personality += aOptions.charAt(category);
            }
            else { // equal
                personality += "X";
            }
            category += 1;
        }
        return personality;
    }

    public String toString() { // print out the results of each pair
        String output = name + ":\n\t";
        useAnswers();
        for (int i = 0; i < 4; i++) { // do a and b counts. must be same loop
            output += aCount[i] + "A-" + bCount[i] + "B ";
        }
        output += "\n\t[";

        calculatePercentages();
        for (int i = 0; i < 4; i++) {
            output += percents[i] + "%";
            if (i != 3) {
                output += ", ";
            }
        }
        output += "] = " + getPersonality();
        return output + "\n\n";
    }
}
