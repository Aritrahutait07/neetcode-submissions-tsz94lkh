class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int n = gas.length;
       for(int start = 0;start<n;start++){
        boolean canTravel = true;
        int tank = 0;
        for(int i=0;i<n;i++){
            int idx = (start+i)%n;
            tank += gas[idx] - cost[idx];
            if(tank<0){
                canTravel = false;
                break;
            }
            
        }
        if(canTravel){
                return start;
            }
       }

       return -1;
    }
}
