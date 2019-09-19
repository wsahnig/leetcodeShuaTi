/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (45.39%)
 * Total Accepted:    188.9K
 * Total Submissions: 416.1K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
class Solution {
    public int numTrees(int n) {
        int []cata = new int[20];
        cata[0] = 1;
        for(int i=1;i<20;i++){
            cata[i] = (int) (cata[i-1] * (4.0*i-2) / (i+1));
        }
        return cata[n];
    }
}

