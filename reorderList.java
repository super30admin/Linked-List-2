// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast= head;
        ListNode result = new ListNode(0);
       
        while(slow != null && fast != slow){
            result.next = fast;
            fast= fast.next;
            result = result.next;
            
            result.next= slow;
            slow=slow.next;
            result=result.next;
        }
        result = result.next;
    }
    
    private ListNode reverseList( ListNode head ){
        ListNode prev = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev= head;
            head=next;
        }
        return prev;
    }
}
