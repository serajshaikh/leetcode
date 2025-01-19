import java.util.Arrays;

public class Solution {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }
}



// public class Solution {
//     public static class Interval {
//         int start;
//         int end;
//         int position;
//         Interval(int start, int end, int position) {
//             this.start = start;
//             this.end = end;
//             this.position = position;
//         }

//         @Override
//     public String toString() {
//         return "[" + start + ", " + end + "]";
//         }

//     }
//     public static class SortWithEndTime implements Comparator<Solution.Interval> {
//         public int compare(Interval a, Interval b) {
//             return a.end - b.end;
//         } 
//     }

//     public static int eraseOverlapIntervals(int[][] intervals) {

//         List<Interval> intervalList = new ArrayList<>();

//         for(int i = 0; i < intervals.length; i++) {
//             intervalList.add(new Interval(intervals[i][0], intervals[i][1], i));
//         }
//         if(intervals.length == 0) {
//             return 0;
//         }
//         // Sort the intervals by end time
//         Collections.sort(intervalList, new SortWithEndTime());

//         int count = 1;
//         int end = intervalList.get(0).end;
//         for(int i = 1; i < intervalList.size(); i++) {
//             System.out.println(intervalList.get(i).start+ " "+end+ " "+ i);
//             if(intervalList.get(i).start>=end){
//                 count++;
//                 end = intervalList.get(i).end;
//             }
//         }
//         System.out.println(intervalList);
//         System.out.println(count);
//         return intervals.length-count;
//     }
// }