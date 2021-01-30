public class Monster implements Creature {
    private String name;
    private int howBig;

    public Monster() {
        name = "Monster";
        howBig = Integer.MAX_VALUE;
    }

    public Monster(String n, int size) {
        name = n;
        howBig = size;
    }

    public String getName() {
        return name;
    }

    public int getHowBig() {
        return howBig;
    }

    public boolean isBigger(Monster other) {
        return getHowBig() > other.getHowBig();
    }

    public boolean isSmaller(Monster other) {
        //call isBigger() use !
        return !isBigger(other);
    }

    public boolean namesTheSame(Monster other) {
        return getName().equals(other.getName());
    }

    public String toString() {
        return getName() + " " + getHowBig();
    }
}
