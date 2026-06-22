class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        int size = nums.size();
        vector<int> result (2*size);
        for(int i=0;i<2*size;i++){
            result[i] = nums[i%size];
        }
        return result;
    }
};