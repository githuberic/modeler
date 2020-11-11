package com.lgq.modeler.ds.tree;

/**
 * Created by eric on 2018/10/31.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
