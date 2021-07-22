package com.lgq.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 *
 * @author lgqs
 * from https://github.com/azl397985856/leetcode/blob/master/problems/104.maximum-depth-of-binary-tree.md
 */
public class TreeMaxDepth {

    public static void main(String args[]) {
        TreeMaxDepth treeMaxDepth = new TreeMaxDepth();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);
        System.out.println(" Tree depth : " + treeMaxDepth.maxDepth(root));
    }

    public int maxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(treeNode);
        int res = 0;
        while (!queue.isEmpty()) {
            // 拿出该层所有节点，并压入子节点
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size -= 1;
            }
            // 统计层数
            res += 1;
        }
        return res;
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
