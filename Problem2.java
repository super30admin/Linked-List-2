// TimeComplexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Find the middle using slow and fast pointers. 
After reaching mid, reverse the second part of the list. 
Merge the two splits at the end. 
 * 
 */

class Problem2 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
        return ;
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null; 
        slow = head;
        while(fast != null){
            ListNode temp = slow.next; 
            slow.next = fast; 
            fast = fast.next; 
            slow.next.next = temp; 
            slow = temp;
        }
    }

    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode fast = node.next; 
        while(fast != null){
            curr.next = prev; 
            prev = curr; 
            curr = fast; 
            fast = fast.next;
        }
        curr.next = prev; 
        return curr;
    }
}