package com.lgq.modeler.ds.tree.binarysearch;

/**
 * Created by eric on 2019/1/9.
 *
 * @author shaofeng
 */
public class BinarySearchTree {
    private Node node;

    public Node find(Integer data) {
        Node p = node;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 如果要插入的数据比节点的数据大，并且节点的右子树为空，就将新数据直接插到右子节点的位置；
     * 如果不为空，就再递归遍历右子树，查找插入位置。
     * 如果要插入的数据比节点数值小，并且节点的左子树为空，就将新数据插入到左子节点的位置；
     * 如果不为空，就再递归遍历左子树，查找插入位置。
     *
     * @param data
     */
    public void insert(int data) {
        if (node == null) {
            node = new Node(data);
            return;
        }

        Node p = node;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 第一种情况是，如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为 null。比如图中的删除节点 55。
     * <p>
     * 第二种情况是，如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。比如图中的删除节点 13。
     * <p>
     * 第三种情况是，如果要删除的节点有两个子节点，这就比较复杂了。我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可以应用上面两条规则来删除这个最小节点。比如图中的删除节点 18。
     *
     * @param data
     */
    public void delete(int data) {
        // p 指向要删除的节点，初始化指向根节点
        Node p = node;
        // pp 记录的是 p 的父节点
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            // 没有找到
            return;
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // 查找右子树中最小节点
            Node minP = p.right;
            // minPP 表示 minP 的父节点
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将 minP 的数据替换到 p 中
            p.data = minP.data;
            // 下面就变成了删除 minP 了
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p 的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            // 删除的是根节点
            node = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public Node findMin() {
        if (node == null) {
            return null;
        }
        Node p = node;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (node == null) {
            return null;
        }
        Node p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
}
