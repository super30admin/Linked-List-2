/**
 * The time complexity is O(N) and the space complexity is O(1).
 *
 * Here we can change the linked list according to the question by first
 * moving till the half of the list. Then remove the link which connect the linked list from the first to second half. Reverse the second
 * half of the list. Now we move using two pointers where first is connect to second and second is connected to first.next;
 *
 * Yes, the code passed all the test cases in leet code.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        if(head==null){return;}
        ListNode slow = head; ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode second = slow.next; ListNode reversehead = null;
        slow.next = null;

        while(second!=null){
            ListNode next = second.next;
            second.next = reversehead;
            reversehead = second;
            second = next;
        }

        while(reversehead!=null){
            ListNode firstNext = head.next;
            head.next = reversehead;
            ListNode secondNext = reversehead.next;
            reversehead.next = firstNext;
            head = firstNext;
            reversehead = secondNext;
        }
    }
}