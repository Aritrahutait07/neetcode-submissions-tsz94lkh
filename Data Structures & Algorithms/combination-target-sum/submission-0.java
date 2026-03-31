
class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums); // optional but helps pruning
        backtrack(0, target, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int target, int[] nums, List<Integer> path) {

        // SUCCESS CASE
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // PRUNE CASE
        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {

            // optional pruning since sorted
            if (nums[i] > target) break;

            path.add(nums[i]);

            // i (NOT i+1) → allows unlimited reuse
            backtrack(i, target - nums[i], nums, path);

            // backtrack
            path.remove(path.size() - 1);
        }
    }
}

