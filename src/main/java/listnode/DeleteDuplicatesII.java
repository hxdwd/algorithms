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

        ListNode note = new ListNode();
        ListNode preHead = note;
        while (null != head.next) {
            if (head.val == head.next.val) {
                head = head.next.next;
                note.next = head;
            } else {
                note.next = head;
                note = head;
                head = head.next;

            }

        }
        return preHead.next;
    }

    /**
     * 别人的写法 太妙了，还是得用两个指针来跑
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2V3(ListNode head) {
        ListNode preHead = new ListNode(0), fast = head, slow = preHead;
        slow.next = fast;
        while (null != fast) {
            // 跳过重复的值
            while (null != fast.next && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {
                // 核心东西，之前一直没突破的
                // 其实之前也快写出来了，需要一个头节点，然后快慢指针
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return preHead.next;
    }

}
