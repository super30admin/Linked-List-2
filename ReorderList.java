// Time Complexity : O(n)
// Space Complexity : O(1)
public class ReorderList {
    public void reorderList(ListNode head) {
        // single node
        if(head == null || head.next == null)
            return;
        
        // 1. divide the list into halves L1 and L2
        // since we want first list to be longer in case of odd elements
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. disconnect L1 and reverse L2
        // Head of the L2
        fast = reverse(slow.next);
        // need to disconnect slow because slow needs to be L1
        slow.next = null; // last node of l1 should be null
        
        
        // 3. combine both halves to re-order
        // slow is L1
        slow = head;
        ListNode dummy = slow.next;
        // fast is smaller will reach end first
        // fast is L2
        while(fast != null)
        {
            slow.next = fast; // L1 -> L2
            fast = fast.next; // move to next L2 element
            slow.next.next = dummy; // L1 -> L2 -> L1
            slow = dummy; // move to next L1 element
            if(slow != null) // this is when both list are of same size
                dummy = dummy.next;
        }
        
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null, curr = head, fast = head.next;
        // fast is moving ahead first this will hit null first
        while(fast != null)
        {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev; //attach last node
        return curr;
    }
}