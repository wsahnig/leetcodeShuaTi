/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    // 滑动窗口
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int n = s.length(), m = words.length, k = words[0].length();
        if (n == 0 || m == 0 || k == 0)
            return res;
        int wSize = m * k;
        Map<String, Integer> dict = new HashMap<>();
        for(String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) - 1);
        }
        for(int j = 0; j < Math.min(k, n - wSize + 1); j++) { // 枚举窗口的起始位置
            // 初始化窗口内的单词
            Map<String, Integer> newDict = new HashMap<>(dict);
            for(int i = j; i < j + wSize; i += k) {
                String subStr = s.substring(i, i + k);
                int cnt = newDict.getOrDefault(subStr, 0);
                if(cnt == -1) {
                    newDict.remove(subStr);
                }
                else {
                    newDict.put(subStr, cnt + 1);
                }
            }
            if(newDict.size() == 0) {
                res.add(j);
            }
            for(int i = j + wSize; i <= n - k; i += k) { // 滑动窗口，每次窗口滑动一个单词的长度k
                // 右窗口滑动，增加一个单词
                String str1 = s.substring(i, i + k);
                int cnt1 = newDict.getOrDefault(str1, 0);
                if(cnt1 == -1) {
                    newDict.remove(str1);
                }
                else {
                    newDict.put(str1, cnt1 + 1);
                }
                // 左窗口滑动，去掉一个单词
                String str2 = s.substring(i - wSize, i - wSize + k);
                int cnt2 = newDict.getOrDefault(str2, 0);
                if(cnt2 == 1) {
                    newDict.remove(str2);
                }
                else {
                    newDict.put(str2, cnt2 - 1);
                }
                // 检查窗口内的单词数是否与words完全相同
                if(newDict.size() == 0) {
                    res.add(i - wSize + k);
                }
            }
        }

        return res;
    }
    // 暴力解法，时间复杂度较高
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int n = s.length(),m = words.length,k;
        if (n == 0 || m == 0 || (k = words[0].length()) == 0)
            return res;
        int size = m*k;

        Map<String,Integer> dict = new HashMap<>();
        for(String word:words){
            dict.put(word,dict.getOrDefault(word,0)+1);
        }

        Map<String,Integer> curDict = new HashMap<>();
        for(int i=0;i+size <= n;i++){
            curDict.clear();
            int cnt=0;
            for(int j=i;j<i+size;j+=k){
                String sub = s.substring(j,j+k);
                curDict.put(sub,curDict.getOrDefault(sub,0)+1);
                if(!dict.containsKey(sub)){
                    continue;
                }
                if(curDict.get(sub) > dict.get(sub)){
                    continue;
                }
                cnt++;
            }
            if(cnt == m){
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

