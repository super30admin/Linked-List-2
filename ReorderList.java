// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Find mid point
// Reverse second half of linked list
// Merge the two linked lists

class Solution {
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while(nextNode!=null){
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            nextNode = nextNode.next;
        }
        currNode.next = prevNode;
        return currNode;
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        return;
    }
}