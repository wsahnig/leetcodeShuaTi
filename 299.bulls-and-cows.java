import java.util.HashMap;

/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int len = secret.length();
        HashMap<Character,Integer> hm = new HashMap();
        
        for(int i=0; i<len ; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
            else hm.put(secret.charAt(i),hm.getOrDefault(secret.charAt(i), 0)+1);
        }

        for(int i=0;i<len;i++){
            if(secret.charAt(i) != guess.charAt(i) &&
            hm.getOrDefault(guess.charAt(i),0) != 0 ){   
                    cows++;
                    hm.put(guess.charAt(i),hm.get(guess.charAt(i))-1);
            }                    
        }
    
        return bulls + "A" + cows + "B";
    }
}

