// Time Complexity : O(n) -> iterating over entire linkedList
// Space Complexity : O(1) -> no extra space and updating the linkedList in-place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        
        //basecase
        if(head == null || head.next == null){
            return;
        }

        //initiate slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        //1. find the mid
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        //2. reverse the second half
        ListNode node = null;
        while(secondHalf != null){
            ListNode temp = secondHalf.next;
            secondHalf.next = node;
            node = secondHalf;
            secondHalf = temp;
        }

        //merge both lists
        ListNode first = head;
        secondHalf = node;

        while(secondHalf != null){
            ListNode temp1 = first.next;
            ListNode temp2 = secondHalf.next;
            first.next = secondHalf;
            secondHalf.next = temp1;
            first = temp1;
            secondHalf = temp2;
        }
    }
}