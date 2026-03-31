class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: use houses [0 ... n-2]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        int ans1 = dp[n - 1];

        // Case 2: use houses [1 ... n-1]
        int[] dp1 = new int[n + 1];
        dp1[0] = 0;
        dp1[1] = nums[1];

        for (int i = 2; i <= n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
        }
        int ans2 = dp1[n - 1];

        return Math.max(ans1, ans2);
    }
}
