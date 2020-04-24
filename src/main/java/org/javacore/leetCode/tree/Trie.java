package org.javacore.leetCode.tree;

/**
 * @program: java-core-learning-example
 * @description: trie
 * @author: znq
 * @create: 2020-02-04 15:46
 **/
public class Trie {

    private TrieNode root;


    public Trie() {
        this.root = new TrieNode();
        root.c = ' ';
    }

    public void add(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean contains(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean isPrefix(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        String abd = "abd";
        String abdd = "abdd";
        Trie trie = new Trie();
        trie.add(abd);
        trie.add(abdd);
        System.out.println(trie.contains(abd));
        System.out.println(trie.contains("2233"));
    }

    class TrieNode {

        public char c;

        public boolean isWord;

        public TrieNode[] children = new TrieNode[256];

        public TrieNode() {
        }

        public TrieNode(char c) {
//            TrieNode trieNode = new TrieNode();
            this.c = c;
        }
    }
}
