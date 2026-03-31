class Solution {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used ;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums,new ArrayList<>());
        return result;
    }
    public void backtrack(int[] nums,List<Integer> path){
        
        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i]==true)
            {
                continue;
            }
            used[i]=true;
            path.add(nums[i]);
            backtrack(nums,path);
            path.remove(path.size()-1);
            used[i]=false;
        }
        
    }
}
