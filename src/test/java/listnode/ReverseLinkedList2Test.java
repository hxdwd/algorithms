package listnode;


import org.junit.jupiter.api.Test;

/**
 * 测试用例
 *
 * @author huangxiaodong
 * @date 2021/3/9  19:21
 */
public class ReverseLinkedList2Test {

    @Test
    public void reverseLinkedList() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        printListNode(ReverseLinkedList.reverseBetween(l1));
    }


    @Test
    public void reverseBetween2() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        printListNode(ReverseLinkedList2.reverseBetween(l1, 2, 4));
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