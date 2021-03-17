public class CreditCards {
    // this method calculates the balance of a cc after only paying the min payment for a year
    public static double minMonthlyPayment(double balance, double annualInterestRate, double monthlyPaymentRate) {
        double monthlyInterestRate = annualInterestRate / 12.0; // remains static
        for (int i = 0; i < 12; i++) {
            double minMonthly = monthlyPaymentRate * balance;
            double unpaid = balance - minMonthly;
            balance = unpaid + monthlyInterestRate * unpaid;
        }
        return roundToTenths(balance);
    }

    // this method used exhaustive enumeration to ascertain
    public static int minFixedMonthlyPayment(double balance, double annualInterestRate) {
        double monthlyInterestRate = annualInterestRate / 12.0;
        int monthlyPayment = 10;

        while (true) {
            double newBalance = balance;
            for (int i = 0; i < 12; i++) {
                double unpaid = newBalance - monthlyPayment;
                newBalance = unpaid + monthlyInterestRate * unpaid;
            }
            if (newBalance < 0) {
                break;
            }
            else {
                monthlyPayment += 10;
            }
        }
        return monthlyPayment;
    }

    // method calculates the min amount required to pay off a cc in a year by using bisection search
    public static double bisectionMonthlyAmount(double balance, double annualInterestRate) {
        double monthlyIR = annualInterestRate / 12.0;
        double lower = balance / 12.0;
        double upper = (balance * Math.pow(1.0 + monthlyIR, 12)) / 12.0;

        return bisectionMonthlyAmount(balance, monthlyIR, lower, upper);
        /*
        while (true) {
            double middle = (lower + upper) / 2;
            double newBalance = balance;
            for (int i = 0; i < 12; i++) {
                double unpaid = newBalance - middle;
                newBalance = unpaid + monthlyIR * unpaid;
            }
            if (newBalance < 0) { // middle is too high. too much money !
                upper = middle;
            }
            else { // usual. middle could probably be higher.
                if (roundToTenths(lower) == roundToTenths(upper)) {
                    return roundToTenths(middle);
                }
                lower = middle;
            }
            // tested and realized that == 0 never happens so just removed [else if > 0]
        }
         */
    }

    // recursive solution
    public static double bisectionMonthlyAmount(double balance, double monthlyIR, double lower, double upper) {
        if (roundToTenths(lower) == roundToTenths(upper)) { // must round cause they will never exactly equal
            return roundToTenths(lower);
        }
        double middle = (lower + upper) / 2;
        double newBalance = balance;
        for (int i = 0; i < 12; i++) {
            double unpaid = newBalance - middle;
            newBalance = unpaid + monthlyIR * unpaid;
        }
        if (newBalance < 0) {
            return bisectionMonthlyAmount(balance, monthlyIR, lower, middle);
        }
        return bisectionMonthlyAmount(balance, monthlyIR, middle, upper);
    }

    public static double roundToTenths(double d) {
        return Math.round(d * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        // testing part A
        System.out.println(minMonthlyPayment(42, .2, .04));
        System.out.println(minMonthlyPayment(484, .2, .04));
        System.out.println(minMonthlyPayment(151, .2, .06));
        System.out.println(minMonthlyPayment(412, .18, .08));
        System.out.println(minMonthlyPayment(416, .18, .06));
        System.out.println(minMonthlyPayment(430, .15, .04));
        System.out.println();

        // testing part B
        System.out.println(minFixedMonthlyPayment(3329, .2));
        System.out.println(minFixedMonthlyPayment(4773, .2));
        System.out.println(minFixedMonthlyPayment(3926, .2));
        System.out.println(minFixedMonthlyPayment(70, .25));
        System.out.println(minFixedMonthlyPayment(938, .2));
        System.out.println(minFixedMonthlyPayment(793, .2));
        System.out.println(minFixedMonthlyPayment(835, .18));
        System.out.println(minFixedMonthlyPayment(4778, .15));
        System.out.println(minFixedMonthlyPayment(4510, .04));
        System.out.println(minFixedMonthlyPayment(4919, .04));
        System.out.println(minFixedMonthlyPayment(3603, .18));
        System.out.println(minFixedMonthlyPayment(4800, .2));
        System.out.println(minFixedMonthlyPayment(4053, .15));
        System.out.println(minFixedMonthlyPayment(4019, .15));
        System.out.println(minFixedMonthlyPayment(3618, .15));
        System.out.println();

        // testing part C - add test cases
        System.out.println(bisectionMonthlyAmount(320000, .2));
        System.out.println(bisectionMonthlyAmount(999999, .18));
        System.out.println(bisectionMonthlyAmount(44681, .2));
        System.out.println(bisectionMonthlyAmount(282651, .15));
        System.out.println(bisectionMonthlyAmount(297119, .15));
        System.out.println(bisectionMonthlyAmount(289655, .21));
        System.out.println(bisectionMonthlyAmount(98461, .18));
        System.out.println(bisectionMonthlyAmount(374521, .22));
        System.out.println(bisectionMonthlyAmount(191204, .15));
        System.out.println(bisectionMonthlyAmount(351742, .15));
        System.out.println(bisectionMonthlyAmount(277620, .18));
        System.out.println(bisectionMonthlyAmount(497628, .15));
    }
}
