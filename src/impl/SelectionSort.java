package impl;

public class SelectionSort {
//    public static int[] sort(int[] nums) {
//        if (nums.length == 1) return nums;
//        for (int x = 0; x < nums.length; x++) {
//            for (int y = x; y < nums.length; y++) {
//                if (nums[x] > nums[y]) {
//                    int temp = nums[x];
//                    nums[x] = nums[y];
//                    nums[y] = temp;
//                }
//            }
//        }
//        return nums;
//    }
    public static int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}
