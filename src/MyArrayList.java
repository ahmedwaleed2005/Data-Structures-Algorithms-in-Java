public class MyArrayList <T>{

    private int size = 0;
    private T [] arr ;
    private int len = 10 ;
    
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        arr = (T[]) new Object [len] ;
    }

    @SuppressWarnings("unchecked")
    private void enlargeSize (){
        len = len + len / 2 ;
        T [] flag = (T[]) new Object [len] ;
        for (int i = 0; i < size; i++) {
         flag[i] = arr[i];
    }
        arr = flag ;
    }

    public boolean isEmpty(){
        return size == 0 ;
    }

     public boolean isFull(){
        return size == len ;
    }

    public int size(){
        return size ;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("The List Is Empty..!");
        }
        for(int i=0 ; i<size ; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void addFrist(T item){
        if(isFull()){
           enlargeSize () ;
        }
        for(int i=size ; i>=1 ; i--){
            arr[i] = arr[i-1] ; 
        }
        arr[0] = item ;
        size ++ ;
    }

    public void addLast(T item){
        if(isFull()){
           enlargeSize () ;
        }
        arr[size] = item ;
        size ++ ;
    }

    public void add(int pos , T item){
        if(pos < 0 || pos > size){
            System.out.println("posstion out of range..!");
            return ;
        }

        if(isFull()){
            enlargeSize () ;
        }

        for(int i=size ; i>pos-1 ; i--){ // <--- pos or pos-1
            arr[i] = arr[i-1];
        }
        arr[pos] = item ;
        size++ ;
    }

    public void deleteFrist(){
        if(isEmpty()){
            System.out.println("The list is Empty");
            return ;
        }
        for(int i=0 ; i<size-1 ; i++){
            arr[i] = arr[i +1] ;
        }
        arr[size-1] = null ;
        size -- ;
    }

    public void deleteLast(){
        if(isEmpty()){
            System.out.println("The list is Empty");
            return ;
        }
        arr[size-1] = null ;
        size -- ;
    }

    public void delete(int pos){
        if(isEmpty()){
            System.out.println("The list is Empty");
            return ;
        }
        else if(pos < 0 || pos > size-1){
            System.out.println("posstion out of range..!");
            return ;
        }
        for(int i=pos ; i<size-1 ; i++){
            arr[i] = arr[i+1];
        }
        size -- ;
    }

    public boolean searche(T item){
        if(isEmpty()){
            System.out.println("The list is Empty");
            return false ;
        }

        for(int i=0 ; i<size ; i++){
            if(item.equals(arr[i]))
                return true ;
        }
        return false ;
    }

    public int index(T item){
        if(isEmpty()){
            System.out.println("The list is Empty");
            return -1 ;
        }

        for(int i=0 ; i<size ; i++){
            if(item.equals(arr[i]))
                return i ;
        }
        return -1 ;
    }


    public void deleteItem(T item){
        if(! searche(item)){
            System.out.println("Item Not founded..!");
            return ;
        }
        int pos = index(item);
        delete(pos);
    }


    public void clear(){
        for(int i=0 ; i<size ; i++){
            arr[i] = null ;
        }
        size = 0 ;
    }

    public T get(int index){
        if(index < 0 || index >= size)
            return null ;

        return arr[index] ;
    }

    public void set(int index , T val){
        if(index < 0 || index > size)
            return  ;

        arr[index] = val ;
    }
    

}
