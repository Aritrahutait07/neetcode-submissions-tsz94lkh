// Recurssion

// class Solution {
//     public int climbStairs(int n) {
//         return solve(n, 0);
//     }

//     public int solve(int n, int i) {
//         if (i == n) return 1;   // valid way
//         if (i > n) return 0;    // invalid way

//         int x1 = solve(n, i + 1);
//         int x2 = solve(n, i + 2);

//         return x1 + x2;
//     }
// }

//  Top to bottom

// class Solution {
//     public int climbStairs(int n) {
//         Integer [] mem = new Integer[n];
//         return solve(n,mem, 0);

//     }
//     public int solve(int n,Integer [] mem,int i){
//         if(i==n) return 1;
//         if(i>n) return 0;

//         if(mem[i] != null) return mem[i];
//         return solve(n,mem,i+1) + solve(n,mem,i+2);
//     }

    
// }

// Bottom to Up

class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;  // 1 way to stay at ground
        dp[1] = 1;  // 1 way to reach step 1

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
