// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understood the concepts but still need to practice code


// Your code here along with comments explaining your approach

class Solution {
    public void reorderList(ListNode head) {
        //3 problems, find middle value, reverse second half of linkedlist into a new linkedlist, make links between two linkedlist
        if(head == null || head.next == null) return;
        
        //find middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;
        while(fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //create new linklist fast which is reverse of old one but only goes to middle + 1 value
        fast = reverse(slow);
        slow.next = null;
        slow = head;
        
	//link nodes from first to second list in the order
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    private ListNode reverse(ListNode head){
        //reverse second half linkedlist
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(curr.next != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = curr.next;
        }
        curr.next = prev;
        return curr;
    }


}