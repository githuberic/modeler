package com.lgq.modeler.ds.tree.balancedtree;

import com.lgq.modeler.ds.tree.Node;

/**
 * Created by eric on 2018/9/21.
 *
 * @author lgq
 */
public class BalancedTree {
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
    }

    public static boolean isBalancedNaive(Node root) {
        if (root == null) {
            return true;
        }
        int heightDifference = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDifference) > 1) {
            return false;
        } else {
            return isBalancedNaive(root.left) && isBalancedNaive(root.right);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        System.out.println(" Is Tree Balanced : " + BalancedTree.isBalancedNaive(root));
        root.right.right.right = new Node(40);
        root.right.right.right.right = new Node(45);
        System.out.println(" Is Tree Balanced : " + BalancedTree.isBalancedNaive(root));
    }
}
