// Leetcode 143: Reorder List
// Time - O(n)
// Space - O(1)
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
     
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        
        ListNode secondHead = reverse(head2) ;
            
        
        ListNode p = head;
        ListNode q = secondHead;
        
        while(q != null){
            
            ListNode temp = p.next;
            p.next = q;
            p = temp;
            
            ListNode temp2 = q.next;
            q.next = p;
            q = temp2;
            
          }
        
        }

    
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
}
    
}