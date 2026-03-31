class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;

        for (int i = 0; i < n; i++) {
            // If we can't even reach this position, stop
            if (i > farthest) return false;

            // Update farthest reachable point
            farthest = Math.max(farthest, i + nums[i]);

            // If we can already reach the end, no need to continue
            if (farthest >= n - 1) return true;
        }

        return true;
    }
}
