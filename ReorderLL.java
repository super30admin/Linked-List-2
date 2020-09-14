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
class ReorderLL {
    // Time Complexity:     O(n)
    // Space Complexity:    O(1)
    public void reorderList(ListNode head) {
        
        if(head == null)
            return;
        
        // 1. Reach the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. Reverse the second half
        ListNode second = reverse(slow.next);
        slow.next = null;

        ListNode first = head;
        ListNode temp1, temp2;
        // 3. Iterate through both the list and form the result
        while(second != null){          
        // Interesting: Always second will contain either lessthan or equal number 
        //              of nodes of first list, so one check should be fine
            temp1 = first.next;
            first.next = second;
            temp2 = second.next;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
    public ListNode reverse(ListNode curr){
        
        ListNode prev = null;
        ListNode temp;
        
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        //prev will be at last node(5 in 3<--4<--5) and curr will be at null in usual case
        return prev;
    }
}