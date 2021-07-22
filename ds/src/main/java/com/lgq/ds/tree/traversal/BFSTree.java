package com.lgq.ds.tree.traversal;

import java.util.Arrays;
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

    /**
     * 构建二叉树
     *
     * @param inputList 输入序列
     */
    public static Node createBinaryTree(LinkedList<Integer> inputList) {
        Node node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new Node(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public static void main(String[] args) throws Exception {
        /*
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);*/

        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4,}));
        Node root = createBinaryTree(inputList);

        BFSTree i = new BFSTree();
        System.out.println("Breadth First Search : ");
        i.levelOrderQueue(root);
    }

    // from https://algorithms.tutorialhorizon.com//breadth-first-searchtraversal-in-a-binary-tree/
}
