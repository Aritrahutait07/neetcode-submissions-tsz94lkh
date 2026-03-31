class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] mem = new int[n+1];
        mem[0]=0;
        mem[1]=1;
        mem[2]=1;
        for(int i=3;i<=n;i++){
            mem[i]=mem[i-1]+mem[i-2]+mem[i-3];
        }
        return mem[n];
    }
}