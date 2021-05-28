package leetcode;

/**
 * @author drone
 * @date 2021/5/29
 */
class Q208 {
    class Trie {
        private Trie[] children;
        private boolean isLeaf;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new Trie[26];
            isLeaf = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';

                //子节点不存在。创建一个新的子节点，记录在 children 数组的对应位置上，然后沿着指针移动到子节点，继续搜索下一个字符。
                if (null == node.children[index]) {
                    node.children[index] = new Trie();
                }
                //子节点存在。沿着指针移动到子节点，继续处理下一个字符。
                node = node.children[index];
            }
            node.isLeaf = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return null != node && node.isLeaf;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return null != node;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                //子节点不存在。说明字典树中不包含该前缀，返回空指针。
                if (null == node.children[index]) {
                    return null;
                }
                //子节点存在。沿着指针移动到子节点，继续搜索下一个字符。
                node = node.children[index];
            }
            return node;
        }
    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}