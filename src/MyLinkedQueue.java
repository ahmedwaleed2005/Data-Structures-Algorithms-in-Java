public class MyLinkedQueue <T>{

   class Node{
        T val ;
        Node next ;

        Node(T val){
            this.val = val ;
        }
    }

    private Node front; 
    private Node back ;
    private int size = 0 ;

    public boolean isEmpty(){
        return front == null  ;
    }

    public void enQueue(T val){
        if(val == null)     return ;
        Node newNode = new Node(val);
        if(isEmpty()){
            front = back = newNode ;
            size ++ ;
            return ;
        }

        back.next = newNode ;
        back = newNode ;
        size ++ ;
    }

    public T deQueue(){
        if(isEmpty()){
            System.out.println("The Queue Is Empty");
            return null ;
        }

        T x = front.val ;

        if(front.next == null){
            front = back = null ;
            size -- ;
            return x ;
        }

        front = front.next  ;
            size -- ;
            return x ;
    }

    public int size(){
        return size ;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("The Queue Is Empty");
            return  ;
        }

        Node current = front ;

        System.out.print("[ ");
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next ;
        }
        System.out.println();
    }
}
