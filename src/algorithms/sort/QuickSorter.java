package algorithms.sort;


import java.util.Random;

public class QuickSorter implements Sorter {

    private void sort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int pivot = partition(nums, l, r);
        sort(nums, l, pivot);
        sort(nums, pivot + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        while (l < r) {
            while (l < r && pivot < nums[r])
                r--;
            nums[l] = nums[r];
            while (l < r && pivot >= nums[l])
                l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }

    @Override
    public int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random(107);

        for (int i = 0; i < 10; i++) {
            arr[i] = r.nextInt(100);
        }
        Sorter sorter = new QuickSorter();
        sorter.sort(arr);

        for (int i = 0; i < 10; i++)
            System.out.println(arr[i]);
    }
}
