class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        std::unordered_set<int> res;
        for(int num : nums){
            if(res.contains(num)){
                return true;
            }
            else{
                res.insert(num);
            }
        }
        return false;
    }
};