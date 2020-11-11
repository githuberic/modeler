package com.lgq.modeler.leecode;

/**
 * 将有序数组转换为二叉搜索树
 * to do...不太理解的题目
 *
 * @author lgq
 */
public class SortArr2TreeSearch {

    public TreeNode sortedArrToBST(int[] arr) {
        return build(arr, 0, arr.length - 1);
    }

    private TreeNode build(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr, left, mid - 1);
        root.right = build(arr, mid, right);
        return root;
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
