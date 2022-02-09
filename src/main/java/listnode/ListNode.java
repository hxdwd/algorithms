package listnode;

/**
 * 链表实体类
 *
 * @author huangxiaodong
 * @date 2021/2/4  15:28
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

    public static void printListNode(ListNode node) {
        System.out.print("[ ");
        while (null != node) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("]");
    }
}
