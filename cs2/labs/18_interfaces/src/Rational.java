class Rational implements ComparableRational<Rational>
{
	//add two instance variables
    private int numerator;
    private int denominator;

	//write two constructors
	public Rational() {
		numerator = 1;
		denominator = 1;
	}

	public Rational(int num, int den) {
		numerator = num;
		denominator = den;
		reduce();
	}

	//write a setRational method
	public void setRational(int num, int den) {
		numerator = num;
		denominator = den;
		reduce();
	}

	//write  a set method for numerator and denominator
	public void setNumerator(int num) {
		numerator = num;
		reduce();
	}

	public void setDenominator(int den) {
		denominator = den;
		reduce();
	}

	public void add(Rational other)
	{
		//num1/den1 + num2/den2
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		numerator = numerator * other.getDenominator() + other.getNumerator() * denominator;
		denominator = denominator * other.getDenominator();
		reduce();
	}

	private void reduce()
	{
		int GCD = gcd(numerator, denominator);
		numerator /= GCD;
		denominator /= GCD;
	}

	private int gcd(int numOne, int numTwo)
	{
	    int largest = 1;
		for (int i = Math.min(numOne, numTwo); i > -1; i--) { // more efficient than starting from 0
			if (numOne % i == 0 && numTwo % i == 0) {
				largest = i;
				break;
			}
		}
		return largest;
	}

	public Object clone ()
	{
		return new Rational(numerator, denominator);
	}


	//ACCESSORS

	//write get methods for numerator and denominator
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public boolean equals( Object obj)
	{
		Rational other = (Rational) obj;
		return numerator == other.getNumerator() && denominator == other.getDenominator();
	}

	public int compareTo(Rational other)
	{
		return Double.compare((double)numerator/denominator, (double)other.getNumerator()/other.getDenominator());
	}

	//write  toString() method
	public String toString() {
		return numerator + "/" + denominator;
	}
}
