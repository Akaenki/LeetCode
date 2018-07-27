public class GasStation {
    /** If the sum of gas is lager than cost there must be a start station */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0,total = 0,sum = 0;
        //if car fails at 'start', record the next station
        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (total < 0) {
                start = i + 1; //move starting position forward
                total = 0; //reset tank
            }
        }
        //negative total + positive tank should be 0 or more, if so we can do a round trip and return start
        return (sum < 0)? -1 : start;
    }
}
