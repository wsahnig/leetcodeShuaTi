/*
 * @lc app=leetcode id=869 lang=java
 *
 * [869] Reordered Power of 2
 */

// @lc code=start
class Solution {
    public boolean reorderedPowerOf2(int N) {
        String A = sortCvt(N);
        for (int i = 0; i < 31; ++i)
            if (A.equals(sortCvt(1 << i)))
                return true;
        return false;
    }

    private String sortCvt(int N) {
        char[] num = String.valueOf(N).toCharArray();
        Arrays.sort(num);
        return String.valueOf(num);
    }
}
// @lc code=end

