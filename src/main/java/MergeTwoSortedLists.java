package main.java;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * 12/22/2018
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode preHead = newHead;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    preHead.next = new ListNode(l1.val);
                    preHead = preHead.next;
                    l1 = l1.next;
                } else {
                    preHead.next = new ListNode(l2.val);
                    preHead = preHead.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null && l2 == null) {
                preHead.next = l1;
                break;
            }
            if (l1 == null) {
                preHead.next = l2;
                break;
            }
        }
        newHead = newHead.next;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        //l3.next = m1;
        m1.next = m2;
        m2.next = m3;

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode result = solution.mergeTwoLists(l1, m1);
        System.out.println(result);
    }


}
