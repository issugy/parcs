package org.example;

import parcs.*;
import java.util.Arrays;

public class ShellSort implements AM {
    public void run(AMInfo info) {
        System.out.println("Reading from channel...");
        int[] array = (int[]) info.parent.readObject();

        System.out.println("Unsorted subarray (first 20 elements): ");
        printArray(array, 20);

        long startTime = System.currentTimeMillis();
        shellSort(array);
        long endTime = System.currentTimeMillis();

        System.out.println("Sorted subarray (first 20 elements): ");
        printArray(array, 20);

        System.out.println("Subarray length: " + array.length);
        System.out.println("Sorting took " + (endTime - startTime) + " milliseconds.");

        info.parent.write(array);
    }

    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    private void printArray(int[] array, int limit) {
        for (int i = 0; i < Math.min(array.length, limit); i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
