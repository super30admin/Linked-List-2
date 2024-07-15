
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * TC --> O(n)
 * Sc --> O(1)
 */
class Solution {

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode middle = findMiddle(head);
        //we recieve middle element here

        middle.next = reverse(middle.next);
        System.out.print(middle.val);
        ListNode first = head;
        ListNode second = middle.next;
        ListNode firstNext = first.next;
        ListNode secondNext = second.next;
        while (first != middle) {

            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
            firstNext = firstNext.next;
            if (secondNext != null) {
                secondNext = secondNext.next;
            }

        }//while
        first.next = second;

    }//method

    public ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;

            } else {

                break;

            }

        }//while

        return slow;

    }//method

    public ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        ListNode nextNode = root.next;
        while (nextNode != null) {
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }//while
        curr.next = prev;
        prev = curr;
        return prev;
    }
}//class
