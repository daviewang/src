import java.util.*;

public class O403FrogJump {
	public boolean canCross(int[] stones) {
		if (stones == null || stones.length == 0) {
			return true;
		}
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], new HashSet<>());
		}
		map.get(0).add(1);
		
		for(Integer stone : stones) {
			for (Integer step : map.get(stone)) {
				int reach = stone + step;
				if (reach == stones[stones.length - 1]) {
					return true;
				}
				if (map.containsKey(reach)) {
					map.get(reach).add(step);
					map.get(reach).add(step + 1);
					if (step - 1 > 0) {
						map.get(reach).add(step - 1);
					}
				}
			}
		}
		return false;
    } 
	
	public static void main(String[] args) {
		O403FrogJump e = new O403FrogJump();
		int[] in = {0,1,3,5,6,8,12,17};
		e.canCross(in);
	}
}