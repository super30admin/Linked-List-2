// Approach: Find the node previous to second half, and remove the link to second half to make two lists. Reverse second list and merge it with the first half
// Time Complexity: O(n). n/2 to find midpoint, n/2 to reverse the second half, n/2 to merge the lists.
// Space Complexity: O(1) No extra space is used other than some pointers.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public void ReorderList(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode l2 = slow.next;
        slow.next = null;
        l2 = Reverse(l2);
        
        Merge(head, l2);
    }
    
    public ListNode Merge(ListNode l1, ListNode l2){
        ListNode preHead = new ListNode(-1, null);
        ListNode l3 = preHead;
        while(l1!=null && l2!=null){
            l3.next = l1;
            l1 = l1.next;
            l3 = l3.next;
            
            l3.next = l2;
            l2 = l2.next;
            l3 = l3.next;
        }
        
        l3.next = l1==null ? l2 : l1;
        
        return preHead.next;
    }
    
    public ListNode Reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}