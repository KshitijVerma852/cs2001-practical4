package impl;

public class MergeSort {
    /**
     * Sorts the given integer array using the merge sort algorithm.
     * @param array The array of integers to be sorted.
     * @return The final sorted integers array.
     */
    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        // Finding the middle point of the array.
        int middle = array.length / 2;

        // Splitting the array into two halves for recursion.
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];

        System.arraycopy(array, 0, leftArray, 0, middle);
        System.arraycopy(array, middle, rightArray, 0, array.length - middle);

        // Recursively sorting both halves.
        leftArray = sort(leftArray);
        rightArray = sort(rightArray);

        // Merge the sorted halves.
        return merge(leftArray, rightArray);
    }

    public static int[] merge(int[] leftArray, int[] rightArray) {
        int[] result = new int[leftArray.length + rightArray.length];

        // Merging the sorted arrays.
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                result[k++] = leftArray[i++];
            } else {
                result[k++] = rightArray[j++];
            }
        }

        // Copying the remaining elements of leftArray[].
        while (i < leftArray.length) {
            result[k++] = leftArray[i++];
        }

        // Copying remaining elements of rightArray[].
        while (j < rightArray.length) {
            result[k++] = rightArray[j++];
        }

        return result;
    }
}
