class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new  ArrayList<>();
        return backtrack(nums,curr,res,0);
    }
    public List<List<Integer>> backtrack(int[] nums,List<Integer> currpath,List<List<Integer>> result,int index){
        // Copy current path in result
        result.add(new ArrayList<>(currpath));
        // Explore all the choice
        for(int i=index;i<nums.length;i++){
            // choose
            currpath.add(nums[i]);
            // explore
            backtrack(nums,currpath,result,i+1);
            // unchoose or backtrack
            currpath.remove(currpath.size()-1);
        }
        return result;
    }
}
