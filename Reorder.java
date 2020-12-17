/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * The slow fast pointer helps because we reach middle now we reverse 2nd linked link and insert each
 node from second in first list.
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = reverseLL(slow.next);
        slow.next = null;
        ListNode l1 = head;
        ListNode temp = l2;
        while(l2!=null){
           temp = l2.next;
           l2.next = l1.next;
           l1.next = l2;
           l1 = l2.next;
           l2 = temp;
        }
        
    }
    
    public ListNode reverseLL(ListNode node){
        if(node==null || node.next == null){
            return node;
        }
        ListNode reversed = reverseLL(node.next);
        node.next.next = node;
        node.next = null;
        return reversed;
    }
}