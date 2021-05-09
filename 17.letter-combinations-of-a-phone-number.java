/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (40.49%)
 * Total Accepted:    354.3K
 * Total Submissions: 873.1K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    // Map<String,String> phone = new HashMap<String,String>() {{
    //     put("2","abc");
    //     put("3","def");
    //     put("4","ghi");
    //     put("5","jkl");
    //     put("6","mno");
    //     put("7","pqrs");
    //     put("8","tuv");
    //     put("9","wxyz");
    // }};
   
    //List<String> output = new ArrayList<String>();
    
    // public void dfs(String s,String nextdigits){
    //     //字符串遍历完，递归结束
    //     if(nextdigits.length() == 0){
    //          output.add(s);
    //     }
    //     else{
    //         //
    //     String digit = phone.get(nextdigits.substring(0, 1));
    //     //循环每一个待选项
    //     for(int i=0 ; i < digit.length() ;i++){
    //         //拼接
    //         dfs(s + digit.substring(i,i+1),nextdigits.substring(1));
    //     }
    //     }

    // }

    // public List<String> letterCombinations(String digits) {
    //     if(digits.length() != 0){
    //         dfs("",digits);
    //     }
    //     return output;
        
    // }
    private Map<Integer, String> hm = new HashMap<>(){{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};

    private void dfs(List<String> ans, String digits, int index, String cur)
    {
        if(index == digits.length())
        {
            ans.add(cur);
            return;
        }
        int id = digits.charAt(index)-'0';
        String s = hm.get(id);
        for(int i=0; i<s.length(); i++)
        {
            dfs(ans, digits, index+1, cur+s.charAt(i));
        }
    }
    
    public List<String> letterCombinations(String digits) {
       List<String> ans = new ArrayList<>();
       if(digits.length() == 0) return ans;
       dfs(ans, digits, 0, "");
       return ans;
    }
}

