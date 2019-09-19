<<<<<<< HEAD
/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        
    }
}

=======
/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        return num != 0 && (num &(num -1)) == 0
        && (num & 0x55555555) != 0;
    }
}

>>>>>>> a47453625bbbdf482e37c42ed676631540a140d0
