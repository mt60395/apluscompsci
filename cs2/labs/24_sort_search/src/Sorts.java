public class Sorts {

    /**
     * Classical insertion sort algorithm that runs in 0(N^2) unless the array
     * is sorted in which the best case is O(N). Conceptually the algorithm is
     * similar to sorting a hand of cards as the dealer deals each card. Each
     * time you pick up a card you shift all cards over that are less than that
     * card then insert the new card in the appropriate location. Hence the name
     * insertion sort.
     *
     * @param arr of integers
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int greaterThan = -1;
            for (int j = 0; j < i; j++) { // find the first number of the sorted that is greater than
                if (arr[j] > arr[i]) {
                    greaterThan = j;
                    break;
                }
            }
            if (greaterThan != -1) {
                int current = arr[i];
                for (int j = i; j > greaterThan; j--) { // shift. must shift from back
                    arr[j] = arr[j - 1];
                }
                arr[greaterThan] = current;
            }
        }
    }

    /**
     * For each index, find the smallest element and perform one swap. Runs in
     * 0(N^2) for all cases but performs at most N-1 swaps.
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int sorted = -1; // the sorted index. starts off none sorted
        while (sorted != arr.length - 1) {
            int min = sorted + 1;
            for (int i = sorted + 2; i < arr.length; i++) { // find minimum index
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            if (min != ++sorted) {
                int temp = arr[min];
                arr[min] = arr[sorted];
                arr[sorted] = temp;
            }
        }
    }

    /**
     * Divide and Conquer algorithm that picks a pivot and moves all elements
     * that are less than the pivot to the left side and similarly all elements
     * larger than the pivot to the right. Repeat the process on both sides. The
     * algorithm is linearithmic O(nlogn) but can degenerate if a poorly chosen
     * pivot is selected. Choose a randomized pivot to help prevent this. The
     * algorithm is quite fast as the name suggests, takes advantage of cache hits
     * but it is not stable(no impact on ints).
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    private static void quickSortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = pivot(arr, left, right);
        quickSortRecursive(arr, left, index - 1); // inclusive
        quickSortRecursive(arr, index, right);
    }

    private static int pivot(int[] arr, int left, int right) {
        int piv = arr[left]; // first element works
        while (left <= right) {
            while (arr[left] < piv) {
                left++;
            }
            while (arr[right] > piv) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        return left;
    }

    /**
     * Divide and conquer algorithm that repeatedly divides the array into
     * halves then merges the halves together. The algorithm is stable and runs
     * in O(nlogn) in all cases. It's an out of place algorithm since a temporary
     * array is used in the merge method.
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mergeSortRecursive(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = ((end + begin) / 2);
        mergeSortRecursive(arr, temp, begin, mid);
        mergeSortRecursive(arr, temp, mid + 1, end); // is inclusive
        merge(arr, temp, begin, mid, end);
    }

    // merge two portions that are sorted respectively by creating an auxiliary
    // array as a place holder then copy it back
    private static void merge(int[] arr, int[] temp, int start, int middle, int end) {
        int rightStart = middle + 1;
        int size = end - start + 1;

        int left = start;
        int right = rightStart;
        int index = start;
        while (left <= middle && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            }
            else {
                temp[index++] = arr[right++];
            }
        }

        System.arraycopy(arr, left, temp, index, middle - left + 1);
        System.arraycopy(arr, right, temp, index, end - right + 1);
        System.arraycopy(temp, start, arr, start, size);

    }

}
