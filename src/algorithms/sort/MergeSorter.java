package algorithms.sort;


import java.util.Arrays;
import java.util.Random;

public class MergeSorter implements Sorter {


    private void mergeSortRecursive(int[] arr, int[] reg, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        mergeSortRecursive(arr, reg, l, mid);
        mergeSortRecursive(arr, reg, mid + 1, r);
        int i = l, j = mid + 1, k = l;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j])
                reg[k++] = arr[i++];
            else
                reg[k++] = arr[j++];
        }
        while (i <= mid)
            reg[k++] = arr[i++];
        while (j <= r)
            reg[k++] = arr[j++];
        System.arraycopy(reg, l, arr, l, r - l + 1);
    }

    @Override
    public void sort(int[] nums) {
        int[] reg = new int[nums.length];
        mergeSortRecursive(nums, reg, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random(107);

        for (int i = 0; i < 10; i++) {
            arr[i] = r.nextInt(100);
        }
        Sorter sorter = new MergeSorter();
        sorter.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
