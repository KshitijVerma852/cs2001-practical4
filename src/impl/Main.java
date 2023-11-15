package impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter selectionSortWriter = new FileWriter("./SelectionSort.csv");
        FileWriter mergeSortWriter = new FileWriter("./MergeSort.csv");

        final int AVERAGE = 20000;
        final int NUM_OF_ELEMENTS = 150;

        selectionSortWriter.write("Number of elements,Time");
        mergeSortWriter.write("Number of elements,Time");

        for (int i = 0; i < NUM_OF_ELEMENTS; i++) {
            int[] nums = new int[i];

            for (int x = 0; x < nums.length; x++) {
                nums[x] = (new Random()).nextInt(200);
            }

            long totalTime = 0;

            for (int x = 0; x < AVERAGE; x++) {
                long startTime = System.nanoTime();
                SelectionSort.sort(nums);
                long endTime = System.nanoTime();

                totalTime += endTime - startTime;
            }




            long time = totalTime / AVERAGE;

            String data = "\n" + nums.length +
                    "," +
                    (time);
            selectionSortWriter.write(data);

            totalTime = 0;

            for (int x = 0; x < AVERAGE; x++) {
                long startTime = System.nanoTime();
                nums = MergeSort.sort(nums);
                long endTime = System.nanoTime();

                totalTime += endTime - startTime;
            }

            time = totalTime / AVERAGE;

            data = "\n" + nums.length +
                    "," +
                    (time);
            mergeSortWriter.write(data);

        }
        mergeSortWriter.close();
        selectionSortWriter.close();
        System.out.println("done");
    }
}