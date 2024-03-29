package com.lgq.ds.tree.traversal;

import java.util.Stack;

/**
 * 后续遍历
 * Created by eric on 2018/11/1.
 */
public class PostorderTree {

    public void postOrderRecursive(Node root) {
        if (root != null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postOrderIteration(Node root) {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        // push the root node into first stack.
        s1.push(root);
        while (s1.isEmpty() == false) {
            // take out the root and insert into second stack.
            Node temp = s1.pop();
            s2.push(temp);
            // now we have the root, push the left and right child of root into
            // the first stack.
            if (temp.left != null) {
                s1.push(temp.left);
            }
            if (temp.right != null) {
                s1.push(temp.right);
            }
        }

        // once the all node are traversed, take out the nodes from second stack and print it.
        // System.out.println("Preorder Traversal: ");
        while (s2.isEmpty() == false) {
            System.out.print(s2.pop().data+ " ");
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

        PostorderTree i = new PostorderTree();
        i.postOrderRecursive(root);
        System.out.println();
        i.postOrderIteration(root);
    }
    //from :https://algorithms.tutorialhorizon.com//binary-tree-postorder-traversal-non-recursive-approach/
}
