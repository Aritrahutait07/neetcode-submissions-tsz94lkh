class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int jumps = 0;
        int currentEnd = 0;  // farthest we can reach in current jump
        int farthest = 0;    // farthest we can reach in next jump

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {  // end of current jump range
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
