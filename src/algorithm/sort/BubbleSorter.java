package algorithm.sort;


import java.util.Arrays;

/**
 * https://en.wikipedia.org/wiki/Bubble_sort
 */
public class BubbleSorter implements Sorter {


    @Override
    public int[] sort(int[] nums) {
        for (int n = nums.length; n > 1; n--) {
            boolean swapped = false;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] > nums[i]) {
                    swap(nums, i - 1, i);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int backup = nums[i];
        nums[i] = nums[j];
        nums[j] = backup;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        Sorter sorter = new BubbleSorter();
        sorter.sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
