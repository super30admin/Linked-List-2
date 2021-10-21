/*
LeetCode -143
Time Complexity-O(n)
Space Complexity-O(1)
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
class Solution {
    //1.Find middle of the list
    //2.Reverse second half of the list
    //3.Merge two LLs
    
    public void reorderList(ListNode head) {
        //Dont use a dummy pointer !!!
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        //middle of the list
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        //reverse list from middle onwards
        fast=slow.next;
        //break off and create two disjoint lists here
        slow.next = null;
        
        //reverse list recursively
        ListNode reversedHead = reverseRecursive(fast);
        //move fast to the head of the reversed list
        fast = reversedHead;
        //move slow to the head of the first half of the original list
        slow = head;
        
        //merge the 2 halves
        ListNode temp = null;
        while(fast!=null)
        {
            temp=slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }       
    }
    private ListNode reverseRecursive(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode reversed = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}