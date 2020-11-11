package com.lgq.modeler.ds.tree.traversal;

import java.util.Stack;

/**
 * 中序遍历
 *
 * @author lgq
 */
public class InorderTree {
    public void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public void inorderIteration(Node root) {
        Stack<Node> nodeStack = new Stack<Node>();
        while (true) {
            // Go to the left extreme insert all the elements to stack
            while (root != null) {
                nodeStack.push(root);
                root = root.left;
            }

            // check if Stack is empty, if yes, exit from everywhere
            if (nodeStack.isEmpty()) {
                return;
            }

            // pop the element from the stack , print it and add the nodes at
            // the right to the Stack
            root = nodeStack.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        InorderTree i = new InorderTree();
        i.inorderRecursive(root);
        System.out.println();
        i.inorderIteration(root);
    }

    // from https://algorithms.tutorialhorizon.com//inorder-traversal-non-recursive-approach/
}
