package tree;

import org.junit.jupiter.api.Test;
import tree.base.TreeNode;

public class FindBottomLeftTreeValueTest {

    @Test
    public void findBottomLeftValue() {
        FindBottomLeftTreeValue value = new FindBottomLeftTreeValue();
        System.out.println(value.findBottomLeftValue(getTreeNode()));
    }

    @Test
    public void findBottomLeftValueDfs() {
        FindBottomLeftTreeValue value = new FindBottomLeftTreeValue();
        System.out.println(value.findBottomLeftValueDfs(getTreeNode()));


        System.out.println(value.findLeftMostNode(getTreeNode()));
    }

    private TreeNode getTreeNode() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        return root;
    }
}