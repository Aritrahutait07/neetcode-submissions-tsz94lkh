class Solution {

    public int search(int[] nums, int target) {
        return searchIndex(nums, 0, nums.length - 1, target);
    }

    public int searchIndex(int[] nums, int left, int right, int target) {

        // base case
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        // found target
        if (nums[mid] == target) {
            return mid;
        }

        // LEFT HALF IS SORTED
        if (nums[left] <= nums[mid]) {

            // target lies inside left half
            if (target >= nums[left] && target < nums[mid]) {
                return searchIndex(nums, left, mid - 1, target);
            } else {
                return searchIndex(nums, mid + 1, right, target);
            }
        }

        // RIGHT HALF IS SORTED
        else {

            // target lies inside right half
            if (target > nums[mid] && target <= nums[right]) {
                return searchIndex(nums, mid + 1, right, target);
            } else {
                return searchIndex(nums, left, mid - 1, target);
            }
        }
    }
}
