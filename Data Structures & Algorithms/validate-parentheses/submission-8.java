class Solution {
    public boolean isValid(String s) {
      Stack<Character> st = new Stack<>();
      for(char c : s.toCharArray()){
        if(c == '(' || c== '{' || c== '['){
            st.push(c);
        }else{
                if(st.isEmpty()){
                    return false;
                }
                char d = st.peek();
                if(c == ')' && d == '('){
                    st.pop();
                }else if(c == '}' && d == '{'){
                    st.pop();
                }else if(c == ']' && d == '[') {
                    st.pop();
                }else{
                    return false;
                }
            
        }
        
      }
      if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
