package listnode;

import org.junit.Test;

/**
 * 测试
 *
 * @author huangxiaodong
 * @date 2021/2/4  10:14
 */
public class MergeTwoListsTest {

    @Test
    public void mergeTwoLists() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l4.next = l5;
        l5.next = l6;

        printListNode(MergeTwoLists.mergeTwoLists(l1,l4));
    }

    public void printListNode(ListNode node) {
        System.out.print("[ ");
        while (null != node) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("]");
    }
}