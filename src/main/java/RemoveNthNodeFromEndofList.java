package main.java;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 */
class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int deepth = 0;
        deepth = getDeepth(head);
        ListNode newHead = head;
        ListNode preHead = null;
        if(deepth == n) {
            return head = head.next;
        }
        for (int i = 0; i < deepth-n; i++) {
            if(i == deepth - n - 1) {
                preHead = newHead;
            }
            if (newHead.next != null) {
                newHead = newHead.next;
            }
        }
        preHead.next = preHead.next.next;
        return head;
    }

    int getDeepth(ListNode node) {
        int i=1;
        if(node.next != null) {
            node = node.next;
            i = i + getDeepth(node);
        }
        return i;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        ListNode m1 = new ListNode(4);
        ListNode m2 = new ListNode(5);
        ListNode m3 = new ListNode(4);
        l1.next = l2;
        //l2.next = l3;
        //l3.next = m1;
        //m1.next = m2;
        //m2.next = m3;

        RemoveNthNodeFromEndofList solution = new RemoveNthNodeFromEndofList();
        ListNode result = solution.removeNthFromEnd(l1, 1);
        System.out.println(result);
    }

}

