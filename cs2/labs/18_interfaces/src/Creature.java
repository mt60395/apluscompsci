public interface Creature {
    String getName();
    int getHowBig();
    boolean isBigger(Monster other);
    boolean isSmaller(Monster other);
    boolean namesTheSame(Monster other);
}
