package algorithms.binarysearch;


public class BinarySearch {


    private int search(int[] nums, int target) {
        // Make sure nums is ordered
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        // Not found
        return -1;
    }


    private int findLastNumberLessThan(int[] nums, int target) {
        // Find the last number less than target, make sure nums is ordered.
        // For instance [1, 2, 3, 6, 7] the last number < 5 is 3.
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    private int findFirstNumberGreaterThan(int[] nums, int target) {
        // Find the first number greater than target, make sure nums is ordered
        // For instance [1, 2, 3, 6, 7] the first number > 4 is 6.
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l == nums.length ? -1 : l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 6, 8, 9};

        BinarySearch searcher = new BinarySearch();

        int[] values = new int[]{0, 1, 4, 5, 9, 10};
        for (int v : values) {
            int pos = searcher.search(nums, v);
            System.out.println("search " + v + " pos: " + pos);
        }

        for (int v : values) {
            int pos = searcher.findFirstNumberGreaterThan(nums, v);
            System.out.println("findFirstNumberGreaterThan " + v + " pos: " + pos);
        }

        for (int v : values) {
            int pos = searcher.findLastNumberLessThan(nums, v);
            System.out.println("findLastNumberLessThan " + v + " pos: " + pos);
        }
    }
}
