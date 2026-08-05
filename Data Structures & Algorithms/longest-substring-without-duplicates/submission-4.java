class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        //set.add(s.charAt(left));
        int n = s.length();
        int max = 0;
        for(int r=0;r<n;r++){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}
