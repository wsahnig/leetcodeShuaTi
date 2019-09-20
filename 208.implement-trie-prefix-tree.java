
/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */
/**
 * 单词树数据结构
 */
 class TrieNode {
     public char val;
     public boolean isWord;
     public TrieNode[] children = new TrieNode[26];
     public TrieNode() {}
     TrieNode(char c){
         this.val = c;
     }   
 } 

 class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;
        for(int i=0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(ws.children[c- 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        ws = helper(word,0,ws);
        return ws == null ? false : ws.isWord;
    }

    private TrieNode helper(String word,int start,TrieNode pointer){
        if(word.length() == start) return pointer;
        char c = word.charAt(start);
        if(pointer.children[c - 'a'] == null) return null;
        return helper(word,start+1,pointer.children[c - 'a']);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        ws = helper(prefix,0,ws);
        return ws == null ? false : true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

