package listnode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 链表的递归
 *
 * @author huangxiaodong
 * @date 2022/2/10  14:39
 */
@Slf4j
class ReverseTest {

    @Test
    void testReverse() {
        // [1,1,2,3,3]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode.printListNode(reverse(l1));
    }

    @Test
    void testReverseN() {
        // [1,1,2,3,3]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode.printListNode(reverseN(l1, 2));
    }

    @Test
    void testReverseBn() {
        // [1,1,2,3,3]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);

        ListNode.printListNode(reverseBetween(l1, 2, 3));
    }

    /**
     * 反转整个链表
     */
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 将链表的前 n 个节点反转（n <= 链表⻓度）
    // 后驱节点
    ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 反转[m,n]区间的链表
     * node:天啊 太强了
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


}
