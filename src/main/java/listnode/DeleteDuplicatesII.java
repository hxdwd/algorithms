package listnode;

/**
 * 88 去除一个有序链表的重复值 不保留
 *
 * @author huangxiaodong
 * @date 2021/2/4  16:15
 */
public class DeleteDuplicatesII {

    public static ListNode deleteDuplicates2(ListNode head) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        // 长度为2时需要另外判读
        if (null == cur.next) {
            if (pre.val == cur.val) {
                return null;
            } else {
                return head;
            }
        }
        while (null != cur.next) {
            // 如果cur下一个节点相等
            if (cur.val == cur.next.val) {
                // 可能重复值在结尾,需要判断NPE
                if (null == cur.next.next) {
                    pre.next = null;
                    break;
                }
                cur = cur.next.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }

            // 重新指向
            head.next = pre;
        }
        return head;
    }

    /**
     * 上面的代码有致命的错误，无法排除开头重复的链表
     * 而且 代码if/else 太多
     *
     * @param head /
     * @return /
     */
    public static ListNode deleteDuplicates2V2(ListNode head) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode node = pre;
        while (null != head.next) {
            if (head.val != head.next.val) {
                pre.next = head;
                pre = head;
            }
            head = head.next;
        }
        return node.next;
    }

}
