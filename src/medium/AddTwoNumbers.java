package medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode((l1.val + l2.val) % 10);
        ListNode temp = first;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = (l1.val + l2.val) / 10;  // 进位
        while(true) {
            int a1 = (t1.next == null) ? 0 : t1.next.val;
            int a2 = (t2.next == null) ? 0 : t2.next.val;
            if(t1.next == null && t2.next == null && carry== 0)
                break;

            temp.next = new ListNode((a1 + a2 + carry) % 10);
            carry = (a1 + a2 + carry) / 10;

            temp = temp.next;
            t1 = (t1.next == null) ? t1 : t1.next;
            t2 = (t2.next == null) ? t2 : t2.next;
        }
        return first;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();

        // test case 1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        // test case 2
//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(5);

//        // test case 3
//        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(9);
//        ListNode l2 = new ListNode(1);

        ListNode pr = atn.addTwoNumbers(l1, l2);
        do {
            System.out.print(pr.val + " ");
            pr = pr.next;
        } while (pr != null);
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
