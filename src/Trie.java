public class Trie {
    private final Node root;

    public Trie() {
        root = new Node();
    }

    private class Node {
        private Node[] nodes;
        boolean isWord;

        public Node() {
            nodes = new Node[26];
            isWord = false;
        }
    }

    public void add(String s) {
        Node current = root;
        for (char c : s.toCharArray()) {
            if (current.nodes[c - 'a'] == null) current.nodes[c - 'a'] = new Node();
            current = current.nodes[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String s) {
        Node current = root;
        for (char c : s.toCharArray()) {
            if (current.nodes[c - 'a'] == null) return false;
            current = current.nodes[c - 'a'];
        }
        return current.isWord;
    }

    public boolean isValidPrefix(String s) {
        Node current = root;
        for (char c : s.toCharArray()) {
            if (current.nodes[c - 'a'] == null) return false;
            current = current.nodes[c - 'a'];
        }
        return true;
    }
}
