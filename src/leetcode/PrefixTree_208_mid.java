package leetcode;

import java.util.Locale;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrefixTree_208_mid {


    static class Trie {
        private boolean isEnd;
        private Trie[] children;
        /** Initialize your data structure here. */
        public Trie() {
            isEnd = false;
            children = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null) return;
            word = word.toLowerCase();
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                int index = letter - 'a';
                if (node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (word == null) return false;
            word = word.toLowerCase();
            Trie endNode = searchTrie(word);
            return endNode != null && endNode.isEnd;
        }


        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (prefix == null) return false;
            prefix = prefix.toLowerCase();
            Trie endNode = searchTrie(prefix);
            return endNode != null;
        }

        private Trie searchTrie(String word){
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                int index = letter - 'a';
                if (node.children[index] == null){
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("HelloWorld");
        System.out.println(obj.search("Hello"));
        System.out.println(obj.startsWith("Hello"));
        System.out.println(obj.search("HelloWorld"));
        System.out.println(obj.search("HelloWorlda"));
    }
}
