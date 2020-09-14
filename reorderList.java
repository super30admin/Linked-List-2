    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/reorder-list/
    Time Complexity for operators : o(n) 
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach: Recursion or Iterative.
                              
                #
                    A. take 2 pointers slow and fast. Move one by one and fast by 2 difference. You weill get the mod point.
                    B. Disconnect it from first list. slow.next = null;
                    C. Now traverse thru the second list till it goes to null and select one node from 
                       first list and second node from second list.

       */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

   class reorderList {
    public void reorderList(ListNode head) {
        
        if(head==null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println("slow"+slow.val);
        ListNode h2 = reverse(slow.next);
        slow.next = null;
        
        ListNode temp1;
        ListNode temp2;
        
        ListNode h1 = head;
        
        while(h2!=null){
            temp1 = h1.next;
            h1.next = h2;
            temp2 = h2.next;
            h2.next = temp1;
            h1 = temp1;
            h2 = temp2;
        }
    }
    
    private ListNode reverse(ListNode curr){
        ListNode temp = null, prev = null;
        
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}