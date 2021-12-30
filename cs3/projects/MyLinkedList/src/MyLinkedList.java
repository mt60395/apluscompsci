import java.util.AbstractList;

// A class that implements a doubly linked list
public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /**
     * Create a new empty LinkedList
     */
    public MyLinkedList() {
    }

    /**
     * Appends an element to the end of the list
     *
     * @param element The element to add
     */
    public boolean add(E element) {
        if (element == null) throw new NullPointerException();
        if (head == null && tail == null) {
            head = new LLNode<>(element);
            tail = head; // both point to same thing
        }
        else {
            LLNode<E> last = new LLNode<>(element);
            last.prev = tail;
            tail.next = last;
            tail = last;
        }
        size++;
        return true;
    }

    /**
     * Get the element at position index
     *
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getTracker(index).data;
    }

    /**
     * Gets the node at an index.
     * @param index
     * @return
     */
    private LLNode<E> getTracker(int index) {
        LLNode<E> tracker;
        int i;
        if (index <= size / 2) { // traverse forwards, traditionally
            tracker = head;
            i = 0;
            while (i < index) {
                tracker = tracker.next;
                i++;
            }
        }
        else { // traverse backwards
            tracker = tail;
            i = size - 1;
            while (i > index) {
                tracker = tracker.prev;
                i--;
            }
        }
        return tracker;
    }

    /**
     * Add an element to the list at the specified index
     *
     * @param index the index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) throw new NullPointerException();
        if (size == 0) { // priority, create new
            add(element);
        }
        else if (index == 0) { // add to the front, second priority
            // add to front
            LLNode<E> node = new LLNode<>(null, head, element);
            head.prev = node;
            head = node;
            size++;
        }
        else if (index == size) { // add to the end, second priority
            // size should be 0 and index should be 0, or add to the end
            add(element);
        }
        else { // add to the middle
            LLNode<E> tracker = getTracker(index);
            LLNode<E> middle = new LLNode<>(tracker.prev, tracker, element);
            tracker.prev.next = middle; // doubly linked nature
            tracker.prev = middle; // link this one too :(
            size++;
        }
    }

    /**
     * Return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Remove a node at the specified index and return its data element.
     *
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E temp;
        if (size == 1) { // remove entirety
            temp = head.data;
            head = tail = null;
            size--;
            return temp;
        }
        if (index == 0) { // remove front
            temp = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return temp;
        }
        else if (index == size - 1) { // remove back
            temp = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return temp;
        }
        LLNode<E> tracker = getTracker(index);
        temp = tracker.data;
        tracker.prev.next = tracker.next;
        tracker.next.prev = tracker.prev;
        size--;
        return temp;
    }

    /**
     * Set an index position in the list to a new element
     *
     * @param index   The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        getTracker(index).setData(element);
        return null;
    }

    public boolean has(E item) {
        LLNode<E> tracker = head;
        while (tracker != null) {
            if (tracker.data.equals(item)) {
                return true;
            }
            tracker = tracker.next;
        }
        return false;
    }

    public String toString() {
        if (head == null) return "[]";
        StringBuilder stringBuilder = new StringBuilder("[");
        LLNode<E> tracker = head;
        while (tracker != null) {
            stringBuilder.append(tracker.data).append(", ");
            tracker = tracker.next;
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("]").toString();
    }
}

class LLNode<E> {
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    public LLNode(E e) {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

    public LLNode(LLNode<E> prev, LLNode<E> next, E data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public void setData(E e) {
        this.data = e;
    }
}
