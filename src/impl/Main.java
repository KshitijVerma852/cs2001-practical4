package impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    /**
     * Main point of execution.
     * @param args the program arguments, not used in the code at all though.
     * @throws IOException if the files cannot be opened.
     */
    public static void main(String[] args) throws IOException {
        // Creating the required CSV files.
        FileWriter selectionSortWriter = new FileWriter("./SelectionSort.csv");
        FileWriter mergeSortWriter = new FileWriter("./MergeSort.csv");

        // Setting the constant variables.
        final int AVERAGE = 50000;
        final int NUM_OF_ELEMENTS = 150;

        // Setting the Headers of the CSV files.
        selectionSortWriter.write("Number of elements,Time");
        mergeSortWriter.write("Number of elements,Time");

        // Looping through to add data to the files.
        for (int i = 0; i < NUM_OF_ELEMENTS; i++) {
            int[] nums = new int[i];

            // Generating randoms number in the nums array.
            for (int x = 0; x < nums.length; x++) {
                nums[x] = (new Random()).nextInt(200);
            }

            long totalTime = 0;

            // Calculating the average time for selection sort.
            for (int x = 0; x < AVERAGE; x++) {
                long startTime = System.nanoTime();
                SelectionSort.sort(nums);
                long endTime = System.nanoTime();

                totalTime += endTime - startTime;
            }

            long time = totalTime / AVERAGE;

            // Appending the data on to the selection sort CSV file.
            String data = "\n" + nums.length +
                    "," +
                    (time);
            selectionSortWriter.write(data);

            totalTime = 0;

            // Calculating the average time for merge sort.
            for (int x = 0; x < AVERAGE; x++) {
                long startTime = System.nanoTime();
                nums = MergeSort.sort(nums);
                long endTime = System.nanoTime();

                totalTime += endTime - startTime;
            }

            time = totalTime / AVERAGE;

            // Appending the data on to the merge sort CSV file.
            data = "\n" + nums.length +
                    "," +
                    (time);
            mergeSortWriter.write(data);

        }
        // Closing all the open connections.
        mergeSortWriter.close();
        selectionSortWriter.close();
        // Logging when the program execution is over.
        System.out.println("done");
    }
}