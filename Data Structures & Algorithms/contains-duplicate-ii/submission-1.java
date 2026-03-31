class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for(int R=0;R<nums.length;R++){
            if(R>k){
                window.remove(nums[R-k-1]);
            }
            if(!window.add(nums[R])) return true;
        }
        return false;
    }
}