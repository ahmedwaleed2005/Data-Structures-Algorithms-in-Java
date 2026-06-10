public class MyCirclerLinkedList <T>{

    class Node{
        T item ; 
        Node next ;
        public Node(T item) {
            this.item = item;
        } 
            }

    private Node first ;
    private int size = 0 ;
    private Node last ;

    public boolean isEmpty(){
        return size == 0 ;
    }

    public int getSize(){
        return size ;
    }

    public void addFirst(T val){
        if(val == null)     return ;
    Node newNode = new Node(val);
    if(isEmpty()){
        first = last = newNode ;
         newNode.next = newNode;
        size ++ ;
        return ;
    }

    newNode.next = first ;
    first = newNode ;
    last.next = first ;
    size ++ ;
}
    public void addLast(T val){
        if(val == null)     return ;
        Node newNode = new Node(val);
        if(isEmpty()){
            first = last = newNode ;
            size ++ ;
            return ;
            
        }

    last.next = newNode ;
    newNode.next = first ;
    last = newNode ;
    size ++ ;
    }

   public void add(T val , int pos){
    if(val == null)     return ;
    Node newNode = new Node(val);

    if(pos < 0 || pos > size){
        System.out.println("Out Of range ..!");
        return ;
    }else if(pos == 0){
        addFirst(val);
        return ;
    }else if(pos == size){
        addLast(val);
        return ;
    }
    Node current = first ;
    for(int i=0 ; i<pos-1 ; i++){
        current = current.next ;
    }
    newNode.next = current.next ;
    current.next = newNode ;

    size++ ;
}

public void print(){
    if (isEmpty()) {
    System.out.println("List is empty");
    return;
}
    Node flag = first ;

    while(flag.next != first){
        System.out.print(flag.item + "  ");
        flag = flag.next ;
    }
    System.out.println(flag.item);
}

public T getFirst(){
    if (isEmpty()) {
    System.out.println("List is empty");
    return null;
}
    return first.item;
}

public T getLast(){
    if (isEmpty()) {
    System.out.println("List is empty");
    return null;
}
    return last.item;
}

public void removeFirst() {
    if (isEmpty()) {
        System.out.println("The linkedlist is empty ..!");
        return;
    }
    if (first == last) {
        first = last = null;
    } else {
        first = first.next;
        last.next = first ;
    }
    size--;
}

public void removeLast(){
    if(isEmpty()){
        System.out.println("The linkedlist is empty ..!");
        return ;
    }

    if(first == last){
        first = last = null ;
        size -- ;
        return ;
    }

    Node current = first , parent = first;
    
   while(current.next != first) {
        parent = current;
        current = current.next;
    }

    parent.next = first; 
    last = parent;       
    size -- ;
}

public void remove(int pos){
    if(pos < 0 || pos >= size){
        System.out.println("Out of range ..!");
        return ;
    }else if(pos == 0){
        removeFirst();
        return ;
    }else if(pos == size -1){
        removeLast(); 
        return ;
    }
    Node current = first ;
    Node prev = null ;

    for(int i=0 ; i<pos ; i++){
        prev = current ;
        current = current.next ;
    }
    prev.next = current.next ;
    size -- ;
}

public void removeElement(T val){
    int index = index(val);
    if(index == -1){
        System.out.println("This Element Not founded ..!");
        return ;
    }

    remove(index);
}

public boolean searche(T val){
    return (index(val) == -1) ? false : true ;
}

public int index(T val){
    if(val == null)     return -1;
    if(isEmpty()){
        System.out.println("The linkedlist is empty ..!");
        return -1;
    }
    Node current = first ;
    int i = 0 ;
    if(last.item.equals(val))       return size-1 ;
    while(current.next != first){
        if(current.item.equals(val))
            return i ;

        current = current.next ;
        i++ ;
            }
    return -1 ;
}




}
