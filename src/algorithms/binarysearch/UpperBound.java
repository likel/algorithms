package algorithms.binarysearch;

public class UpperBound {

    private int upperBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            // See https://www.topcoder.com/community/data-science/data-science-tutorials/binary-search/
            int m = (r + l + 1) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4, 5, 7};
        UpperBound upperBound = new UpperBound();

        for (int v : arr)
            System.out.println(upperBound.upperBound(arr, v));
        System.out.println(upperBound.upperBound(arr, -1));
        System.out.println(upperBound.upperBound(arr, 8));
    }
}
