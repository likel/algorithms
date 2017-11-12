package algorithms.tree.segmenttree;


/**
 * Segment tree
 */
public class SegmentTree {

    private static class Node {
        private int maxValue;
        private int begin, end;
        private Node left;
        private Node right;

        Node(int maxValue, int l, int r) {
            this.maxValue = maxValue;
            this.begin = l;
            this.end = r;
        }
    }

    private Node[] nodes;
    private int size;

    public SegmentTree(int[] arr) {
        this.size = arr.length;
        this.nodes = new Node[this.size * 2];
        this.buildTree(0, arr, 0, this.size - 1);
    }

    private Node buildTree(int root, int[] arr, int begin, int end) {
        if (begin > end)
            throw new IllegalArgumentException();
        if (begin == end) {
            nodes[root] = new Node(arr[begin], begin, end);
        } else {
            int median = (begin + end) / 2;
            int l = root * 2 + 1, r = root * 2 + 2;
            Node left = buildTree(l, arr, begin, median);
            Node right = buildTree(r, arr, median + 1, end);
            int maximum = Math.max(nodes[l].maxValue, nodes[r].maxValue);
            nodes[root] = new Node(maximum, begin, end);
            nodes[root].left = left;
            nodes[root].right = right;
        }
        return nodes[root];
    }

    private int max(Node root, int begin, int end) {
        if (!(root.begin <= begin && root.end >= end))
            throw new IllegalArgumentException();
        if (root.begin == end && root.end == begin)
            return root.maxValue;
        if (root.left.end < begin)
            return max(root.right, begin, end);
        else if (root.right.begin > end)
            return max(root.left, begin, end);
        else
            return Math.max(max(root.left, begin, root.left.end),
                    max(root.right, root.right.begin, end));
    }

    public int max(int begin, int end) {
        if (begin < 0 || end >= size || begin > end)
            throw new IllegalArgumentException();
        if (begin == end)
            return nodes[begin].maxValue;
        else {
            return max(nodes[0], begin, end);
        }
    }
}
