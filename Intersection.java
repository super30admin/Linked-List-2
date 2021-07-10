// Time Complexity : O(n)
// Space Complexity :(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class Solution {
     public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
                 next = null;
             }
         }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p,q;
        p= headA;
        q=headB;
        while(p != q)
        {
            if(p==null && q==null)
                return null;
            
               p= p==null?headB:p.next;
               q= q==null?headA:q.next;
             
        }
        return p;
        
    }
}