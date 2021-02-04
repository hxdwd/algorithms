package listnode;

/**
 * 链表实体类
 *
 * @author huangxiaodong
 * @date 2021/2/4  10:14
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
}
