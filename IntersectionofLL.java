// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while(ptrA!=ptrB){
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
            
        }
        return ptrA;
    }
    public void deleteNode(ListNode head) {
        ListNode prev = null;
        while(head.next != null){
            ListNode prev = head;
            head.val = head.next.val;
            head = head.next;
        }
        if(prev == null){
            System.out.println("Cannot delete last node");
        }
        prev.next = null;
    }
}
