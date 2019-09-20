/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */
class WordDictionary {
    class Trier {
        Trier[] children = new Trier[26];
        char c;
        boolean isWord;
        public Trier() {}
        public Trier(char val){
            this.c = val;
        }
    }
    private Trier root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root =  new Trier();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trier pointer = root;
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            if(pointer.children[c-'a'] == null){
                pointer.children[c-'a'] = new Trier(c);
            }
            pointer = pointer.children[c-'a'];
        }
        pointer.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trier pointer = root;
        return helper(word,0,pointer);
    }

    private boolean helper(String word,int start,Trier cur){
        if(start == word.length()) return cur.isWord;

        char c = word.charAt(start);

        if(c == '.'){
            for(int i=0; i < 26; i++){
                if(cur.children[i] != null) {
                    if(helper(word,start+1,cur.children[i])){
                        return true;
                    }
                }
            }

        }else {
            if(cur.children[c - 'a'] == null){
                return false;
            } else{
                return helper(word,start+1,cur.children[c-'a']);
            }

        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

