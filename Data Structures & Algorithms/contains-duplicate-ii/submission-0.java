

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> windows = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(windows.contains(nums[i])) return true;
            windows.add(nums[i]);
            if (windows.size() > k) {
                windows.remove(nums[i - k]);
            }
        }
        return false;
    }
}