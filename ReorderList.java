// Time Complexity : O(n)-> Find the middle + O(n/2) -> Split Reverse of half LL + O(n) -> Merge = O(n) where n is number of nodes in LL
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficult to come up with this approach
/* Your code here along with comments explaining your approach: Reach the middle of the linked list using the slow and the fast pointer. Once the
middle is reached, reverse the linked list from the middle to end (nodes) and point the fast pointer to the start of the reversed Linked list since
we need to merge. Reset head to slow to start merging. Introduce a temp pointer to help with merging, it will help the slow and fast pointer to keep
a track of their original next node before they merge. Adjust the slow, fast and temp pointers to merge the Linked list.
*/
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){return;}
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;                                                   // Reach the middle of the linked list
        }
        fast = reverse(slow.next);                                          // Fast will point to the head of the reversed linked list
        slow.next = null;                                                       //Splits the linked list into two halves
        slow = head;                                                    // Reset the slow pointer. Merging is about to start.
        ListNode temp = slow;
        while(fast != null){
            temp = slow.next;                                       // temp helps the slow to keep track of the next node in the Slow ptr LL
            slow.next = fast;                                       // Slow connects with fast
            slow = temp;                    
            temp = fast.next;                                       // temp helps the fast to keep track of the next node in the Fast ptr LL
            fast.next = slow;                                       // fast connects back with slow
            fast = temp;
        }
        
    }
    private ListNode reverse(ListNode head){                            // Standard function to Reverse a Linked List
        if(head == null || head.next == null){return head;}
        ListNode r = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return r;
    }
}