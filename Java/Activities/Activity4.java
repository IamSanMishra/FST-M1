package activities;

import java.util.Arrays;


public class Activity4 {

	public static void main(String[] args) {
		int[] data = { 9, 5, 1, 4, 3, 7, 8, 2, 6 };
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));

	}
	
	static void ascendingSort(int array[]) {
        int size = array.length;
        int i;
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }

}
