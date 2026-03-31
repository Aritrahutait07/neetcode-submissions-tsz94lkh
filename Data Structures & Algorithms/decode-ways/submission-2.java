class Solution {

    public int numDecodings(String s) {
        return solve(s, 0);
    }

    private int solve(String s, int i) {

        // Base case: reached end successfully
        if (i == s.length()) {
            return 1;
        }

        // Leading zero → invalid
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Take 1 digit
        int count = solve(s, i + 1);

        // Take 2 digits if possible
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num <= 26) {
                count += solve(s, i + 2);
            }
        }

        return count;
    }
}
