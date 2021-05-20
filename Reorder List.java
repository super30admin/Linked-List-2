//Time Complexity : O(N)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        //Find the mid point
        //use the slow and fast pointers to find mid
        ListNode slow=head, fast=head, temp;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
       
        //reverse the second half of the list
        fast = reverse(slow.next);
         //split the list into two halfs
        slow.next = null;
        //point slow again to head
        slow = head;
        //Merge the two halfs
        while(fast!=null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null, cur = head, fast = head.next;
        while(fast!=null){
            cur.next = prev;
            prev = cur;
            cur = fast;
            fast = fast.next;
        }
        cur.next = prev;
        return cur;
    }
}