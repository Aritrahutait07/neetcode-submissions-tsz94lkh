class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int ans = max;  // initialize

        for (int i = 1; i <= max; i++) {
            if (isPossible(piles, h, i)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] piles, int h, int k) {
        long total = 0;   // ✅ MUST be long

        for (int p : piles) {
            total += (p + k - 1) / k;

            // optional early stop (optimization)
            if (total > h) return false;
        }
        return total <= h;
    }

}
