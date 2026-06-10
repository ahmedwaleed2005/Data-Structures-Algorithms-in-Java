public class MyQueue <T>{

    private int size = 0 ;
    private final int MAX_SIZE = 10 ; 
    private int front = 0;
    private int back = 0;
    @SuppressWarnings("unchecked")
    private T [] arr = (T[]) new Object[MAX_SIZE];

    public boolean isEmpty(){
        return front == back ;
    }

    public boolean isFull(){
        return front == (back + 1)  % MAX_SIZE;
    }

    public void enQueue(T val){
        if(val == null)         return ;
        if(isFull()){
            System.out.println("The Queue Is Full");
            return ;
        }
        arr[back] = val ;
        back = (back+1) % MAX_SIZE ;
        size ++ ;
    }

    public T deQueue(){
        if(isEmpty()){
            System.out.println("The Queue Is Empty");
            return null ;
        }
        T x = arr[front] ;
        front = (front+1) % MAX_SIZE ;
        
        size -- ;
        return x ;
    }

    public int size(){
        return size ;
    }

   
    public void print() {
        if (isEmpty()) {
            System.out.println("The Queue Is Empty");
            return;
        }

        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % MAX_SIZE] + " ");
        }
        System.out.println("]");
    }
}