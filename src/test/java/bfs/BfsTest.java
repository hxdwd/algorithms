package bfs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import tree.base.TreeNode;

import java.awt.image.VolatileImage;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 层次遍历
 *
 * @author huangxiaodong
 * @date 2022/2/20  11:13
 */
@Slf4j
public class BfsTest {

    @Test
    void test() {

    }

    /**
     * No.111 树的最下深度
     * <p>
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 2
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * No.752 打开密码锁
     * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * Output: 6
     */
    public int openLock(String[] deadends, String target) {
        // dead end
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        // code has been visited
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        // init value
        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // code is one of deadends
                if (deads.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return count;
                }
                // lock has 4 wheels
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    void bfs(String target) {
        Queue<String> queue = new LinkedList<>();
        // init value
        queue.offer("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // lock has 4 wheels
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    queue.offer(up);
                    queue.offer(down);
                }
            }
        }
    }

    // 将 s[j] 向上拨动⼀次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    // 将 s[i] 向下拨动⼀次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
