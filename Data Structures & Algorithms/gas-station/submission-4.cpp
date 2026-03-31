class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int totalGas = 0, totalCost = 0;
        int tank = 0, start = 0;

        for (int i = 0; i < gas.size(); ++i) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If tank goes negative, can't start from current segment
            if (tank < 0) {
                start = i + 1;  // try next station as a new start
                tank = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }
};

