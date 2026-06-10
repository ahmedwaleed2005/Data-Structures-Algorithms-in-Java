public class Heap<T extends Comparable<T>>{

    private int size = 0;
    private int capacity;
    private T[] arr;

    @SuppressWarnings("unchecked")
    Heap(int capacity) {
        if (capacity <= 0)
            this.capacity = 10;
        else
            this.capacity = capacity;

        arr = (T[]) new Object[this.capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(T val) {
        if(val == null)     return ;
        arr[size] = val;
        int i = size;
        size++;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (arr[i].compareTo(arr[parent]) > 0) {
                T temp = arr[i];
                arr[i] = arr[parent];
                arr[parent] = temp;

                i = parent;
            } else
                break;
        }
    }

    public T max() {
        if (size == 0) {
            System.out.println("The Heap Is Empty");
            return null;
        }
        return arr[0];
    }

    public void deleteMax() {
        if (size == 0)
            return;

        arr[0] = arr[size - 1];
        size--;

        if (size > 0)
            percolateDown(0);
    }

    private void percolateDown(int root) {
        int child = 2 * root + 1;

        while (child < size) {
            if (child + 1 < size && arr[child].compareTo(arr[child + 1]) < 0)
                child++;

            if (arr[root].compareTo(arr[child]) < 0) {
                T temp = arr[root];
                arr[root] = arr[child];
                arr[child] = temp;

                root = child;
                child = 2 * root + 1;
            } else
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    public void heapSort() {
    int originalSize = size;      
    T[] sorted = (T[]) new Object[size]; 

    for (int i = size - 1; i >= 0; i--) {
        sorted[i] = max();   
        deleteMax();        
    }

    
    for (int i = 0; i < originalSize; i++) {
        arr[i] = sorted[i];
    }

    size = originalSize; 
}

}
