<<<<<<< HEAD
/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList();
        //init graph
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        int cnt = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        //directed graph top-sort
        while(!q.isEmpty()){
            int courseNo = q.poll();
            cnt++;
            for(int i=0;i<graph.get(courseNo).size();i++){
                int index = graph.get(courseNo).get(i);
                if(inDegree[index] > 0) inDegree[index]--;
                if(inDegree[index] == 0) q.offer(index);
            }
        }
        return cnt == numCourses;
    }
}
=======
/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    }
}
>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0

