package com.lgq.modeler.ds.tree.traversal;

/**
 * Created by eric on 2018/10/31.
 */
public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
