package tests;

import impl.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {
    int[] nums;

    public static int[] generateNumsArray() {
        Random random = new Random();
        int[] nums;

        int arrayLength = random.nextInt(500);
        nums = new int[arrayLength];
        for (int x = 0; x < nums.length; x++) {
            nums[x] = random.nextInt(200);
        }
        return nums;
    }

    @Test
    public void checkIfSortWorks() {
        for (int i = 0; i < 100; i++) {
            nums = generateNumsArray();
            int[] sortedArr = MergeSort.sort(nums);
            Arrays.sort(nums);
            int[] expected = nums;
            Assertions.assertArrayEquals(sortedArr, expected);
        }
    }
}
