// Problem2 (https://leetcode.com/problems/reorder-list/)
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    private ListNode reverseList(ListNode head){
        ListNode prev=null, curr=head, fast;

        while(curr!=null){
            fast=curr.next;

            //reverse
            curr.next=prev;

            //move pointers ahead
            prev=curr;
            curr=fast;
        }

        return prev;
    }

    // 3 steps: Split the list; Reverse second half; Merge the halves
    // Time: O(N)
    // Space: O(1)
    public void reorderList(ListNode head) {
        // Split the list in half - O(N)
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // fast == head of second half
        fast=slow.next;
        slow.next=null;

        // Reverse second half - O(N)
        fast = reverseList(fast);

        // Merge the lists - O(N)
        // slow==head, fast==head of reversed second half
        slow=head;
        ListNode temp;
        while(fast!=null){
            temp=slow.next;
            slow.next=fast;

            fast=fast.next;
            slow.next.next=temp;

            slow=temp;
        }

    }
}