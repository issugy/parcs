package org.example;

import parcs.AM;
import parcs.AMInfo;

public class ShellSort implements AM {
    public void run(AMInfo info) {
        int[] array = {22, 7, 2, -5, 8, 4};
        System.out.println("Unsorted array: ");
        printArray(array);

        shellSort(array);

        System.out.println("Sorted array: ");
        printArray(array);
    }

    public static void shellSort(int[] array) {
        int n = array.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i += 1) {
                // add array[i] to the elements that have been gap sorted
                // save array[i] in temp and make a hole at position i
                int temp = array[i];

                // shift earlier gap-sorted elements up until the correct location for array[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }

                // put temp (the original array[i]) in its correct location
                array[j] = temp;
            }
        }
    }

    private void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
