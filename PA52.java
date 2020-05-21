//Leetcode 143. Reorder List
// Time complexity : O(n) // O(n+n+n) linear time for each finding mid , reversing 2nd half of the linked list and 				merging both the parts of linked list.
//Space Complexity: O(1) // No extra space allocated.


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
class Solution {
    public void reorderList(ListNode head) {
        //Find mid
        if(head==null || head.next==null){
            return ;
        }
        ListNode slow= head;
        ListNode fast= head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast= fast.next.next;
        }
        
        
        //revesre the 2nd half
      
        ListNode lnode= reverse(slow.next);
        slow.next=null;

        slow= head;
        // merge both 
        
        while(lnode!=null){
            ListNode temp =  slow.next;
            slow.next= lnode;
            ListNode temp1=lnode.next;
            lnode.next= temp;
            slow=temp;
            lnode=temp1;
        }
        return ;
        
        
    }
    
    public ListNode reverse(ListNode root){
        ListNode prev= null;
        ListNode curr= root;
        if(root==null){
            return null;
        }
        ListNode fast = root.next;
        
        while(fast!=null){
            curr.next = prev;
        
            prev= curr;
            curr= fast;
            fast= fast.next;
       
            
        }
 
        curr.next = prev;
        return curr;
        
    }
}