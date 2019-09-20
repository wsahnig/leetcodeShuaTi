/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2){
            return 0;
        }
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0],-prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(sell[0],buy[0] + prices[1]);
        for(int i=2;i<n;i++){
            buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        for(int i=0;i<n;i++){
            System.out.println(buy[i] + " : " + sell[i]);
        }
        return sell[n-1];
    }
}

