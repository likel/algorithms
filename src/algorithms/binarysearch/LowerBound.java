package algorithms.binarysearch;


public class LowerBound {

    /**
     * Get the lower bound of target in array
     *
     * @param nums   The array to lookup
     * @param target The target to find lower bound in array
     * @return The earliest index
     */
    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4, 5, 7};
        LowerBound lowerBound = new LowerBound();

        for (int v : arr)
            System.out.println(lowerBound.lowerBound(arr, v));
        System.out.println(lowerBound.lowerBound(arr, -1));
        System.out.println(lowerBound.lowerBound(arr, 8));
    }
}
