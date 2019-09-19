<<<<<<< HEAD
import java.util.Comparator;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (35.25%)
 * Total Accepted:    331.2K
 * Total Submissions: 937K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        List<Interval> list = new ArrayList<Interval>();
        for(int i=0;i<intervals.length;i++){
            Interval inter = new Interval();
            inter.start = intervals[i][0];
            inter.end = intervals[i][1];
            list.add(inter);
        }
        Collections.sort(list,new Comparator<Interval>() {
            @Override
            public int compare(Interval o1,Interval o2){
                return o1.start - o2.start;
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        Interval curr = list.get(0);
        for(Interval iter: list){
            if(curr.end >= iter.start) {
                curr.end = Math.max(curr.end,iter.end);
            }else {
                res.add(curr);
                curr = iter; 
            }
        }
        res.add(curr);
        int len = res.size();
        int [][]ans = new int[len][];
        for(int i=0;i<len;i++){
            ans[i] = new int[2];
            ans[i][0] = res.get(i).start;
            ans[i][1] = res.get(i).end;
        }
        return ans;
    }
}
=======
/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        
    }
}
>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0

