// Description: MyStrBuilder is a representation of a String, which are character arrays.

public class MyStrBuilder {
    private char[] data; // the character array
    private int size; // length of the string up to the first null character

    public MyStrBuilder() { // default constructor
        data = new char[16];
        size = 0;
    }

    public MyStrBuilder(int capacity) { // second constructor
        data = new char[capacity];
        size = 0;
    }

    public MyStrBuilder(char[] chars) { // third constructor
        data = new char[chars.length + 16]; // 16 empty elements trailing array
        System.arraycopy(chars, 0, data, 0, chars.length);
        size = getFilled(chars); // update size
    }

    // Appends a single character to the string sequence.
    public void append(char c) {
        if (data[data.length - 1] != '\u0000') { // last element is filled (full), increase capacity once
            int capacity = data.length * 2 + 2;
            char[] old = data;
            data = new char[capacity];
            System.arraycopy(old, 0, data, 0, old.length);
        }
        data[getFilled(data)] = c;
        size++; // increase length by 1, 1 character
    }

    // Appends a number to the string sequence.
    public void append(int n) {
        int digits = getDigits(n); // get length of the number

        size += digits;

        int filled = getFilled(data);
        int c = calculateCapacity(filled + digits);

        char[] old = data;
        data = new char[c];
        int index;
        for (index = 0; index < old.length; index++) { // copy over old data
            data[index] = old[index];
        }

        long l = n; // for the exception if it's Integer.MIN_VALUE. needs to be Long if multiplied by -1
        if (l < 0) {
            l *= -1;
            data[filled] = '-';
        }
        index = filled + digits - 1; // inclusive or something
        do {
            long end = l % 10; // chop off digits from end means adding it from the back
            data[index--] = (char) (end + 48); // numbers are just +48 for ASCII
            l /= 10; // chop off digits from back
        }
        while (l != 0); // if added number is 0, still do it once
    }

    // change capacity according to the desired number and current filled, can be multiple times
    private int calculateCapacity(int goal) {
        int c = capacity();
        while (c < goal) {
            c = c * 2 + 2;
        }
        return c;
    }

    // returns the number of digits in a number for the above append method. the negative symbol counts
    private int getDigits(int num) {
        int digits = 0;
        if (num < 0) {
            num *= -1;
            digits++; // negative counts as a digit
        }

        do {
            num /= 10; // chop off numbers from the end
            digits++;
        }
        while (num != 0); // if number is 0, it's 1 digit still

        return digits;
    }

    // Appends the entire character array to the string sequence.
    public void append(char[] chars) {
        int filled = getFilled(data);
        int c = calculateCapacity(filled + chars.length);
        char[] old = data;
        data = new char[c];
        int index;
        for (index = 0; index < old.length; index++) { // copy over old data
            data[index] = old[index];
        }
        index = filled;
        for (char aChar : chars) { // copy over new data
            data[index++] = aChar;
        }

        size += getFilled(chars);
    }

    // returns the number of non null characters
    private int getFilled(char[] chars) {
        int filled = 0;
        for (char ch: chars) {
            if (ch != '\u0000') filled++;
        }
        return filled;
    }

    // Returns the character at the provided index of the character array
    public char charAt(int i) {
        if (i < 0 | i >= data.length) {
            throw new StringIndexOutOfBoundsException();
        }
        return data[i];
    }

    // Returns the length of the array, entire capacity
    public int capacity() {
        return data.length;
    }

    // Returns the length of the string sequence up to the first null character
    public int length() {
        return size;
    }

    // Returns the character array
    public char[] getData() {
        return data;
    }

    // Returns a MyStrBuilder portion of the current one
    public MyStrBuilder substring(int begin, int end) {
        if (begin < 0 || end > size || begin > end) {
            throw new StringIndexOutOfBoundsException();
        }
        int index = 0;
        char[] sub = new char[end - begin];
        for (int i = begin; i < end; i++) { // create the substring: inclusive exclusive
            sub[index++] = data[i];
        }
        return new MyStrBuilder(sub); // return the substring with capacity as its length + 16
    }

    // Returns a MyStrBuilder portion of the current one, provided beginning index to the end of the string
    public MyStrBuilder substring(int begin) {
        if (begin < 0 || begin > size) {
            throw new StringIndexOutOfBoundsException();
        }
        int index = 0;
        char[] sub = new char[data.length - begin];
        for (int i = begin; i < data.length; i++) { // create the substring from start to the end of data
            sub[index++] = data[i];
        }
        return new MyStrBuilder(sub); // return the substring with capacity as its length + 16
    }

    // Returns a MyStrBuilder where everything is converted to lowercase.
    public MyStrBuilder toLowerCase() {
        MyStrBuilder lower = new MyStrBuilder(size + 16);
        char[] temp = new char[capacity()];
        System.arraycopy(data, 0, temp, 0, data.length);
        for (int i = 0; i < temp.length; i++) {
            char c = temp[i];
            // ASCII
            if (c >= 65 && c <= 90) { // only uppercase letters are lowered. others left unchanged
                c += 32;
            }
            temp[i] = c;
        }
        lower.append(temp);
        return lower;
    }

    // Returns a MyStrBuilder where everything is converted to uppercase.
    public MyStrBuilder toUpperCase() {
        MyStrBuilder upper = new MyStrBuilder(size + 16);
        char[] temp = new char[capacity()];
        System.arraycopy(data, 0, temp, 0, data.length);
        for (int i = 0; i < temp.length; i++) {
            char c = temp[i];
            // ASCII
            if (c >= 97 && c <= 122) { // only lowercase letters are upper. others left unchanged
                c -= 32;
            }
            temp[i] = c;
        }
        upper.append(temp);
        return upper;
    }

    // Returns if the two string sequences have the same characters at the same places
    public boolean equals(Object obj) {
        MyStrBuilder other = (MyStrBuilder) obj;
        if (length() == other.length()) {
            int min = Math.min(capacity(), other.capacity()); // capacity is irrelevant.
            // however, stay in bounds
            for (int i = 0; i < min; i++) {
                if (data[i] != other.getData()[i]) { // do not equal if find a non matching character
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // returns the first index of the found character
    public int indexOf(char c) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c) {
                return i; // returns the first index found
            }
        }
        return -1;
    }

    // Reverses the string sequence
    public void reverse() {
        char[] old = data;
        data = new char[capacity()];
        int index = 0; // fills from left to right
        for (int i = getFilled(old) - 1; i >= 0; i--) { // go from the back
            data[index++] = old[i];
        }
    }

    // Inserts a single character into the string sequence
    public void insert(int offset, char c) {
        if (offset < 0 || offset > size) {
            throw new StringIndexOutOfBoundsException();
        }

        int capacity = capacity();
        if (data[data.length - 1] != '\u0000') { // last element is filled (full). adjust once
            capacity = data.length * 2 + 2;
        }
        char[] old = data;
        data = new char[capacity];
        int index = 0;
        for (int i = 0; i < offset; i++) { // copy over old data
            data[index++] = old[i];
        }
        data[index++] = c; // insert
        for (int i = offset; i < getFilled(old); i++) { // copy over rest of old data
            data[index++] = old[i];
        }

        size++;
    }

    // Inserts an array of characters into the string sequence
    public void insert(int offset, char[] chars) {
        if (offset < 0 || offset > size) {
            throw new StringIndexOutOfBoundsException();
        }
        int filled = getFilled(data);
        int c = calculateCapacity(filled + chars.length);
        char[] old = data;
        data = new char[c];

        int index = 0;
        for (int i = 0; i < offset; i++) { // copy over old data
            data[index++] = old[i];
        }
        for (char value : chars) { // insert
            data[index++] = value;
        }
        for (int i = offset; i < old.length; i++) { // copy over rest of old data
            data[index++] = old[i];
        }

        size = getFilled(data);
    }

    // EXTRA CREDIT

    // Deletes a portion of the string sequence
    public void delete(int start, int end) {
        if (start < 0 || end > size || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        char[] old = data;
        data = new char[capacity()];
        // instead of creating new arrays and merging, just copy over the ones that don't need to be deleted
        int index = 0;
        for (int i = 0; i < old.length; i++) {
            if (i < start || i >= end) {
                data[index++] = old[i];
            }
        }
        size = getFilled(data);
    }

    // Deletes a character of the string sequence by shifting
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new StringIndexOutOfBoundsException();
        }
        for (int i = index + 1; i < data.length; i++) { // simple shifting
            data[i - 1] = data[i]; // @TODO
        }
        size--;
    }

    // Replaces the string sequence, starting from the provided index, with the provided character array
    public void replace(int start, char[] chars) {
        if (start < 0 || start > size) {
            throw new StringIndexOutOfBoundsException();
        }

        int filled = getFilled(data);
        int c = calculateCapacity(filled + chars.length);

        char[] old = data;
        data = new char[c];
        int index;
        for (index = 0; index < start; index++) { // copy over old data
            data[index] = old[index];
        }
        for (char aChar : chars) { // starting from the index, just copy over new data
            data[index++] = aChar;
        }

        size = getFilled(data);
    }
}