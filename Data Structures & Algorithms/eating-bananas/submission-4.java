class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        return minSpeed(piles, 1, max, h);
    }

    private int minSpeed(int[] piles, int low, int high, int h) {
        // when search space collapses
        if (low > high) {
            return low;
        }

        int mid = low + (high - low) / 2;
        long hours = hoursNeeded(piles, mid);

        if (hours <= h) {
            // mid works → try smaller speed
            return minSpeed(piles, low, mid - 1, h);
        } else {
            // mid too slow → need bigger speed
            return minSpeed(piles, mid + 1, high, h);
        }
    }

    private long hoursNeeded(int[] piles, int k) {
        long total = 0;
        for (int p : piles) {
            total += (p + k - 1) / k;
        }
        return total;
    }
}
