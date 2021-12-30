// thanks kkakdugee
import java.util.NoSuchElementException;

public class RingBuffer {

    private double[] ringBuffer;
    private int size, first, last;

    public RingBuffer(int capacity) {
        ringBuffer = new double[capacity];
        size = 0;
        first = 0;
        last = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == ringBuffer.length;
    }

    public void enqueue(double x) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        ringBuffer[last] = x;
        last++;
        if (last == ringBuffer.length) {
            last = 0;
        }
        size++;
    }

    public double dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        double head = peek();
        ringBuffer[first] = 0.0;
        first++;
        if (first == ringBuffer.length) {
            first = 0;
        }
        size--;
        return head;
    }

    public double peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return ringBuffer[first];
    }

    public String toString() { // install stringbuffer lol
        if(isEmpty()) return "[]";
        String output = "[";
        if(first < last) {
            for(int i = first; i < last; i++) {
                output += ringBuffer[i] + ", ";
            }
        }
        else {
            for(int i = first; i < ringBuffer.length; i++) {
                output += ringBuffer[i] + ", ";
            }
            for(int i = 0; i < last; i++) {
                output += ringBuffer[i] + ", ";
            }
        }
        output = output.substring(0, output.length()-2);
        return output + "]";
    }
}
