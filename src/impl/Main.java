package impl;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        File selectionSortCsv = new File("./SelectionSort.csv");
        File mergeSortCsv = new File("./MergeSort.csv");

        FileWriter selectionSortWriter = new FileWriter(selectionSortCsv);
        FileWriter mergeSortWriter = new FileWriter(mergeSortCsv);

        selectionSortWriter.write("Number of elements,Time");
        mergeSortWriter.write("Number of elements,Time");


        for (int i = 0; i < 200; i++) {
            int[] nums = new int[i];

            for (int x = 0; x < nums.length; x++) {
                nums[x] = (new Random()).nextInt(200);
            }

            long startTime = System.nanoTime();
            nums = SelectionSort.sort(nums);
            long endTime = System.nanoTime();

            String data = "\n" + nums.length +
                    "," +
                    (endTime - startTime);
            selectionSortWriter.write(data);

            startTime = System.nanoTime();
            nums = MergeSort.sort(nums);
            endTime = System.nanoTime();

            data = "\n" + nums.length +
                    "," +
                    (endTime - startTime);
            mergeSortWriter.write(data);
        }
    }
}