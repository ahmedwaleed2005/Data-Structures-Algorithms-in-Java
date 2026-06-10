public class MyLinkedStack <T>{

    class Node{
        T val ;
        Node next ;

        Node(T val){
            this.val = val ;
        }
    }

    private Node top ;
    private int size = 0 ;

    public boolean isEmpty(){
        return size == 0 ;
    }

    public T getTop(){
        if(isEmpty()){
            System.out.println("The Stack Is Empty ..!");
            return null ;
        }
        return top.val ;
    }

    public void push(T data){
        if(data == null)        return ;
        Node newNode = new Node(data);
        if(isEmpty()){
            top = newNode ;
            size++ ;
            return ;
        }
        newNode.next = top ;
        top = newNode ;
        size ++ ;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("The Stack Is Empty ..!");
            return null ;
        }else if(size == 1){
           T x = top.val ;
            top = null ;
            size -- ;
            return x;
        }
         T x = top.val ;
        top = top.next ;
        size -- ;
        return x ;
    }

      public void print(){
        if(isEmpty()){
            System.out.println("The Stack Is Empty ..!");
            return  ;
        }

        Node current = top ;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next ;
        }
        System.out.println();
    }
}
