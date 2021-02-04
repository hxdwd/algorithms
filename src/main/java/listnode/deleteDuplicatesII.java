package listnode;

/**
 * 88 去除一个有序链表的重复值 不保留
 *
 * @author huangxiaodong
 * @date 2021/2/4  16:15
 */
public class deleteDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = head, cur;
        while (null != pre.next) {
            cur = pre.next;
            // TODO: 2021/2/4 88题
        }
        return null;
    }
}
