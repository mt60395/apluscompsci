public interface ComparableRational<Rational> {
    void setRational(int num, int den);
    void setNumerator(int num);
    void setDenominator(int denominator);
    int getNumerator();
    int getDenominator();
    void add(Rational other);
    int compareTo(Rational other);
}
