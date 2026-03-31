class Solution {

    public int findMin(int[] nums) {
        int index = searchMin(nums, 0, nums.length - 1);
        return nums[index];   // return the minimum value
    }

    // returns INDEX of minimum element
    public int searchMin(int[] nums, int left, int right) {

        // base condition
        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        // minimum lies in right half
        if (nums[mid] > nums[right]) {
            return searchMin(nums, mid + 1, right);
        }
        // minimum lies at mid or left half
        else {
            return searchMin(nums, left, mid);
        }
    }
}

