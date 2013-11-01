//take: restart from where failed, skip the middle
// because the middles cannot be the valid start point of the gas station, if they could be, won't fail at current point.

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int gasLeft = 0;
        for(int i = 0; i < gas.length; i++) {
            if(gas[i] - cost[i] < 0) continue;
            int stop = stopAt(gas, cost, i);
            if(stop == i) return i;
            //  start from where failed 
            else i = stop;
        }
        
        return -1;
    }
    
    
    
    public int stopAt(int[] gas, int[] cost, int start) {
        //if(start >= gas.length) return false;
        int gasLeft = 0;
        for(int i = start; i < start+gas.length; i++) {
            gasLeft += gas[i % gas.length] - cost[i % gas.length];
            if(gasLeft <0) { 
                return i;    
            }
        }
        return start;
    }
}
