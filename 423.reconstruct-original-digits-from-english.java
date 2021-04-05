/*
 * @lc app=leetcode id=423 lang=java
 *
 * [423] Reconstruct Original Digits from English
 */

// @lc code=start
class Solution {
    public String originalDigits(String s) {
        int[] counts = new int[10];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'o') {
                counts[1]++;//2,4,0
            }
            if (s.charAt(i) == 'w') {
                counts[2]++;
            }
            if (s.charAt(i) == 'h') {
                counts[3]++;//8
            }
            if (s.charAt(i) == 'u') {
                counts[4]++;
            }
            if (s.charAt(i) == 'f') {
                counts[5]++;//4
            }
            if (s.charAt(i) == 'x') {
                counts[6]++;
            }
            if (s.charAt(i) == 'v') {
                counts[7]++;//5
            }
            if (s.charAt(i) == 'g') {
                counts[8]++;
            }
            if (s.charAt(i) == 'i') {
                counts[9]++;//5,6,8
            }
            if (s.charAt(i) == 'z') {
                counts[0]++;
            }
        }

        counts[3] -= counts[8];
        counts[5] -= counts[4];
        counts[7] -= counts[5];
        counts[1] = counts[1] - (counts[2] + counts[4] + counts[0]);
        counts[9] = counts[9] - (counts[5] + counts[6] + counts[8]);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < counts[i]; j++) {
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }
}
// @lc code=end

