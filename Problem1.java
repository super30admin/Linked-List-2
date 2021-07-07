// Time Complexity - O(n) where n is the number of nodes in the list
// Space Complexity - O(1)
// This solution worked on LeetCode
// In this problem. We need to reverse second half of the linked list and merge the reversed part with first half of the list.

class Solution {
    public void reorderList(ListNode head) {
        if(head == null)    return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){   // Reach the middle
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);    // reverse the list from next node to the middle
        slow.next = null;             // To split the 2 list from middle
        ListNode temp;    
        slow = head;                // start the slow from the head
        while(slow != null && fast != null){ // Merge the first half to the second haf reverse linked list
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    private ListNode reverse(ListNode node){            // reverse the linked list
        if(node == null || node.next == null)   return node;
        ListNode curr = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return curr;
    }
}
