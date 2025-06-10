/*
 * @lc app=leetcode.cn id=208 lang=java
 * @lcpr version=30204
 *
 * [208] 实现 Trie (前缀树)
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start


class Trie {
    class TireNode {
        TireNode[] subListNodes;
        boolean isEndOfWord;

        public TireNode() {
            subListNodes = new TireNode[26];
            isEndOfWord = false;
        }
    }

    private TireNode root;

    public Trie() {
        root = new TireNode();
    }

    public void insert(String word) {
        TireNode curr = root;
        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if (curr.subListNodes[ch - 'a'] == null) {
                curr.subListNodes[ch - 'a'] = new TireNode();
            }
            curr = curr.subListNodes[ch - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TireNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TireNode node = searchPrefix(prefix);
        return node != null;
    }

    private TireNode searchPrefix(String prefix) {
        TireNode curr = root;
        char[] chs = prefix.toCharArray();
        for (char ch : chs) {
            if (curr.subListNodes[ch - 'a'] == null) {
                return null;
            }
            curr = curr.subListNodes[ch - 'a'];
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
