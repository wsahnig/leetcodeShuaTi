/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] coursesSeq = new int[numCourses];
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList();
        //init graph
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        int cnt = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int courseNo = q.poll();
            coursesSeq[cnt++] = courseNo;
            for(int i=0;i<graph.get(courseNo).size();i++){
                int index = graph.get(courseNo).get(i);
                if(inDegree[index] > 0) inDegree[index]--;
                if(inDegree[index] == 0) q.offer(index);
            }
        }
        if(cnt == numCourses) return coursesSeq;
        return new int[]{};
    }
}

