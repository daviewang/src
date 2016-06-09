import java.util.Arrays;
import java.util.Comparator;

public class O252MeetingRooms {
	class Interval {
		int start, end;
		Interval(int x, int y) {
			start = x;
			end = y;
		}
		Interval() {}
	}
	public boolean canAttendMeeting(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return true;
		}
		Comparator<Interval> cp = new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				if (a.start != b.start) {
					return a.start - b.start;
				}
				else {
					return a.end - b.end;
				}
			}
		};
		Arrays.sort(intervals, cp);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1].end > intervals[i].start) {
				return false;
			}
		}
		return true;
	}
}