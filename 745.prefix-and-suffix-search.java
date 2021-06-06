/*
 * @lc app=leetcode id=745 lang=java
 *
 * [745] Prefix and Suffix Search
 */

// @lc code=start
class WordFilter {
    Map<String, Integer> hm = new HashMap<>();
    
    public WordFilter(String[] words) {
      for(int k=0; k<words.length; k++)
      {
          String s = words[k];
          int len = s.length();
          for(int i=0; i<=len; i++){
             for(int j=0; j<=len; j++) {
                 String key = s.substring(0,i)+"#"+s.substring(len-j);
                 hm.put(key, k);
             }
          }
      }
    }
    
    public int f(String prefix, String suffix) {
        String findKey = prefix + "#" + suffix;
        return hm.getOrDefault(findKey, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
// @lc code=end

