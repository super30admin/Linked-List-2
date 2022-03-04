// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {

    //finding mid
    ListNode slow = head, fast = head;
    while( fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    
    ListNode head2 = reverse(slow);
    slow.next = null;
        
    //merge two linkedlist;
    ListNode temp1, temp2;
    ListNode first = head, second = head2;
    while(second.next != null){
        temp1 = first.next;
        first.next = second;
        first = temp1;
        temp2 = second.next;
        second.next = temp1;
        second = temp2;
        
    }
        
    }
    
    
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}