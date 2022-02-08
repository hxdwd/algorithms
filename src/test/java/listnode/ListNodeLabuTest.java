package listnode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 链表相关题目
 *
 * @author huangxiaodong
 * @date 2022/2/8  15:12
 */
@Slf4j
public class ListNodeLabuTest {

    @Test
    void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(12, Comparator.comparingInt(a -> a));

        queue.add(13);
        queue.add(3);
        queue.add(2);

        log.info("弹出最小值：{}", queue.poll());

    }

    /**
     * No.23 合并K个升序链表
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        // 最小堆 每次弹出lists中最小的数
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            // 优先队列确保每次poll的都是最小值
            ListNode cur = queue.poll();
            p.next = cur;
            if (cur.next != null) {
                queue.add(cur.next);
            }
            p = p.next;
        }
        return pre.next;
    }

    /**
     * 学习下别人的递归用法
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return mL(lists, 0, lists.length - 1);
    }

    private ListNode mL(ListNode[] lists, int l, int r) {
        if (r < l) return null;
        if (r == l) return lists[r];

        int mid = (l + r) / 2;
        ListNode a = mL(lists, l, mid), b = mL(lists, mid + 1, r);
        ListNode dmHead = new ListNode(0), cur = dmHead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;

        return dmHead.next;
    }
}