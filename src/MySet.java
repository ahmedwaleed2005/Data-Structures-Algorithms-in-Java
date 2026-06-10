public class MySet <T>{

    @SuppressWarnings("unchecked")
    private T[] arr = (T[])new Object[100];
    private int size = 0;

    public void add(T x) {
        if (contains(x)) return;
        arr[size++] = x;
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i++)
            if (arr[i].equals(x))
                return true;
        return false;
    }

    public void remove(T x) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == x) {
                arr[i] = arr[size - 1];
                size--;
                return;
            }
        }
    }
}
