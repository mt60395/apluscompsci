import java.util.*;

public class SortsPrinter {
    private static int passes = 1;

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
            if (passes == arr.length) return;
            System.out.printf("Pass %d - %s\n", passes++, printArray(arr));
        }
    }

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
            System.out.printf("Pass %d - %s\n", passes++, printArray(arr));
        }
    }

    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    private static void quickSortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = pivot(arr, left, right);
        System.out.printf("Pass %d - %s\n", passes++, printArray(arr));
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

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private static void mergeSort(int[] arr, int front, int back) {
        int mid = (front + back) / 2;
        if (mid == front) return;
        mergeSort(arr, front, mid);
        mergeSort(arr, mid, back);
        merge(arr, front, back);
        System.out.printf("Pass %d - %s\n", passes++, printArray(arr));
    }

    private static void merge(int[] list, int front, int back) {
        int[] temp = new int[back - front];
        int i = front, j = (front + back) / 2, k = 0;
        int mid = j;
        while (i < mid && j < back) {
            if (list[i] < list[j])
                temp[k++] = list[i++];
            else
                temp[k++] = list[j++];
        }
        while (i < mid)
            temp[k++] = list[i++];
        while (j < back)
            temp[k++] = list[j++];
        for (i = 0; i < back - front; ++i)
            list[front + i] = temp[i];
    }

    public static void displayMenu() {
        System.out.println("***************************");
        System.out.println("*          MENU           *");
        System.out.println("* 1. Select Sort          *");
        System.out.println("* 2. Insert Sort          *");
        System.out.println("* 3. Quick Sort           *");
        System.out.println("* 4. Merge Sort           *");
        System.out.println("***************************");
    }

    public static String printArray(int[] arr) {
        String s = "";
        for (int i : arr) {
            s += i + " ";
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a list without brackets, just numbers and commas:");
        String s = input.nextLine();
        ArrayList<Integer> nums = new ArrayList<>();
        if (s.contains(" ")) {
            for (String i : s.split(", ")) {
                nums.add(Integer.valueOf(i));
            }
        }
        else {
            for (String i : s.split(",")) {
                nums.add(Integer.valueOf(i));
            }
        }
        int[] arr = new int[nums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i);
        }
        displayMenu();
        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1: // select sort
                SortsPrinter.selectSort(arr);
                break;
            case 2: // insert sort
                SortsPrinter.insertSort(arr);
                break;
            case 3: // quick sort
                SortsPrinter.quickSort(arr);
                break;
            case 4: // merge sort
                SortsPrinter.mergeSort(arr);
                break;
        }
    }
}
