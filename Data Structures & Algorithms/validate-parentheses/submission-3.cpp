class Solution {
public:
    bool isValid(string s) {
        
        std::stack<char> st;
        for(char c: s){
            if(c=='[' || c =='{' || c =='('){
                st.push(c);
            }else if(!st.empty() && c==']'){
                if(st.top()=='['){
                    st.pop();
                }else{
                    return false;
                }
            }else if(!st.empty() && c==')'){
                if(st.top()=='('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(!st.empty() && c=='}'){
                if(st.top()=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(c);
            }
        }
        if(!st.empty()){
            return false;
        }
        return true;
    }
};
