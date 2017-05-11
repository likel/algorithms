package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Binary Search Tree
 */
public class BinarySearchTree {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        boolean isLeftChild;

        public TreeNode(int val) {
            this.val = val;
        }

        public void setLeft(TreeNode node) {
            left = node;
            if (left != null) {
                left.parent = this;
                left.isLeftChild = true;
            }
        }

        public void setRight(TreeNode node) {
            right = node;
            if (right != null) {
                right.parent = this;
                right.isLeftChild = false;
            }
        }

        @Override
        public String toString() {
            return "val=" + val + " parent=" + (parent == null ? null : parent.val)
                    + " left=" + (left == null ? null : left.val)
                    + " right=" + (right == null ? null : right.val);
        }
    }

    /**
     * Root node of tree
     */
    private TreeNode root;

    private int size;

    public int size() {
        return size;
    }

    public TreeNode find(int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                // Found it
                return node;
            } else if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public TreeNode insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            size = 1;
            return root;
        }
        TreeNode node = root;

        while (true) {
            if (node.val == val) {
                // Already existed, do nothing
                return node;
            } else if (val < node.val) {
                if (node.left == null) {
                    // Create a left child node
                    node.setLeft(new TreeNode(val));
                    ++size;
                    return node.left;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    // Create a right child node
                    node.setRight(new TreeNode(val));
                    ++size;
                    return node.right;
                }
                node = node.right;
            }
        }
    }

    public TreeNode delete(int val) {
        TreeNode node = find(val);
        if (node == null) {
            // Not found
            System.out.println("Not found " + val);
            return null;
        }
        // Node is leaf or only one child
        if (node.left == null || node.right == null) {
            TreeNode child = node.left == null ? node.right : node.left;
            setNode(node, child);
            --size;
            return node;
        }
        // Find the maximum node in left child tree
        TreeNode maxLeft = node.left;
        while (maxLeft.right != null) {
            maxLeft = maxLeft.right;
        }

        // Delete successor
        setNode(maxLeft, maxLeft.left);
        --size;
        setNode(node, maxLeft);
        return node;
    }

    private void setNode(TreeNode node, TreeNode n) {
        if (node == root) {
            if ((root = n) != null) {
                root.parent = null;
            }
        } else {
            TreeNode p = node.parent;
            if (node.isLeftChild) {
                p.setLeft(n);
            } else {
                p.setRight(n);
            }
        }
        if (node.left != null && node.left != n) {
            node.left.parent = n;
            if (n != null) {
                n.left = node.left;
            }
        }
        if (node.right != null && node.right != n) {
            node.right.parent = n;
            if (n != null) {
                n.right = node.right;
            }
        }
    }

    private void print(TreeNode node) {
        if (node == null) return;
        System.out.println(node.toString());
        print(node.left);
        print(node.right);
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        List<Integer> nums = new ArrayList<>();

        int numCount = 100;

        for (int i = 0; i < numCount; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);
        for (int i = 0; i < numCount; i++) {
            System.out.println(nums.get(i));
        }
        System.out.println("Insert start");

        for (int i = 0; i < numCount; i++) {
            tree.insert(nums.get(i));
        }
        tree.print(tree.root);

        System.out.println("Tree size=" + tree.size());
        for (int n : nums) {
            System.out.println("Deleting " + n);
            TreeNode node = tree.delete(n);
            if (node == null) {
                System.out.println("Deleting " + n + " failed. Something is wrong.");
                break;
            }
            System.out.println("Deleted " + node.val);
            tree.print(tree.root);
        }
        System.out.println(tree.size());
    }
}
