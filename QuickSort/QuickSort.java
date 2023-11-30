import java.util.Scanner;

/**
 * QuickSort
 */
public class QuickSort {

    static int  partition(String arr[], int left, int right){
        int pivot = right;
        int i = -1;
        int j = 0;
        String temp;
        while(j < pivot){
            if(arr[j].compareTo(arr[pivot]) <= 0){
                i++;
                if(i != j){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            j++;
        }
        i++;
        temp = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = temp;  
       return i;
    }

    static String[] quickSort(String arr[], int left, int right){
        try{
            if(left < right){
                int pivotIndex = partition(arr, left, right );
                quickSort(arr, left,pivotIndex-1);  //Sorting the left 
                quickSort(arr, pivotIndex+1, right); //Sorting the right
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return arr;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array:");
        int length = sc.nextInt();

        String arr[] = new String[length];
        //Entering the values

        System.out.println("Start entering the values of the array...");
        for(int i=0;i<length;i++){
            arr[i] = sc.nextLine();
        }

        arr = quickSort(arr,0, length-1);

    //Printing the array..
    System.out.println("The array after sorting is...");

    for(int i=0;i<length;i++){
        System.out.print(arr[i]+ " ");
    }


    }
    
}