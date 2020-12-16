/*
class Solution:
    def reorderList(self, head: ListNode) -> None:
        if head is None:
            return head

        slow, fast = head, head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse linkedlist logic    
        def reversed_list(head):
            if head is None or head.next is None:
                return head
            
            reversed_head = reversed_list(head.next)
            head.next.next = head
            head.next = None
            return reversed_head
        
        # merging two linkedlist
        fast = reversed_list(slow.next)
        slow.next = None
        slow = head
        while fast is not None:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp
*/

// Time Complexity : O(n) where n is no of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: We first have to locate middle and separate right half and make it reversed
// after that we merge both the list again 
class Solution {
    public void reorderList(ListNode head) {
        if (head == null){
            return ;
        }
        
        ListNode slow = head, fast= head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        ListNode temp;
        while (fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null)
            return head;
        
        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}