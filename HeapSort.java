import java.util.Arrays;

public class HeapSort {

    private static void heapify(int[] arr, int i, int n) {
        int l = i * 2, r = i * 2 + 1;
        int max_index = i;
        if ((l <= n) && (arr[l] > arr[i])) {
            max_index = l;
        }
        if ((r <= n) && (arr[r] > arr[max_index])) {
            max_index = r;
        }
        if (max_index != i) {
            int temp = arr[i];
            arr[i] = arr[max_index];
            arr[max_index] = temp;
            heapify(arr, max_index, n);
        }
    }

    private static void sort(int[] arr) {
        // Building the max-heap first
        for (int i = (arr[0] / 2); i > 0; i--) {
            heapify(arr, i, arr[0]);
        }

        for (int i = arr[0]; i > 1; i--) {
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;

            heapify(arr, 1, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 23, 24, 5, 12, 7, 30, 18, 42, 35, 60, 67, 28, 15, 39, 9, 53, 58, 25, 62, 49};
        System.out.println("Input array before making the heap is:");
        System.out.println(Arrays.toString(arr));

        for (int i = (arr[0] / 2); i > 0; i--) {
            heapify(arr, i, arr[0]);                      // start heapifying from floor(n/2)th node, i.e. 10th node
        }
        System.out.println("\nArray after making the heap is:");
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println("\nArray after sorting is:");
        System.out.println(Arrays.toString(arr));
    }
}
