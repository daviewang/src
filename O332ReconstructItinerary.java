import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class O332ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new LinkedList<>();
		if (tickets == null || tickets.length == 0) {
			return res;
		}
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				map.put(ticket[0], new PriorityQueue<>());
			}
			map.get(ticket[0]).add(ticket[1]);
		}
		dfs("JFK", map, res);
		return res;
	}
	
	private void dfs(String depart, Map<String, PriorityQueue<String>> map, List<String> res) {
		PriorityQueue<String> arrivals = map.get(depart);
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll(), map, res);
		}
		res.add(0, depart);
	}
	public static void main(String[] args) {
		O332ReconstructItinerary e = new O332ReconstructItinerary();
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		e.findItinerary(tickets);
	}

}