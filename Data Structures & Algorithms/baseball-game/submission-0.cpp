class Solution {
public:
    int calPoints(vector<string>& operations) {
        int sum = 0;
        std::stack<int> st;
        for(const string& op: operations){
            if(op=="C"){
                st.pop();
            }
            else if(op=="+"){
                int a = st.top();
                st.pop();
                int b = st.top();
                st.push(a);
                int sum = a + b;
                st.push(sum);
            }
            else if(op=="D"){
                int a = st.top();
                st.push(a*2);
            }
            else{
                st.push(std::stoi(op));
            }
        }
        while(!st.empty()){
            sum += st.top();
            st.pop();
        }
        return sum;
    }
};