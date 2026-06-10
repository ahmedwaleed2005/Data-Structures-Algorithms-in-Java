public class MyStack <T>{

    private final int MAX_SIZE = 100 ;
    private int top = -1 ;
    @SuppressWarnings("unchecked")
    private T [] arr =(T[]) new Object [MAX_SIZE] ;

    public boolean isEmpty(){
        return top == -1 ;
    }

    public boolean isFull(){
        return top >= MAX_SIZE - 1 ;
    }

    public T getTop(){
        if(isEmpty()){
            System.out.println("The Stack Is Empty ..!");
            return null ;
        }
        return arr[top] ;
    }

    public void push(T val){
        if(val == null)     return ;
        if(isFull()){
            System.out.println("The Stack Is Full ..!");
            return ;
        }

        top ++ ;
        arr[top] = val ;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("The Stack Is Empty ..!");
            return null ;
        }

        T x = arr[top] ;
        top-- ;
        return x ;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("The Stack Is Empty ..!");
            return  ;
        }

        for(int i=top ; i>=0 ; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
