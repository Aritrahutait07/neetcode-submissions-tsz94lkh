class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int longest = 0;
        for(int n  : nums){
            if(!set.contains(n-1)){
                int currentNum = n;
                int currentSteak = 1;

                while(set.contains(currentNum+1)){
                    currentNum += 1;
                    currentSteak += 1;
                }
                longest = Math.max(longest,currentSteak);
            }
            
        }
        return longest;
    }
}
