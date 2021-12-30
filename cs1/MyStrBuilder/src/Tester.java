import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Tester {
    private static String getString(char[] data) {
        StringBuilder chars = new StringBuilder();
        for (char ch : data) {
            if (ch == '\u0000') break;
            chars.append(ch);
        }
        return chars.toString();
    }

    @Test
    public void test() {
        MyStrBuilder demo = new MyStrBuilder(2); // capacity of 2
        assertEquals(0, demo.length());
        assertEquals(2, demo.capacity());
        assertEquals("", getString(demo.getData()));
    }

    @Test
    public void testAppends() {
        MyStrBuilder demo = new MyStrBuilder(2);
        demo.append(Integer.MIN_VALUE);
        assertEquals(11, demo.length());
        assertEquals(14, demo.capacity());
        assertEquals("-2147483648", getString(demo.getData()));

        demo = new MyStrBuilder(2);
        demo.append(Integer.MAX_VALUE);
        assertEquals(10, demo.length());
        assertEquals(14, demo.capacity());
        assertEquals("2147483647", getString(demo.getData()));

        demo = new MyStrBuilder(2);
        demo.append(-5);
        assertEquals(2, demo.length());
        assertEquals(2, demo.capacity());
        assertEquals("-5", getString(demo.getData()));

        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        assertEquals(4, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("Java", getString(msb.getData()));

        msb.append(' ');
        assertEquals(5, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("Java ", getString(msb.getData()));

        msb.append(16);
        assertEquals(7, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("Java 16", getString(msb.getData()));

        msb.append(" is the latest version".toCharArray());
        assertEquals(29, msb.length());
        assertEquals(34, msb.capacity());
        assertEquals("Java 16 is the latest version", getString(msb.getData()));

        msb = new MyStrBuilder(4);
        msb.append("Java".toCharArray());
        msb.append('c');
        assertEquals(5, msb.length());
        assertEquals(10, msb.capacity());
        assertEquals("Javac", getString(msb.getData()));
    }

    @Test
    public void testCharAt() {
        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        assertEquals('J', msb.charAt(0));
    }

    @Test
    public void testSubstring() {
        MyStrBuilder msb = new MyStrBuilder(4);
        msb.append("Java".toCharArray());

        // substring two arguments
        MyStrBuilder msbSub = msb.substring(1, 3);
        assertEquals(2, msbSub.length());
        assertEquals(18, msbSub.capacity());
        assertEquals("av", getString(msbSub.getData()));

        // don't modify current buffer
        assertEquals(4, msb.length());
        assertEquals(4, msb.capacity());
        assertEquals("Java", getString(msb.getData()));

        // substring one argument
        msbSub = msb.substring(1);
        assertEquals(3, msbSub.length());
        assertEquals(19, msbSub.capacity());
        assertEquals("ava", getString(msbSub.getData()));

        msbSub = msb.substring(4);
        assertEquals(0, msbSub.length());
        assertEquals(16, msbSub.capacity());
        assertEquals("", getString(msbSub.getData()));

        msbSub = msb.substring(3);
        assertEquals(1, msbSub.length());
        assertEquals(17, msbSub.capacity());
        assertEquals("a", getString(msbSub.getData()));

        // don't modify current buffer
        assertEquals(4, msb.length());
        assertEquals(4, msb.capacity());
        assertEquals("Java", getString(msb.getData()));
    }

    @Test
    public void testLower() {
        MyStrBuilder msb = new MyStrBuilder(10);
        msb.append("Java".toCharArray());
        MyStrBuilder msbLower = msb.toLowerCase();
        assertEquals(4, msbLower.length());
        assertEquals(20, msbLower.capacity());
        assertEquals("java", getString(msbLower.getData()));

        // don't modify current buffer
        assertEquals(4, msb.length());
        assertEquals(10, msb.capacity());
        assertEquals("Java", getString(msb.getData()));

        // test other
        msb = new MyStrBuilder(8);
        msb.append("jAvA Zz!".toCharArray());
        msbLower = msb.toLowerCase();
        assertEquals(8, msbLower.length());
        assertEquals(24, msbLower.capacity());
        assertEquals("java zz!", getString(msbLower.getData()));
    }

    @Test
    public void testUpper() {
        MyStrBuilder msb = new MyStrBuilder(10);
        msb.append("Java".toCharArray());
        MyStrBuilder msbUpper = msb.toUpperCase();
        assertEquals(4, msbUpper.length());
        assertEquals(20, msbUpper.capacity());
        assertEquals("JAVA", getString(msbUpper.getData()));

        // don't modify current buffer
        assertEquals(4, msb.length());
        assertEquals(10, msb.capacity());
        assertEquals("Java", getString(msb.getData()));
    }

    @Test
    public void testEquality() {
        MyStrBuilder msb1 = new MyStrBuilder();
        msb1.append("Java".toCharArray());
        MyStrBuilder msb2 = new MyStrBuilder(10);
        msb2.append("Java".toCharArray());
        assertEquals(msb1, msb2);
        msb1.append(4);
        assertNotEquals(msb1, msb2);
    }

    @Test
    public void testIndex() {
        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        assertEquals(1, msb.indexOf('a'));
        assertEquals(0, msb.indexOf('J'));
        assertEquals(-1, msb.indexOf('b'));
    }

    @Test
    public void testReverse() {
        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        msb.reverse();
        assertEquals("avaJ", getString(msb.getData()));

        msb = new MyStrBuilder();
        msb.append("J".toCharArray());
        msb.reverse();
        assertEquals(1, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("J", getString(msb.getData()));
    }

    @Test
    public void testInsert() {
        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        msb.insert(1, 'J');
        assertEquals(5, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("JJava", getString(msb.getData()));

        msb = new MyStrBuilder();
        msb.append("Know power".toCharArray());
        msb.insert(4, "ledge is".toCharArray());
        assertEquals(18, msb.length());
        assertEquals(34, msb.capacity());
        assertEquals("Knowledge is power", getString(msb.getData()));
    }

    @Test
    public void testDelete() {
        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        msb.delete(2);
        assertEquals(3, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("Jaa", getString(msb.getData()));

        msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        msb.delete(0);
        assertEquals(3, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("ava", getString(msb.getData()));

        msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        msb.delete(1, 4);
        assertEquals(1, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("J", getString(msb.getData()));
    }

    @Test
    public void testReplace() {
        MyStrBuilder msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        msb.replace(0, "Java'd. ".toCharArray());
        assertEquals(8, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("Java'd. ", getString(msb.getData()));

        msb = new MyStrBuilder();
        msb.append("Java".toCharArray());
        msb.replace(2, "Java'd. ".toCharArray());
        assertEquals(10, msb.length());
        assertEquals(16, msb.capacity());
        assertEquals("JaJava'd. ", getString(msb.getData()));
    }
}