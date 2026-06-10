public class Sorting{

    public static void Bubble(int [] arr){
        int len = arr.length ;
        boolean isSorted = true ;
        for(int i=0 ; i<len ; i++){
            for(int j=i+1 ; j<len ; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i] ;
                    arr[i] = arr[j] ;
                    arr[j] = temp ;
                    isSorted = false ;
                }}
                if(isSorted){
                    break ;}
            }
            }

    public static void Selection(int [] arr){
        int len = arr.length ;
        int min ;
        for(int i=0 ; i<len-1 ; i++){
            min = i ;
            for(int j=i+1 ; j<len ; j++){
                if(arr[j] < arr[min])
                    min = j ;
            }
                      int temp = arr[min] ; 
                      arr[min] = arr[i];
                      arr[i] = temp ;
        }
            }

     public static void Insertion(int [] arr){
        int len = arr.length ;

        for(int i=1 ; i<len ; i++){
            int val = arr[i] ;
            int j = i-1 ;

            while (j >= 0 && val < arr[j]) {
                arr[j+1] = arr[j] ;
                j-- ;  
            }
            arr[j+1] = val;
        }
     }

     

    
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

       
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

  
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr; 

        int mid = arr.length / 2;

        
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        left = mergeSort(left);
        right = mergeSort(right);

       
        return merge(left, right);
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; 
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        
        int temp = pivot;
        arr[i+1] = pivot;
        arr[i +1] = temp;

        return i +1 ;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    

   


}
