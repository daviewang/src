import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class O056MergeIntervals {
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
	
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}
		Comparator<Interval> cp = new Comparator<Interval>(){
			public int compare(Interval item1, Interval item2) {
				if (item1.start != item2.start) {
					return item1.start - item2.start;
				}
				else {
					return item1.end - item2.end;
				}
			}
		};
		
		Interval[] intervalsArray = new Interval[intervals.size()];
		intervals.toArray(intervalsArray);
		Arrays.sort(intervalsArray, cp);
		
		Interval mover = intervalsArray[0];
		for (int i = 1; i < intervalsArray.length; i++) {
			if (mover.end < intervalsArray[i].start) {
				res.add(mover);
				mover = intervalsArray[i];
			}
			else {
				mover.end = Math.max(mover.end, intervalsArray[i].end);
			}
		}
		res.add(mover);
		return res;
	}
}