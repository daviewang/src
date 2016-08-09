import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class O253MeetingRoomsII {
	class Interval {
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public int meetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Comparator<Interval> cp = new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		};
		Arrays.sort(intervals, cp);
		
		Comparator<Interval> cpPQ = new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		};
		PriorityQueue<Interval> pq = new PriorityQueue<>(10, cpPQ);
		pq.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval interval = pq.poll();
			if (interval.end <= intervals[i].start) {
				interval.end = intervals[i].end;
			}
			else {
				pq.offer(intervals[i]);
			}
			pq.offer(interval);
		}
		return pq.size();
	}
	public static void main(String[] args) {
		O253MeetingRoomsII e = new O253MeetingRoomsII();
		Interval a = e.new Interval(0, 5);
		Interval b = e.new Interval(3, 7);
		Interval c = e.new Interval(4, 9);
		Interval[] intervals = {a, b, c};
		e.meetingRooms(intervals);
	}
}