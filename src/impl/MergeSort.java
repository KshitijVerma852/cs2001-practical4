package impl;

public class MergeSort {
    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        // Find the middle point
        int middle = array.length / 2;

        // Split the array into two halves
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];

        System.arraycopy(array, 0, leftArray, 0, middle);
        System.arraycopy(array, middle, rightArray, 0, array.length - middle);

        // Recursively sort the first and second halves
        leftArray = sort(leftArray);
        rightArray = sort(rightArray);

        // Merge the sorted halves
        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];

        // Merge the sorted arrays
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                result[k++] = leftArray[i++];
            } else {
                result[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray[], if any
        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray[], if any
        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }

        return result;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
