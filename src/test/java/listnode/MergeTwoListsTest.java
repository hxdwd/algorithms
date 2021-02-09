package listnode;

import org.junit.Test;

/**
 * 测试
 *
 * @author huangxiaodong
 * @date 2021/2/4  10:14
 */
public class MergeTwoListsTest {

    /**
     * 合并两个有序链表
     */
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

    /**
     * test for {@link DeleteDuplicates}
     */
    @Test
    public void deleteDuplicates() {
        // [1,1,2,3,3]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(3);

        printListNode(DeleteDuplicates.deleteDuplicates(l1));
    }

    /**
     * test for {@link DeleteDuplicatesII}
     */
    @Test
    public void deleteDuplicates2() {
        // [1,1,2,3,3]
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
//        l1.next.next.next.next = new ListNode(4);
//        l1.next.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next.next = new ListNode(5);


        // [1,1,1,2,3] 测试用例不通过
//        printListNode(DeleteDuplicatesII.deleteDuplicates2(l1));

//        printListNode(DeleteDuplicatesII.deleteDuplicates2V2(l1));

        printListNode(DeleteDuplicatesII.deleteDuplicates2V3(l1));
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