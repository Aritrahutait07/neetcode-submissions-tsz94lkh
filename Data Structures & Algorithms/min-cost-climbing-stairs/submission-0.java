class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] mem = new Integer[cost.length];
        int cost1 = solve(cost, mem, 0);
        int cost2 = solve(cost, mem, 1);
        return Math.min(cost1, cost2);
    }

    public int solve(int[] cost, Integer[] mem, int i) {
        // Base case: reached or crossed the top
        if (i >= cost.length) return 0;

        // Memoized result
        if (mem[i] != null) return mem[i];

        int oneStep = cost[i] + solve(cost, mem, i + 1);
        int twoStep = cost[i] + solve(cost, mem, i + 2);

        mem[i] = Math.min(oneStep, twoStep);
        return mem[i];
    }
}
