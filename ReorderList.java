/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
Time Complexity : O(n)
Space Complexity : O(1)
Accepted on LeetCode : Yes
Approach:First, we find middle of the list ,then reverse list from middle part of the list to the end of the list and finally, merge the two lists.
**/

class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        //Find the middle of the list
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        //Reverse the list from middle position
        fast = reverseList(slow.next);

        slow.next = null;
        slow      = head;

        while(slow != null && fast != null){
            ListNode temp  = slow.next;
            slow.next      = fast;
            //fast.next      = temp;
            fast           = fast.next;
            slow.next.next = temp;
            slow           = temp;
        }


    }

    private ListNode reverseList(ListNode node){
        ListNode current = node;
        ListNode prev    = null;
        ListNode fast    = node.next;

        while(fast != null){
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        current.next = prev;
        return current;
    }
}