package string;


public class Trie {
    // The number of sub node in each node, assume we only support a-zA-Z
    private static final int MAX_SIZE = 52;
    private Node root;

    private static class Node {
        Node[] slots;
        boolean isLeaf;

        Node setAndGet(char ch) {
            int pos = hash(ch);
            if (slots == null) {
                slots = new Node[MAX_SIZE];
            }
            if (slots[pos] == null) {
                slots[pos] = new Node();
            }
            return slots[pos];
        }

        private int hash(char ch) {
            if (ch >= 'a' && ch <= 'z') {
                return ch - 'a';
            } else if (ch >= 'A' && ch <= 'Z') {
                return ch - 'A' + 26;
            }
            // Should never happen
            return 0;
        }

        Node get(char ch) {
            return slots[hash(ch)];
        }
    }

    public void index(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            root = new Node();
        }
        Node node = root;
        for (char ch : text.toCharArray()) {
            node = node.setAndGet(ch);
        }
        node.isLeaf = true;
    }

    public boolean contains(String text) {
        if (text == null || root == null) {
            return false;
        }
        Node node = root;
        for (char ch : text.toCharArray()) {
            if ((node = node.get(ch)) == null) {
                return false;
            }
        }
        return node.isLeaf;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] strings = new String[]{
                "abc",
                "ABc",
                "rtyddd",
                "x",
        };
        for (String s : strings) {
            trie.index(s);
        }
        for (String s : strings) {
            System.out.println(trie.contains(s));
        }
    }
}
