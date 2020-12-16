// Time Complexity :O(N) where n is the number of nodes 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach: didviding the list into two halves and reversing the second list. Traversing 
// the first half and the reversed list one node at a time.
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
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!= null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        ListNode previous = null;
        while(fast!=null){
            ListNode t = fast.next;
            fast.next=previous;
            previous=fast;
            fast=t;
       //     System.out.println( " previous"+previous.val);
        }
        slow = head;
        while(previous!=null){
           //System.out.println("slow"+slow.val+ " previous"+previous.val);
            ListNode t = slow.next;
            slow.next = previous;
            previous = previous.next;
            slow.next.next = t;
            slow=t;
        }
    }
}