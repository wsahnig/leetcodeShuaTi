<<<<<<< HEAD
/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        int flag = 0;
        for(int i=0; i<nums.length; i++){
            s[i] = nums[i] + "";
            if(nums[i]!=0) flag = 1;
        }
        if(flag == 0) return "0";
        Arrays.sort(s, new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                String s1 = o2 + o1;
                String s2 = o1 + o2;
                return s1.compareTo(s2); 
            }
        });
        String ans = "";
        for(int i=0;i<s.length;i++){
            ans += s[i];
        }
        return ans;
    }
}
=======
/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */
class Solution {
    public String largestNumber(int[] nums) {
        
    }
}
>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0

