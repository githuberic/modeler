package com.lgq.modeler.ds.tree.chapter3.part2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lgq
 * 二叉树遍历
 */
public class BinaryTreeTraversal {
    public static TreeNode createBinaryTree(LinkedList<Integer> linkedList) {
        TreeNode treeNode = null;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }

        Integer data = linkedList.removeFirst();
        if (data != null) {
            treeNode = new TreeNode(data);
            treeNode.left = createBinaryTree(linkedList);
            treeNode.right = createBinaryTree(linkedList);
        }
        return treeNode;
    }

    public static void preOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println(treeNode.data);
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    public static void inOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraversal(treeNode.left);
        System.out.println(treeNode.data);
        inOrderTraversal(treeNode.right);
    }

    public static void postOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.println(treeNode.data);
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4,}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        preOrderTraversal(treeNode);
        System.out.println("中序遍历：");
        inOrderTraversal(treeNode);
        System.out.println("后序遍历：");
        postOrderTraversal(treeNode);
    }
}
