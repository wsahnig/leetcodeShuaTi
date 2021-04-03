/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */
class Solution {
    public int coinChange2(int[] coins, int amount) {
        int[]amounts = new int[amount+1];
        Arrays.sort(coins);
        int len = coins.length;
        for(int i=1;i<=amount;i++)
        {
            amounts[i] = -1;
            for(int j=0;j<len;j++)
            {
                if(i<coins[j]) break;
                if(amounts[i-coins[j]] != -1){
                    amounts[i] = amounts[i]==-1 ?  amounts[i-coins[j]]+1 :  Math.min(amounts[i], amounts[i-coins[j]]+1);
                }
            }
        }
        return amounts[amount];
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int cnt = amount / coins[0] + 1; 
        int[] arr = new int[amount+1];
        arr[0] = 0;
        for(int i=1;i<=amount;i++){
            arr[i] = cnt;
        }
        
        for(int i=0;i<coins.length;i++){
            int tmp = coins[i];
            for(int j=tmp;j<=amount;j++){
               if(arr[j-tmp] + 1 < arr[j]){
                   arr[j] = arr[j-tmp] + 1;
               }
            }
        }

        return arr[amount] == cnt ? -1 : arr[amount];
    }
}

