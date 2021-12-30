public class GuitarString {
    public RingBuffer ringBuffer;
    private int tics;

    public GuitarString(double frequency) {
        ringBuffer = new RingBuffer(Math.ceil(Math.round(44100 / frequency)));
        while (!ringBuffer.isFull()) {
            ringBuffer.enqueue(0.0);
        }
        tics = 0;
    }

    public GuitarString(double[] init) {
        ringBuffer = new RingBuffer(init.length);
        for (double d: init) {
            ringBuffer.enqueue(d);
        }
        tics = 0;
    }

    public void pluck() {
        ringBuffer = new RingBuffer(ringBuffer.size());
        while (!ringBuffer.isFull()) {
            ringBuffer.enqueue(Math.random() - 0.5);
        }
        tics = 0; // TODO
    }

    public void tic() {
        double update = ringBuffer.dequeue() + ringBuffer.peek();
        update = 0.994 * (update/2);
        ringBuffer.enqueue(update);
        tics++;
    }

    public double sample() {
        return ringBuffer.peek();
    }

    public int time() {
        return tics;
    }
}
