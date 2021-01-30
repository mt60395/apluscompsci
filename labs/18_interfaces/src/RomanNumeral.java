public class RomanNumeral implements ComparableRoman<RomanNumeral>
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		roman = str;
		number = getNumber();
	}

	public RomanNumeral(Integer orig)
	{
		number = orig;
		roman = toString();
	}

	//write a set number method
	public void setNumber(Integer n) {
		number = n;
	}


	//write a set roman method
	public void setRoman(String s) {
		roman = s;
	}

	//write get methods for number and roman
	public Integer getNumber() {
		int num = 0;
		String clone = roman;
		while (clone.length() != 0) {
			for (int i = 0; i < LETTERS.length; i++) {
				String s = LETTERS[i];
				int index = clone.indexOf(s);
				if (index == 0) {
					num += NUMBERS[i];
					clone = clone.substring(s.length());
				}
			}
		}
		setNumber(num);
		return number;
	}

	public int compareTo(RomanNumeral r) {
		return getNumber() - r.getNumber();
	}

	//write  toString() method
	public String toString() {
		String newRoman = "";
		int num = number;
		for (int i = 0; i < NUMBERS.length; i++) {
			while (num >= NUMBERS[i]) {
				newRoman += LETTERS[i];
				num -= NUMBERS[i];
			}
		}
		setRoman(newRoman);
		return roman;
	}
}
