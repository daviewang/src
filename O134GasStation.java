public class O134GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int tank = 0;
		int res = 0;
		int lenOfCycle = gas.length;
		int sumOfGas = 0;
		int sumOfCost = 0;
		
		for (int i = 0; i < lenOfCycle; i++) {
			sumOfGas += gas[i];
			sumOfCost += cost[i];
			tank += gas[i] - cost[i];
			if (tank < 0) {
				res = i + 1;
				tank = 0;
			}
		}
		if (sumOfGas < sumOfCost) {
			return -1;
		}
		else {
			return res;
		}
	}
}