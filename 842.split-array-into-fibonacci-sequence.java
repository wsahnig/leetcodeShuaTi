/*
 * @lc app=leetcode id=842 lang=java
 *
 * [842] Split Array into Fibonacci Sequence
 */
class Solution {
    
    private boolean helper(List<Integer> list,int start,String num){
        if(list.size() > 2){
            int len = list.size();
            int x = list.get(len-2);
            int y = list.get(len-3);   
            if(list.get(len-1) != (x + y) ) {
                return false;
            }
            if(start == num.length()) {
                return true; 
            }
        }

        for(int k=start+1;k<=num.length();k++){
            if(num.charAt(start) == '0' && k == start+1 || 
            num.charAt(start) != '0') {
                String sub = num.substring(start,k);
                if(sub.length()<10 || sub.length()==10 && sub.compareTo("2147483647") <= 0){
                    list.add(Integer.parseInt(sub));
                    if(helper(list,k,num)) return true;
                    list.remove(list.size()-1);
                }
            }
        }

        return false;
    }
    
    public List<Integer> splitIntoFibonacci(String num) {
        ArrayList<Integer> list = new ArrayList();
        
        if(num == null || num.length() < 3) return list;
        helper(list,0,num);
        
        return list;
        
    }
}

