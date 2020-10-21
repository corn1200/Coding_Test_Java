import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    static class Interval {
        int start;
        int end;

        Interval() {
            this.start = 0;
            this.end = 0;
        }

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        MeetingRooms a = new MeetingRooms();

        Interval int1 = new Interval(15, 20);
        Interval int2 = new Interval(5, 10);
        Interval int3 = new Interval(0, 30);

        Interval[] intervals = {int1, int2, int3};
        System.out.println(a.solve(intervals));
    }

    public boolean solve(Interval[] intervals) {
        if (intervals == null) return false;
        // 1 sorting
        print(intervals);
        Arrays.sort(intervals, Comp);
        System.out.println("===after sort===");
        print(intervals);

        // 2
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }

        return true;
    }

    public void print(Interval[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Interval in = intervals[i];
            System.out.println(in.start + " " + in.end);
        }
    }

    Comparator<Interval> Comp = new Comparator<Interval>() {

        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };
}
