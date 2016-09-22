import java.util.*;
public class O399EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> graph = new HashMap<>();
		int i = 0;
		double[] res = new double[queries.length];
		for (String[] equation : equations) {
			if (!graph.containsKey(equation[0])) {
				Map<String, Double> item = new HashMap<>();
				graph.put(equation[0], item);
			}
			if (!graph.containsKey(equation[1])) {
				Map<String, Double> item = new HashMap<>();
				graph.put(equation[1], item);
			}
			Map<String, Double> item = graph.get(equation[0]);
			item.put(equation[1], values[i]);
			graph.put(equation[0], item);

			item = graph.get(equation[1]);
			item.put(equation[0], 1.0 / values[i]);
		    graph.put(equation[1], item);
			i++;
		}
		i = 0;
		for (String[] query : queries) {
			Double singleRes = helper(query[0], query[1], graph, new HashSet<>());
			res[i++] = (singleRes == null) ? -1.0 : singleRes;
		}
		return res;
	}
	public Double helper(String begin, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
		String dup = begin + ":" + end;
		if (visited.contains(dup)) return null;
		if (!graph.containsKey(begin) || !graph.containsKey(end)) return null;
		if (begin.equals(end)) return 1.0;
		Map<String, Double> item = graph.get(begin);
		for (String key : item.keySet()) {
			visited.add(dup);
			Double res = helper(key, end, graph, visited);
			if (res != null) {
				return item.get(key) * res;
			}
			visited.remove(dup);
		}
		return null;
	}	
	
	public static void main(String[] args) {
		O399EvaluateDivision e = new O399EvaluateDivision();
		String[][] equations = {{"a","b"},{"c","d"}};
		double[] values = {1.0,1.0};
		String[][] queries = {{"a","c"},{"b","d"},{"b","a"},{"d","c"}};
		e.calcEquation(equations, values, queries);
	}
}	