package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        int[] array = {2,4,5,1,0,9,14,7};
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int start, int end) {
        if(start >= end) 
            return ;

        int partitionIndex = partition(array, start, end);
        quickSort(array, start, partitionIndex-1);
        quickSort(array, partitionIndex+1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int partitionIndex = start;
        for(int i=start;i<end;i++) {
            if(array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[partitionIndex];
                array[partitionIndex] = temp;
                partitionIndex++;
            }
        }
        int temp = array[end];
        array[end] = array[partitionIndex];
        array[partitionIndex] = temp;
        return partitionIndex;
    }
}