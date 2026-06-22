class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> seen;

        for (int i = 0; i < nums.size(); i++) {
            int curr_num = nums[i];
            int need = target - curr_num;

            if (seen.contains(need)) {
                return {seen[need], i};
            }

            seen[curr_num] = i;
        }

        return {};
    }
};