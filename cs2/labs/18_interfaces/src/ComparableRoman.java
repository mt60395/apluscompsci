public interface ComparableRoman<RomanNumeral> {
    void setNumber(Integer n);
    void setRoman(String s);
    Integer getNumber();
    int compareTo(RomanNumeral r);
}
