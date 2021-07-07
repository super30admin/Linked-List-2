# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No






/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        if(head == null) return;

        ListNode mid = findMid(head);
        ListNode reverse = findReverse(mid.next);

        mid.next = null;

        ListNode cursorA, cursorB;
        cursorA = head;
        cursorB = reverse;
        ListNode nextA, nextB;
        while(cursorB != null){
            nextA = cursorA.next;
            nextB = cursorB.next;

            cursorA.next = cursorB;
            cursorB.next = nextA;

            cursorA = nextA;
            cursorB = nextB;

        }

    }

    private ListNode findReverse(ListNode head){
        ListNode R = null;
        ListNode cursor = head, next;

        while(cursor!= null){
            next = cursor.next;
            cursor.next = R;
            R = cursor;
            cursor = next;

        }
        return R;

    }

    private ListNode findMid(ListNode head){

        ListNode slow, fast;
        slow = head;
        fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;
    }
}