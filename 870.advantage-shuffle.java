/*
 * @lc app=leetcode id=870 lang=java
 *
 * [870] Advantage Shuffle
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Queue<Integer>> assigned = new HashMap();
        for (int b: B) assigned.put(b, new LinkedList());

        // remaining = list of a that are not assigned to any b
        Queue<Integer> remaining = new LinkedList();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).offer(a);
            } else {
                remaining.offer(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).poll();
            else
                ans[i] = remaining.poll();
        }
        return ans; 
    }
}
// @lc code=end

