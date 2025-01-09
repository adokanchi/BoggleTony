public class Trie {
    private Node root;

    public Trie() {
        root = new Node("");
    }

    private class Node {
        private String s;
        private Node[] nodes;

        public Node(String str) {
            s = str;
            nodes = new Node[26];
        }
    }

    public void add(String s) {
        // TODO
    }
}
