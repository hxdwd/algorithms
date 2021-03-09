package listnode;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * 反转链表 2
 *
 * @author huangxiaodong
 * @date 2021/3/9  19:05
 */
public class ReverseLinkedList2 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode pre = null, cur = head, next;
        int count = 1;
        while (count <= right) {
            // 开始反转
            if (count >= left) {
                next = cur.next;

            }
        }
        return null;
    }
}
