/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */
class Solution {
    
    private int[] convert(String s){
        String[] str = s.split("\\.");
        int[] ans = new int[190];
        for(int i=0;i<str.length;i++){
           ans[i] = Integer.parseInt(str[i]);
        }
        for(int i=str.length;i<190;i++){
           ans[i] = 0;
        }
        return ans;
    }

    private int compare(int[] a,int[] b){
        for(int i=0;i<190;i++){
            if(a[i] < b[i]) return -1;
            else if(a[i] > b[i]) return 1;
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        if("".equals(version1)) return -1;
        if("".equals(version2)) return 1;
        int[] a1 = convert(version1);
        int[] a2 = convert(version2);
        return compare(a1,a2);
    }
}

