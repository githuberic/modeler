package com.lgq.modeler.ds.tree;

import java.util.Stack;

/**
 * 前序遍历
 * Created by eric on 2018/10/31.
 */
public class PreOrderTree {
    public void preOrderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public void preorderIteration(Node root) {
        Stack<Node> nodeStack = new Stack<Node>();
        int index = 0;
        while (true) {
            System.out.println("Index=" + index++);
            // First print the root node and then add left node
            while (root != null) {
                System.out.print(root.data + " ");
                nodeStack.push(root);
                root = root.left;
            }

            // check if Stack is emtpy, if yes, exit from everywhere
            if (nodeStack.isEmpty()) {
                return;
            }
            // pop the element from the stack and go right to the tree
            root = nodeStack.pop();
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        PreOrderTree i = new PreOrderTree();
        i.preOrderRecursive(root);
        System.out.println();
        i.preorderIteration(root);
    }
    // from https://algorithms.tutorialhorizon.com//binary-tree-preorder-traversal-non-recursive-approach/
}
