
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

public class ReorderList {
    public ListNode getMiddleNode(ListNode head){
        ListNode slow = head,fast = head;

        for(; fast != null && fast.next != null; fast = fast.next.next){
            slow = slow.next;
        }
        return slow;
    } 

    public ListNode reverseList(ListNode head){
        ListNode cur = head,prev = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null)
            return ;
        ListNode slow = getMiddleNode(head);
        ListNode fast = reverseList(slow.next);
        slow.next = null;
        ListNode temp ;
        slow = head;
        while(slow != null && fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow =temp;
        }
    }
}