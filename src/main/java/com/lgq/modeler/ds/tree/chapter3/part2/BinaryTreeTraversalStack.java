package com.lgq.modeler.ds.tree.chapter3.part2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lgq
 */
public class BinaryTreeTraversalStack {

    /**
     * 构建二叉树
     *
     * @param inputList 输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；如果元素非空，继续递归构建该节点的左右孩子。
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraversalWithStack(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !nodeStack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                nodeStack.push(treeNode);
                treeNode = treeNode.left;
            }
            // 如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!nodeStack.isEmpty()) {
                treeNode = nodeStack.pop();
                treeNode = treeNode.right;
            }
        }
    }


    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4,}));
        TreeNode treeNode = createBinaryTree(inputList);
        preOrderTraversalWithStack(treeNode);
    }
}
