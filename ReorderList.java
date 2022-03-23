// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Find the mid of list using slow and fast pointers
//Reverse the list after the mid point
//Now merge them starting from first list which is not reversed
//With the second list which is reversed in alternate fashion
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
class Solution {
    public void reorderList(ListNode head) {     
        if(head == null)
            return;
        //find mid
        ListNode cur = head;
        ListNode head2 = head;
        while(cur != null && cur.next != null){
            cur = cur.next.next;
            head2 = head2.next;
        }
        //reverse
        cur = head2;
        ListNode prev = null;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head2 = prev;
    //merge
        cur = head;
        ListNode headnext;
        while(head2.next != null){
            next = cur.next;
            cur.next = head2;
            cur = next;
            headnext = head2.next;
            head2.next = cur;
            head2 = headnext;    
        }
    }
}