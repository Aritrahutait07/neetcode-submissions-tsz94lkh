class Solution {
    public int lengthOfLongestSubstring(String s) {
      Set<Character> charSet = new HashSet<>();
      int L = 0, maxLen = 0;

      for (int R = 0; R < s.length(); R++) {
          // If char at R is a duplicate, shrink until it's not
          while (charSet.contains(s.charAt(R))) {
              charSet.remove(s.charAt(L));
              L++;
          }
          charSet.add(s.charAt(R));
          maxLen = Math.max(maxLen, R - L + 1);
      }
      return maxLen;
  }
}
