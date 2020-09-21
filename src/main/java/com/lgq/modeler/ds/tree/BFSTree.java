package com.lgq.modeler.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先树遍历
 * Created by eric on 2018/11/1.
 */
public class BFSTree {
    public void levelOrderQueue(Node root) {
        Queue<Node> nodes = new LinkedList<Node>();
        if (root == null) {
            return;
        }
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = (Node) nodes.remove();
            System.out.print(" " + node.data);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        BFSTree i = new BFSTree();
        System.out.println("Breadth First Search : ");
        i.levelOrderQueue(root);
    }

    // from https://algorithms.tutorialhorizon.com//breadth-first-searchtraversal-in-a-binary-tree/
}
