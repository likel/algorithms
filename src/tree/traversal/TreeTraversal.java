package tree.traversal;


import java.util.LinkedList;
import java.util.Queue;


public class TreeTraversal {

    private static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    private void processNode(Node node) {
        System.out.println(node.val);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        // process 
        processNode(root);
        inOrder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        processNode(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        processNode(root);
    }

    public void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            processNode(front);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        TreeTraversal traversaler = new TreeTraversal();
        traversaler.preOrder(node1);
        traversaler.inOrder(node1);
        traversaler.postOrder(node1);
        traversaler.levelOrder(node1);
    }
}
