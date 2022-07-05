// Time Complexity :O(3n) --> O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//logic
// 1) find mid
// 2) reverse second half
// 3) Merge the same list using two pointers

class Solution {
    public void reorderList(ListNode head) {
        // null case
        if(head == null || head.next == null || head.next.next == null) return;
        //find mid of ll
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is at the middle
        //reverse
        fast = reverseNode(slow.next);
        slow.next = null; // because to break the list
        //merge list
        slow = head;
        ListNode temp;
    
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    private ListNode reverseNode(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
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