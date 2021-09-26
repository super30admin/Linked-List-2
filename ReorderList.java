// Time Complexity : O(2n + n/2) traversing list first to find mid + traversing half of the list to reverse + traversing whole list at the end to reorder
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReorderList {
    public void reorderList(ListNode head) {
        //approach is to reach mid of the list first
        
        //null check
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) { //until end of list
            slow = slow.next; //moving slow by one
            fast = fast.next.next; //fast by double the places
            //so that when fast reaches end, slow will be at mid
        }
        
        //now that we have reached the mid, we need to reorder/reverse second part
        fast = reverse(slow.next); //since slow is mid, from next element reverse
        
        slow.next = null;//breaking the old chain
        
        slow = head;
        ListNode temp = null;
        
        //merging two lists now
        while(fast != null) {
            temp = slow.next; //tempt holding 2nd element's val
            slow.next = fast; //putting fast(first of reversed list) in 2nd place
            fast = fast.next; //moving fast by one(moving ahead in reversed list)
            slow.next.next = temp; //temp holding 2nd's val has to go to 3rd now
            slow = temp; //slow moved to 3rd, so it can move and repeat
        }
        
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null; //for storing previous of current element
        ListNode curr = head; //assigning the passed element to curr
        ListNode fast = head.next; //next element to head is fast
        //now curr and fast is dealing with second part of the list
        
        while(fast != null) {//till we reach the end of second part
            curr.next = prev; //
            prev = curr; //pushing curr in prev
            curr = fast; //moving curr by one place ahead
            fast = fast.next; //fast moved again ahead by one
        }
        
        curr.next = prev; //after reaching end, curr next has to store prev
        return curr;
    }
}