class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    public int helper(int[] nums,int i,int currXor){
        if(i==nums.length) return currXor;
        int pick = helper(nums,i+1,currXor ^ nums[i]);
        int notpick = helper(nums,i+1,currXor);
        return pick+notpick;
    }
}