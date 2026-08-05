class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            char a = s.charAt(i);
            HashSet<Character> set = new HashSet<>();
            set.add(a);
            int curr_len = 1;
            int r = i+1;
            while(r<n && !set.contains(s.charAt(r))){
                curr_len++;
                set.add(s.charAt(r));
                r++;
            }
            max = Math.max(max,curr_len);
        }
        return max;
    }
}
