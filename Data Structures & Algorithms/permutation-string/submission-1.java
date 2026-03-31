class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if(s1.length()>s2.length()) return false;
      HashMap <Character,Integer> s1map = new HashMap<>();
      HashMap <Character,Integer> windowmap = new HashMap<>();
      for(char c:s1.toCharArray()){
        s1map.put(c, s1map.getOrDefault(c, 0) + 1);
      }
      int left = 0;
      int right  = 0;
      int windowsize = s1.length();
      while(right<s2.length()){
        char c = s2.charAt(right);
        windowmap.put(c, windowmap.getOrDefault(c, 0) + 1);
        if(right-left+1>windowsize){
            char leftChar = s2.charAt(left);
                windowmap.put(leftChar, windowmap.get(leftChar) - 1);
                if (windowmap.get(leftChar) == 0) {
                    windowmap.remove(leftChar);
                }
            left++;
        }
        if ((right - left + 1) == windowsize) {
                if (windowmap.equals(s1map)) {
                    return true;
                }
        }
        right++;
      }
      return false;
    }
}
