class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        if(n==1){
            return false;
        }
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='(' || c== '{' || c== '['){
                st.push(s.charAt(i));
            }else if(!st.isEmpty()){
                //char curr = s.charAt(i);
                char top = st.pop();
                if((c==')' && top!='(')||(c==']' && top!='[')||(c=='}' && top!='{')){
                    return false;
                }
                
            }else{
                return false;
            }
        }
        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
