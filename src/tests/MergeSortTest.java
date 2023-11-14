package tests;

import impl.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {
    int[] nums;

    @BeforeEach
    public void generateNumsArray() {
        Random random = new Random();
        int arrayLength = random.nextInt(500);
        nums = new int[arrayLength];
        for (int x = 0; x < nums.length; x++) {
            nums[x] = random.nextInt(200);
        }
    }

    @Test
    public void checkIfSortWorks() {
        for (int i = 0; i < 100; i++) {
            int[] sortedArr = MergeSort.sort(nums);
            Arrays.sort(nums);
            int[] expected = nums;
            Assertions.assertArrayEquals(sortedArr, expected);
        }
    }
}
