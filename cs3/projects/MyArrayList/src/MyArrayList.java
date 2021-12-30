import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    private int size;       // the number of elements stored
    E[] ary;                // access modifier is package protected for testing purposes

    public MyArrayList() {    // start with a threshold/capacity of 10
        size = 0;
        ary = (E[]) new Object[10];
    }

    public boolean isEmpty() {	// is the list empty?
        return size == 0;
    }

    public int size() {         // the number of elements in the list
        return size;
    }

    // add the item to the end unless it's null and throw a NoSuchElementException
    public void add(E item) {
        if (item == null) {
            throw new java.util.NoSuchElementException();
        }
        if (size + 1 > ary.length) {
            E[] temp = (E[]) new Object[ary.length * 2];
            System.arraycopy(ary, 0, temp, 0, ary.length);
            ary = (E[]) new Object[temp.length];
            System.arraycopy(temp, 0, ary, 0, temp.length);
        }
        ary[size++] = item;
    }

    // add the item at the specified index
    // throw a NoSuchElementException if item is null
    // throw an IndexOutOfBounds exception if the index is invalid
    public void add(E item, int index) {
        if (item == null) {
            throw new java.util.NoSuchElementException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        size++;
        if (size > ary.length) {
            E[] temp = (E[]) new Object[ary.length * 2];
            // copy from the original. elements to the left of the desired index
            System.arraycopy(ary, 0, temp, 0, index);
            // add the new one
            temp[index] = item;
            // add to the right
            for (int i = index + 1; i < size; i++) {
                temp[i] = ary[i - 1];
            }
            // copy it back over
            ary = (E[]) new Object[temp.length];
            System.arraycopy(temp, 0, ary, 0, temp.length);
        }
        else {
            for (int i = size - 1; i > index; i--) {
                ary[i] = ary[i - 1];
            }
            ary[index] = item;
        }
    }

    // remove and return the item at the index
    // throw an IndexOutOfBounds exception if the index is invalid
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E item = ary[index];
        // shift over to the left to remove. the last item is excluded or turned to null
        for (int i = index; i < size - 1; i++) {
            ary[i] = ary[i + 1];
        }
        if (size - 1 <= ary.length / 4) { // reaches 25%
            E[] temp = (E[]) new Object[ary.length / 2];
            System.arraycopy(ary, 0, temp, 0, size - 1); // excluded because size was reduced earlier
            ary = (E[]) new Object[temp.length];
            System.arraycopy(temp, 0, ary, 0, temp.length);
        }
        else {
            ary[size - 1] = null;
        }
        size--;
        return item;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return ary[index];
    }

    public void clear() {
        size = 0;
        ary = (E[]) new Object[10];
    }

    public E[] getAry() {
        return ary;
    }

    @Override
    public Iterator<E> iterator() {         // return an iterator over items in order
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        //private int spot = -1;
        private int spot = 0;

        @Override
        public boolean hasNext() {
            //return spot < size() - 1;
            return spot < size();
        }

        @Override
        public void remove() {
            // shift over to the left to remove. the last item is excluded or turned to null
            for (int i = spot - 1; i < size - 1; i++) {
                ary[i] = ary[i + 1];
            }
            if (size - 1 <= ary.length / 4) { // reaches 25%
                E[] temp = (E[]) new Object[ary.length / 2];
                System.arraycopy(ary, 0, temp, 0, size - 1); // excluded because size was reduced earlier
                ary = (E[]) new Object[temp.length];
                System.arraycopy(temp, 0, ary, 0, temp.length);
            }
            else {
                ary[size - 1] = null;
            }
            // if testing with try catch, size and spot shouldn't be updated if it fails prematurely
            size--;
            spot--;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            //return ary[++spot];
            return ary[spot++];
        }
    }

    // basic test cases
    // try adding your own thru JUnit
    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<>();
        test.add("Love");
        test.add("I", 0);
        test.add("Computer");
        test.add("Science");
        System.out.println(test.size());
        for (String item : test) { // uses the Itr class
            System.out.println(item);
        }
        test.remove(test.size() - 1);
        test.remove(2);
        test.remove(0);
        for (String item : test) {
            System.out.println(item);
        }

        test.remove(test.size() - 1);
        test.add("Iterators");
        test.add("Rock");
        for (String item : test) {
            System.out.println(item);
        }

        test.clear();

        System.out.println("After clearing, size is: " + test.size());
        for (int i = 0; i < 10; i++) {
            test.add("" + i);
        }

        Iterator<String> it = test.iterator();
        for (; it.hasNext();) {
            System.out.print(it.next() + " ");
        }

        try {
            it.next();
        } catch (Exception e) {
            System.out.println("\nNo more elements to iterate");
        }

        test.clear();
        it = test.iterator();
        for (int i = 0; i < 10; i++) {
            test.add("" + i);
        }
        it.next();
        it.remove();
        it.next();
        it.next();
        it.next();
        it.remove();
        System.out.println("" + java.util.Arrays.toString(test.ary));

        long start = System.currentTimeMillis();
        for (int i = 0; i < 2621440; i++) {
            test.add("how fast?");
        }
        for (int i = 0; i < 1310730; i++) {
            test.remove(test.size() - 1);
        }
        for (int j = 0; j < 1E8; j++) {
            for (int i = 0; i < 10; i++) {
                test.add("how fast?");
            }
            for (int i = 0; i < 10; i++) {
                test.remove(test.size() - 1);
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("My ArrayList: " + (stop - start) / 1000.0);

        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < 2621440; i++) {
            list.add("how fast?");
        }
        for (int i = 0; i < 1310730; i++) {
            list.remove(list.size() - 1);
        }
        for (int j = 0; j < 1E8; j++) {
            for (int i = 0; i < 10; i++) {
                list.add("how fast?");
            }
            for (int i = 0; i < 10; i++) {
                list.remove(list.size() - 1);
            }
        }
        stop = System.currentTimeMillis();
        System.out.println("Java's ArrayList: " + (stop - start) / 1000.0);
    }
}
