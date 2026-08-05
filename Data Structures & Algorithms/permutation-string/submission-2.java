class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int l = 0;
        int windowLen = Math.min(n1,n2);
        for(int r=0;r<n2;r++){
          if(r-l+1>windowLen){
            l++;
          }
          if(r-l+1==windowLen){
            String window = s2.substring(l,r+1);
            if(isAnagram(s1,window)){
              return true;
            }
          }
        }
        return false;
    }
    public boolean isAnagram(String s1,String s2){
      if(s1.length()!=s2.length()) return false;
      int n = s1.length();
      int[] count = new int[26];
      for(int i=0;i<n;i++){
        count[s1.charAt(i)-'a']++;
        count[s2.charAt(i)-'a']--;
      }
      for(int i=0;i<26;i++){
        if(count[i]!=0) return false;
      }
      return true;
    }
}
