

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int maxFreq = 0;   // highest frequency of a single char in the window
        int maxLen = 0;    // final answer
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);

            // Update the maximum frequency of any character in the window
            maxFreq = Math.max(maxFreq, count.get(rightChar));

            // If replacements needed > k, shrink the window
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
            }

            // Update the maximum valid window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
