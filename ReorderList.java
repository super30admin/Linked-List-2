// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = reverseList(slow.next);
        slow.next = null;
        
        while(ptr1!=null && ptr2!=null){
            ListNode temp1 = ptr1.next;
            ptr1.next = ptr2;
            ListNode temp2 = ptr2.next;
            ptr2.next = temp1;
            ptr1 = temp1;
            ptr2 = temp2;
        }
    }
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
