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
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// get middle term using two pointers ( one is fast and other is slow)
// once found the middle node then split it to half and reverse the new end half
// add the reversed half to the first list in the middle of the two node - as asked
// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        if( head == null || head.next == null) return;
        ListNode s = head;
        ListNode f = head;
        // middpoint
        while( f.next != null && f.next.next != null ){
            s = s.next;
            f = f.next.next;
        }
        // split the list in two halfs
        f = s.next;
        f = reverseList(f);
        s.next = null;
        s = head;
        // assign the end list to new postion
        ListNode temp = null;
        while( f != null){
            temp = s.next;
            s.next = f;
            f = f.next;
            s.next.next = temp;
            s = temp;
        }
    }
    // reverse the string function
    private ListNode reverseList(ListNode head){
        ListNode s = null;
        ListNode c = head;
        ListNode f = head.next;
        while( f != null){
            c.next = s;
            s = c;
            c = f;
            f = f.next;
        }
        c.next = s;
        return c;
    }
}