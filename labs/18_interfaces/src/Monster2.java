public class Monster2 implements Comparable {
    private int myWeight;
    private int myHeight;
    private int myAge;

    //write a default Constructor
    public Monster2() {
        myWeight = 0;
        myHeight = 0;
        myAge = 0;
    }

    //write an initialization constructor with an int parameter ht
    public Monster2(int ht) {
        myHeight = ht;
    }

    //write an initialization constructor with int parameters ht and wt
    public Monster2(int ht, int wt) {
        myHeight = ht;
        myWeight = wt;
    }

    //write an initialization constructor with int parameters ht, wt, and age
    public Monster2(int ht, int wt, int age) {
        myHeight = ht;
        myWeight = wt;
        myAge = age;
    }

    //accessors - write get methods for height, weight, and age
    public int getMyHeight() {
        return myHeight;
    }

    //modifiers - write set methods for height, weight, and age
    public void setMyHeight(int ht) {
        myHeight = ht;
    }

    public int getMyWeight() {
        return myWeight;
    }

    public void setMyWeight(int wt) {
        myWeight = wt;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int age) {
        myAge = age;
    }

    //creates a new copy of this Object
    public Object clone() {
        return new Monster2(myHeight, myWeight, myAge);
    }

    public boolean equals(Object obj) {
        Monster2 two = (Monster2) obj;
        return getMyWeight() == two.getMyWeight() && getMyHeight() == two.getMyHeight() && getMyAge() == two.getMyAge();
    }

    public int compareTo(Object obj) {
        Monster2 rhs = (Monster2) obj;
        int h = Integer.compare(getMyHeight(), rhs.getMyHeight());
        if (h == 0) { // height same? compare width.
            return Integer.compare(getMyWeight(), rhs.getMyWeight());
        }
        return h;
    }

    //write a toString() method
    public String toString() {
        return String.format("%d %d %d", myHeight, myWeight, myAge);
    }
}
