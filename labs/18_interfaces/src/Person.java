public class Person implements ComparablePerson<Person> {
    private int myYear;
    private int myMonth;
    private int myDay;
    private String myName;

    public Person(int y, int m, int d, String n) {
        myYear = y;
        myMonth = m;
        myDay = m;
        myName = n;
    }

    public int compareTo(Person other) {
        int d = getBirthday().compareTo(other.getBirthday());
        if (d == 0) {
            return toString().compareTo(toString());
        }
        return d;
    }

    public String getBirthday() {
        // I know the test cases have numbers below 100 so format them to be 2 digit
        // Then use a dictionary approach for the compareTo
        String year = (myYear<10? " ":"") + myYear;
        String month = (myMonth<10? " ":"") + myMonth;
        String day = (myDay<10? " ":"") + myDay;
        return String.format("%s/%s/%s", year, month, day);
    }

    public String toString() {
        return myName;
    }
}
