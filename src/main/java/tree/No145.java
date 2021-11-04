package tree;

import listnode.ListNode;
import tree.base.TreeNode;

import java.util.*;

/**
 * 145
 *
 * @author huangxiaodong
 * @date 2021/10/25  10:33
 */
public class No145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> list, TreeNode node) {
        if (node == null) {
            return ;
        }
        dfs(list, node.left);
        dfs(list, node.right);
        list.add(node.val);
    }

    /**
     * 利用栈来避免迭代
     */
    private List<Integer> dfsFromStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (node == null) {
            return res;
        }

        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return res;
    }
}
