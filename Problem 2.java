//Time Complexity: O(N) where N is the number of nodes
//Space Complexity: O(1)

//Successfully runs on leetcode: 1 ms

//Approach: we divide this problem into three parts - finding the mid, reversing the second part of the list and merging 
//the resultant two lists and implement all three functions accordingly.


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
        if(head == null || head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        
        while(fast != null)
        {  
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    
    private ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode curr = node;
        ListNode temp = node.next;
        
        while(temp != null)
        {
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }
        curr.next = prev;
        return curr;
    }
}