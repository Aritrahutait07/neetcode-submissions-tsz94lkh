class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> currList, List<List<Integer>> result) {
        // Base case
        if (index == nums.length) {
            result.add(new ArrayList<>(currList));  // copy current subset
            return;
        }

        // 1. Include nums[index]
        currList.add(nums[index]);
        backtrack(nums, index + 1, currList, result);

        // 2. Exclude nums[index]
        currList.remove(currList.size() - 1);
        backtrack(nums, index + 1, currList, result);
    }
}
