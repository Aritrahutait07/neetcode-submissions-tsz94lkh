class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // already at last index

        int jumps = 0;
        int currentIndex = 0;

        while (currentIndex < n - 1) {
            // If we can reach the end directly, do it
            if (currentIndex + nums[currentIndex] >= n - 1) {
                jumps++;
                break;
            }

            int maxReach = 0;
            int nextIndex = currentIndex;

            // Look at all positions we can jump to from currentIndex
            int end = currentIndex + nums[currentIndex];
            for (int i = currentIndex + 1; i <= end; i++) {
                // Pick the position that allows us to reach farthest in next jump
                if (i + nums[i] > maxReach) {
                    maxReach = i + nums[i];
                    nextIndex = i;
                }
            }

            // If we can't move forward, return -1 (should not happen as per problem constraints)
            if (nextIndex == currentIndex) return -1;

            // Jump to that index
            currentIndex = nextIndex;
            jumps++;
        }

        return jumps;
    }
}
