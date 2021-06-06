/*
 * @lc app=leetcode id=630 lang=java
 *
 * [630] Course Schedule III
 */

// @lc code=start
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);

        int day = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int[] course : courses) {

            day += course[0];

            maxHeap.offer(course[0]);

            if (day > course[1]) {

                day -= maxHeap.poll();//drop the previous courses that took the most time

            }

        }

        return maxHeap.size();  
    }
}
// @lc code=end

