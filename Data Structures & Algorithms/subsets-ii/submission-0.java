class Solution {
    List<List<Integer>> result =  new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        backtrack(nums,0,new ArrayList<>());
        result.add(new ArrayList<>());
        return result;   
    }
    public void backtrack(int[] nums,int start,List<Integer> path){
        if(nums.length==path.size())
        {
            return;
        }
        for(int i=start;i<nums.length;i++)
        {   
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            backtrack(nums,i+1,path);
            path.remove(path.size()-1);
        }
        
    }
}
