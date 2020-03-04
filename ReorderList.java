/**
Time complexity: O(N)
Space: O(1)
Algorithm:
=========
1. Find middle of the list using 2-pointer technique
2. Reverse the list from mid+1, disconnect 2 lists
3. Merge them node by node
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;               //find mid
        }
        
        fast = reverse(slow.next); //reverse second half
        slow.next = null;   // disconnect first and second lists
        slow = head;
        
        while(fast != null) {
            ListNode curr = slow.next;          //merging two lists using 3 pointers
            slow.next = fast;                   
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
        
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;			// edge
		ListNode prev = null, curr = head, fast = head.next;		//using 3 pointers, two to keep track of forming connections in reverse
		while(fast != null) {										// 1 to keep track of remaining list to be reversed 
			curr.next = prev;										
			prev = curr;
			curr = fast;
			fast = fast.next;
		}
		curr.next = prev;
		return curr;											// return head of reversed list

    }
}