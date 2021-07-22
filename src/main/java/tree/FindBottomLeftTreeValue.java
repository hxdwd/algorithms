package tree;

import tree.base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 513.找到树的最左边节点
 *
 * @author huangxiaodong
 * @date 2021/7/15  10:24
 */
public class FindBottomLeftTreeValue {
    /**
     * bfs
     */
    public int findBottomLeftValue(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 表示每一层的第一个node
                if (i == 0) {
                    res = node.val;
                }
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    /**
     * 采用dfs 深度优先
     */
    Map<Integer, Integer> map = new HashMap<>();
    int maxLevel = 0;

    public int findBottomLeftValueDfs(TreeNode root) {
        if (null == root) {
            return 0;
        }
        dfs(root, 0);
        return map.get(maxLevel);
    }

    private void dfs(TreeNode node, int level) {
        if (null == node) {
            return;
        }
        // 当前层数
        int curLevel = level + 1;
        dfs(node.left, curLevel);
        if (curLevel > maxLevel && !map.containsKey(curLevel)) {
            map.put(curLevel, node.val);
            maxLevel = curLevel;
        }
        dfs(node.right, curLevel);
    }

    /**
     * 记录一个牛逼的写法 也是bfs
     */
    public int findLeftMostNode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }
}
