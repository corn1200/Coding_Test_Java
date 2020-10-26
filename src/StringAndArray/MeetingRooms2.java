package StringAndArray;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
    static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Interval in1 = new Interval(5,10);
        Interval in2 = new Interval(15,20);
        Interval in3 = new Interval(0,30);

        Interval[] intervals = {in1, in2, in3};
        MeetingRooms2 a = new MeetingRooms2();
        System.out.println(a.solve2(intervals));
    }

    public int solve2(Interval[] intervals) {
        if (intervals == null || intervals.length==0) return 0;

        Arrays.sort(intervals, (a,b) -> (a.start - b.start));

        Queue<Interval> minHeap = new PriorityQueue<>(intervals.length, (a,b) -> (a.end - b.end));
        int max = 0;

        for (int i = 0; i < intervals.length; i++) {
            while (!minHeap.isEmpty() && minHeap.peek().end <= intervals[i].start) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i]);
            max = Math.max(max, minHeap.size());
        }
        return max;
    }
}
