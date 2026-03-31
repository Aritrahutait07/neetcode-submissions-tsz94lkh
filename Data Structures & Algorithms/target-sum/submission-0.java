class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ans = solve(nums,target,0,0);
        return ans;
    }
    public int solve(int[] nums,int target, int index,int currsum){
        int m = nums.length;
        // Base Case
        if(index==m){
            if(currsum==target){
                return 1;
            }else{
                return 0;
            }
        }
        int sum  = solve(nums,target,index+1,currsum+nums[index]);
        int subtract = solve(nums,target,index+1,currsum-nums[index]);

        return sum + subtract;
    }
}
