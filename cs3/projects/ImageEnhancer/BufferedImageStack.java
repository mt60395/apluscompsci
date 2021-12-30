/**
 * BufferedImageStack
 * Acts as the undo/redo stack for an image enhancer program.
 */
import java.awt.image.BufferedImage;

public class BufferedImageStack {
    private BufferedImage[] stack; // custom stack
    private int size; // keep track of amount of items
    public BufferedImageStack() {
        stack = new BufferedImage[2]; // creates a new stack with a length of 2
        size = 0;
    }

    /**
     * Adds a new image to either a redo or undo stack.
     * @param bImage the buffered image to add
     */
    public void push(BufferedImage bImage) {
        if (size + 1 > stack.length) { // resize if it gets full
            BufferedImage[] temp = new BufferedImage[stack.length * 2];
            System.arraycopy(stack, 0, temp, 0, stack.length);
            stack = new BufferedImage[temp.length];
            System.arraycopy(temp, 0, stack, 0, temp.length);
        }
        stack[size++] = bImage; // update the size and add the image
    }

    /**
     * Removes the most recent item from the stack.
     * @return the item removed, to display on the GUI
     */
    public BufferedImage pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        BufferedImage temp = stack[--size]; // store the image to remove it from the stack
        stack[size] = null; // remove the image, no need to update the length of the stack
        return temp;
    }

    /**
     * @return if the amount of items in the stack is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the item at the provided index.
     * @param index the position to return the item
     * @return the item at the position
     */
    public BufferedImage get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return stack[index];
    }

    /**
     * Used for finding the top item of the stack.
     * @return the amount of items in the stack
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Used to check for correct doubling of the stack's length.
     * @return the length of the stack
     */
    public int getArraySize() {
        return stack.length;
    }
}
