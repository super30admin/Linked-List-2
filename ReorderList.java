// Time Complexity : O(n), where n is the number of nodes in the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Find the middle of the list.
 * 2. Reverse the second half of the list.
 * 3. Merge the two lists.
 * 4. Return the head of the list.
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode l1 =head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        ListNode l2 = reverse(slow);  
        
        merge(l1,l2);
      
    }
    
    public ListNode reverse(ListNode head){
        if(head.next == null || head == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode next = head;
        ListNode prev = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;            
        }
        
        head = prev;
        return head;
    }
    
    public void merge(ListNode l1,ListNode l2){
                
        while(l1 !=null){
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
            
            l1.next = l2;
            
            if(l1_next == null){
                break;
            }
            
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2_next;
        }   
    }
}