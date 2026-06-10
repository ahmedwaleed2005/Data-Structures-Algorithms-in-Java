public class Search {

    public static int LinerSearch(int [] arr , int item){
        int len = arr.length ;
        for(int i=0 ; i<len ; i++){
            if(arr[i] == item)
                return i ;
        }
        return -1 ;
    }

    public static int BinarySearch(int [] arr , int item){
        int first = 0 , last = arr.length - 1  ;

        while(first <= last){
           int middle = (first + last) / 2 ;
            if(item == arr[middle])
                return middle ;
            else if(item < arr[middle])
                last = middle - 1 ;
            else 
                first = middle + 1 ;
        }

        return -1 ;
    }



}
