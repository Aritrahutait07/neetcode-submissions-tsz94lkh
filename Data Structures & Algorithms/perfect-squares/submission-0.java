class Solution {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        List<Integer> squares = square(n);

        for (int i = 1; i <= n; i++) {
            for (int sq : squares) {
                if (sq <= i) {
                    dp[i] = Math.min(dp[i], dp[i - sq] + 1);
                }
            }
        }

        return dp[n];
    }

    public List<Integer> square(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            res.add(i * i);
        }

        return res;
    }
}
