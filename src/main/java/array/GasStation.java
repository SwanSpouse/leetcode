package array;

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0) {
			return 0;
		}
		int total = 0;
		int startPos = -1;
		int curGas = 0;
		for(int i=0; i < gas.length; i ++ ) {
			total = total + gas[i] - cost[i];
			// 加上油箱里的油，仍无法移动到下一点。归零
			if(curGas + gas[i] - cost[i] < 0) {
				curGas = 0;
				startPos = -1;
			} else {
				curGas = curGas + gas[i] - cost[i];
				startPos = startPos == -1 ? i : startPos;
			}
		}
		return total >= 0 ? startPos : -1;
    }
}
