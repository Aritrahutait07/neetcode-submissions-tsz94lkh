class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currXor) {
        // Base case: reached end of array
        if (index == nums.length) {
            return currXor;
        }

        // Include current element
        int include = dfs(nums, index + 1, currXor ^ nums[index]);

        // Exclude current element
        int exclude = dfs(nums, index + 1, currXor);

        // Total sum from both choices
        return include + exclude;
    }
}
