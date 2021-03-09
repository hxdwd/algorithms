package listnode;

/**
 * 反转链表
 *
 * @author huangxiaodong
 * @date 2021/3/9  19:43
 */
public class ReverseLinkedList {
    public static ListNode reverseBetween(ListNode head) {
        ListNode pre = null, cur = head, next;
        while (null != cur.next) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }

}
