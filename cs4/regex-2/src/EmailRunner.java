public class EmailRunner
{
	public static void main ( String[] args )
	{
		Email test = new Email("compsci");
		System.out.println(test);

		test = new Email("compsci@.com.my");
		System.out.println(test);

		test = new Email("compsci123@gmail.a");
		System.out.println(test);

		test = new Email("compsci123@.com");
		System.out.println(test);

		test = new Email("compsci123@.com.com");
		System.out.println(test);

		test = new Email(".compsci@compsci.com");
		System.out.println(test);

		test = new Email("compsci()*@gmail.com");
		System.out.println(test);

		test = new Email("compsci@%*.com");
		System.out.println(test);

		test = new Email("compsci..2002@gmail.com");
		System.out.println(test);

		test = new Email("compsci.@gmail.com");
		System.out.println(test);

		test = new Email("compsci@compsci@gmail.com");
		System.out.println(test);

		test = new Email("compsci@gmail.com.1a");
		System.out.println(test);

		test = new Email("compsci@hotmail.com");
		System.out.println(test);

		test = new Email("compsci-100@yahoo.com");
		System.out.println(test);

		test = new Email("compsci.100@hotmail.com");
		System.out.println(test);

		test = new Email("compsci111@compsci.com");
		System.out.println(test);

		test = new Email("compsci-100@compsci.net");
		System.out.println(test);

		test = new Email("compsci.100@compsci.com.au");
		System.out.println(test);

		test = new Email("compsci@1.com");
		System.out.println(test);

		test = new Email("compsci@gmail.com.com");
		System.out.println(test);

		test = new Email("compsci+100@gmail.com");
		System.out.println(test);

		test = new Email("compsci-100@yahoo-test.com");
		System.out.println(test);

		test = new Email("#!$%&'*+-/=?^_'{}|~@example.org");
		System.out.println(test);

		/*
			compsci
			compsci@.com.my
			compsci123@gmail.a
			compsci123@.com
			compsci123@.com.com
			.compsci@compsci.com
			compsci()*@gmail.com
			compsci@%*.com
			compsci..2002@gmail.com
			compsci.@gmail.com
			compsci@compsci@gmail.com
			compsci@gmail.com.1a
			compsci@hotmail.com
			compsci-100@yahoo.com
			compsci.100@hotmail.com
			compsci111@compsci.com
			compsci-100@compsci.net
			compsci.100@compsci.com.au
			compsci@1.com
			compsci@gmail.com.com
			compsci+100@gmail.com
			compsci-100@yahoo-test.com
			#!$%&'*+-/=?^_'{}|~@example.org
		 */
	}
}