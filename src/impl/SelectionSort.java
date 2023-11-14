package impl;

public class SelectionSort {
    public static int[] sort(int[] nums) {
        for (int x = 0; x < nums.length; x++) {
            for (int y = x; y < nums.length; y++) {
                if (nums[x] > nums[y]) {
                    int temp = nums[x];
                    nums[x] = nums[y];
                    nums[y] = temp;
                }
            }
        }
        return nums;
    }
}
