public class MyLinkedList <T>{

private class Node{
    T item ; 
    Node  next ;
    public Node(T item) {
        this.item = item;
    } 
}

private Node first ;
private int size = 0 ;
private Node last ;

public boolean isEmpty(){
    return size == 0 ; // or returen frist == null && last == null
}

public int getSize(){
    return size ;
}

public void addFirst(T val){
    if(val == null)     return ;
    Node newNode = new Node(val);
    if(isEmpty()){
        first = last = newNode ;
        size ++ ;
        return ;
    }

    newNode.next = first ;
    first = newNode ;
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

    while(flag != null){
        System.out.print(flag.item + "  ");
        flag = flag.next ;
    }
    System.out.println();
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
    if (first.next == null) {
        first = last = null;
    } else {
        first = first.next;
    }
    size--;
}


public void removeLast(){
    if(isEmpty()){
        System.out.println("The linkedlist is empty ..!");
        return ;
    }

    if(first.next == null){
        first = last = null ;
        size -- ;
        return ;
    }

    Node current = first , parent = first;
    
    while (current.next != null) {
        parent = current ;
        current = current.next ;
    }

    parent.next = null ;
    last = parent ;
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
    Node prev = first;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
}

public void removeElement(T val){
    if(val == null)     return ;
    int index = index(val);
    if(index == -1){
        System.out.println("This Element Not founded ..!");
        return ;
    }

    remove(index);
}


public boolean searche(T val){
    if(val == null)     return false;
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
    while (current != null) {
        if(current.item.equals(val))
            return i ;
        current = current.next ;
         i++ ;
    }

    return -1 ;
}

public void reverse (){
    if(size <= 1){
        System.out.println("Can't Reverse");
        return ;
    }

    Node current = first , next , prev=null ;

    while(current != null){
        next = current.next ;
        current.next = prev ;
        prev = current ;
        current = next ;
    }
    last = first;
    first = prev ;
}
}
