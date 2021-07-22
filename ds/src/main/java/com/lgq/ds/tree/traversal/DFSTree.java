package com.lgq.ds.tree.traversal;


import java.util.Stack;

/**
 * 深度优先树遍历
 * Created by eric on 2018/11/1.
 */
public class DFSTree {
    public void DFS(Node root) {
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.add(root);
        while (nodeStack.isEmpty() == false) {
            Node node = nodeStack.pop();
            if (node.right != null) {
                nodeStack.add(node.right);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
            }
            System.out.print(" " + node.data);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        DFSTree b = new DFSTree();
        System.out.println("Depth-First-Search : ");
        b.DFS(root);
    }
    // from https://algorithms.tutorialhorizon.com//depth-first-searchtraversal-in-binary-tree/
}
