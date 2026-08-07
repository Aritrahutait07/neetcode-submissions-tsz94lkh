class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res , List<Integer> path , int[] nums , int index ){
        // Add current path to result
        res.add(new ArrayList<>(path));
        // Explore all the choices
        for(int i=index;i<nums.length;i++){
            // Add current number 
            path.add(nums[i]);
            // Move to the next index
            backtrack(res,path,nums,i+1);
            // Undo backtrack
            path.remove(path.size()-1);
        }
    }
}
