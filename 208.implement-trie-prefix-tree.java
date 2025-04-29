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
    private class TrieNode {
        TrieNode[] children;

        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currNode = root;
        // 构建树
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (currNode.children[index] == null) { // 为空则创建新节点，否则复用
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }
        currNode.isEndOfWord = true;// isEndOfWord可以完美解决重复路径问题，从根节点到这个节点有且只有一条路径
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public TrieNode searchPrefix(String str) {
        TrieNode currNode = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (currNode.children[index] == null) { // 如果为null则说明没有被insert
                return null;
            }
            currNode = currNode.children[index];// 深度遍历
        }
        return currNode;// 便利完成说明找到完整目标str
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
