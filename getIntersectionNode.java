// Time Complexity :O(n) n is the number of nodes in the linked list
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        int count = 0;
        while(n1!=null && n2!=null){
            n1 = n1.next;
            n2 = n2.next;
        }
        
        while(n1!=null){
            n1 = n1.next;
            headA = headA.next;
        }
        
        while(n2!=null){
            n2 = n2.next;
            headB = headB.next;
        }

        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
        
        
    }
}