import java.util.List;
import java.util.ArrayList;

public class O057InsertInterval {
	class Interval {
		int start;
		int end;
		public Interval(){
			start = 0; end = 0;
		}
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				res.add(interval);
			}
			else if (newInterval.end < interval.start) {
				res.add(newInterval);
				newInterval = interval;
			}
			else if (interval.end >= newInterval.start || newInterval.end >= interval.start) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start),
										   Math.max(interval.end, newInterval.end));
			}
		}
		res.add(newInterval);
		return res;
	}
	
	public static void main(String[] args) {
		O057InsertInterval e = new O057InsertInterval();
		List<Interval> intervals = new ArrayList<>();
		Interval newInterval = e.new Interval(5, 7);
		e.insert(intervals, newInterval);
		
	}
}