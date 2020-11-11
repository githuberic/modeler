package com.lgq.modeler.ds.tree.traversal.depth;

import com.lgq.modeler.ds.tree.Node;

/**
 * @author lgq
 */
public class MinMaxDepth {
    public int minDepth(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null || node.right == null) {
            return Math.max(minDepth(node.left), minDepth(node.right)) + 1;
        }
        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        /*
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4,}));
        BinaryTreeTraversal.TreeNode treeNode = createBinaryTree(inputList);*/

        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        //root.right.left = new Node(30);
        //root.right.right = new Node(35);

        MinMaxDepth maxDepth = new MinMaxDepth();
        System.out.println("min depth=" + maxDepth.minDepth(root));
        System.out.println("max depth=" + maxDepth.maxDepth(root));
    }
}
