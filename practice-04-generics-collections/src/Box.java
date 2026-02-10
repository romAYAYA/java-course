public class Box<T> {
    private T val = null;

    public void put(T item) {
        val = item;
    }

    public T get() {
        return val;
    }

    public boolean isEmpty() {
        return val == null;
    }

    public void clear() {
        val = null;
    }
}
