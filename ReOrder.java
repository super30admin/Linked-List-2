// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Keeping track of prev was something , i took a while to figure out.


// Your code here along with comments explaining your approach
class ReOrder {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public void reorderList(ListNode head) {
        ListNode p= head;
        ListNode q = head;
        ListNode prev = null;
        while(p!=null && p.next!=null)
        {
            while(q.next!=null)
            {
                prev=q;
                q=q.next;
            }
            if(p==q) break;
            prev.next = null;
            q.next = p.next;
            p.next = q;
            p=q.next;
            q=p;
            
        }
        
    }
}