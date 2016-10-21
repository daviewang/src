import java.util.*;
public class O399EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> valuesPair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
        	String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        
        double[] result = new double[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
        	String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) {
				result[i] = -1.0;
			}
        }
        return result;
    }
    
    private double dfs(String start, String end, Map<String, List<String>> pairs, Map<String, List<Double>> values, Set<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);
        
        List<String> strList = pairs.get(start);
        List<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
		
        set.remove(start);
        return tmp;
    }
	/*
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
	*/
	public static void main(String[] args) {
		O399EvaluateDivision e = new O399EvaluateDivision();
		String[][] equations = {{"a","b"},{"c","d"}};
		double[] values = {1.0,1.0};
		String[][] queries = {{"a","c"},{"b","d"},{"b","a"},{"d","c"}};
		e.calcEquation(equations, values, queries);
	}
}	