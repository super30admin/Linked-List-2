// Time Complexity :
//      n is the number of nodes in LL
//      reorderList() - O(n) - slow pointer traverses the whole ll once
//      
// Space Complexity :
//      reorderList() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode sp = head, tp = head, fp = head.next;
        
        while(fp.next != null)
        {
            tp = tp.next;
            fp = fp.next;
        }
        
        fp.next = sp.next;
        tp.next = null;
        sp.next = fp;
        
        reorderList(sp.next.next);
    }
}