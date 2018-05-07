public class No421 {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Trie root = new Trie();
        for (int num : nums) {
            Trie curNode = root;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Trie curNode = root;
            int tempSum = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit ^ 1] != null) {
                    tempSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                } else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(max, tempSum);
        }
        return max;
    }

    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
}
