//time complexity: O(n)
//space complexity: O(1)

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode half = reverse(slow);
        
        rearrange(head, half);    
    }
    
    public ListNode reverse(ListNode curr)
    {
        ListNode prev = null;
        
        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    private static void rearrange (ListNode head1, ListNode head2)
    {
        // ListNode copy = head1;
        
        while(head1 != null && head2 != null)
        {
            ListNode temp1 = head1.next;
            head1.next = head2;
            head1 = temp1;
            ListNode temp2 = head2.next;
            head2.next = head1;
            head2 = temp2;
        }
        if (head1 != null)
            head1.next = null;
    }
    
    
}