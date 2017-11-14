package algorithms.sort;


import java.util.Arrays;


public class InsertionSorter implements Sorter {


    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] >= nums[j - 1]) {
                    // [0, j] already ordered
                    break;
                }
                swap(nums, j, j - 1);
            }
        }
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
