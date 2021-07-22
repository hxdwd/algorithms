package listnode;

/**
 * 82 去除一个有序链表的重复值
 *
 * @author huangxiaodong
 * @date 2021/2/4  15:27
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head.next) {
            return head;
        }
        ListNode newHead = head;
        while (null != head) {
            if (head.next.val == head.val) {
                if (null == head.next.next) {
                    return head.next;
                }
                head.next = head.next.next;
                head = head.next.next;
            } else {
                if (null == head.next.next) {
                    return head.next;
                }
                head = head.next;
            }
        }
        return newHead;
    }

    /**
     * 别人的方法，比较不同
     *
     * @param head /
     * @return /
     */
    public static ListNode deleteDuplicatesOthers(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
