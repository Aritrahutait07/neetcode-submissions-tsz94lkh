class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            int currTemp = temperatures[i];
            while(!st.isEmpty() && currTemp > temperatures[st.peek()]){
                int pastIndex = st.pop();
                result[pastIndex] = i - pastIndex;
            }
            st.push(i);
        }
        return result;
    }
}
