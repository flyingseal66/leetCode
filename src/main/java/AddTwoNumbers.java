package main.java;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @date 12/21/2018
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode tempHead = null;
        resultNode = new ListNode((l1.val + l2.val)%10);
        tempHead = resultNode;
        int extraValue = (l1.val + l2.val) >= 10 ? 1:0;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
                if (l2 != null && l1 ==null){
                    tempHead.next = new ListNode((l2.val + extraValue)%10);
                    extraValue = l2.val + extraValue >= 10 ? 1:0;
                    l2 = l2.next;
                } else if (l1 != null && l2 == null) {
                    tempHead.next = new ListNode((l1.val + extraValue)%10);
                    extraValue = l1.val + extraValue >= 10 ? 1:0;
                    l1 = l1.next;
                } else {
                    tempHead.next = new ListNode((l1.val + l2.val + extraValue)%10);
                    extraValue = l1.val + l2.val + extraValue >= 10 ? 1:0;
                    l1 = l1.next;
                    l2 = l2.next;
                }
                tempHead = tempHead.next;
        }

        if (extraValue == 1) {
            tempHead.next = new ListNode(1);
        }
        return resultNode;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        //l1.next = l2;
        //l2.next = l3;

        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        //m2.next = m3;
        AddTwoNumbers solution = new AddTwoNumbers();
        solution.addTwoNumbers(l1, m1);
        System.out.println();
    }

}