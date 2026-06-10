public class MyMap <T , E>{
    @SuppressWarnings("unchecked")
    private T[] keys = (T[])new Object[100];
    @SuppressWarnings("unchecked")
    private E[] values = (E[])new Object[100];
    private int size = 0;

    public void put(T k, E v) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)) {
                values[i] = v;
                return;
            }
        }
        keys[size] = k;
        values[size] = v;
        size++;
    }

    public E get(T k) {
        for (int i = 0; i < size; i++)
            if (keys[i] == k)
                return values[i];
        return null;
    }

    public void remove(T k) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(k)) {
                keys[i] = keys[size - 1];
                values[i] = values[size - 1];
                size--;
                return;
            }
        }
    }
}
