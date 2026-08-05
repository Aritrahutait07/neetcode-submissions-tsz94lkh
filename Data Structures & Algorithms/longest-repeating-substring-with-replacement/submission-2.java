class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLen = 0;
        int maxFreq = 0;
        int l = 0;
        int n = s.length();
        for(int r=0;r<n;r++ ){
            count[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,count[s.charAt(r)-'A']);
            int windowLen = r-l+1;
            if(windowLen-maxFreq>k){
                count[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);

        }
        return maxLen;
    }
}
