/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
      List<String> ret = new ArrayList<>();
      int[] path = new int[4];
      helper(ret,s,0,path,0);
      return ret;
    }

    void helper(List<String> acc,String s,int idx,int[] path,int segment){
      if(segment == 4 && idx == s.length()){
          acc.add(path[0] + "." + path[1] + "." +path[2] + "." + path[3]);
          return ;
      }else if(segment == 4 || idx == s.length()){
          return ;
      }
      for(int len = 1; len <= 3 && idx + len <= s.length() ; len++){
          int val = Integer.parseInt(s.substring(idx,idx + len));

          if(val > 255 || len >= 2 && s.charAt(idx) == '0'){
              break;
          }

          path[segment] = val;
          helper(acc,s,idx+len,path,segment+1);      
      }
    }
}

