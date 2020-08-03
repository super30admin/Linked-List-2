/**
 // Time Complexity :O(n+m) n.m two halfs of the array.
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : yes
 // Any problem you faced while coding this :
  //combining all three steps. find middle, reverse and reorder.

 // Your code here along with comments explaining your approach
 // find the middle of the list.
 // after getting the middle, rever the second half.
 //now reorder such that, first elem is from first list, second from reversed
 //list and so on.
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;

        //get middle.
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse
        ListNode prev = null;
        ListNode cur = slow;
        ListNode nxt = cur.next;

        while(cur != null){
            cur.next = prev;

            prev = cur;
            cur = nxt;
            if(nxt != null)
                nxt = nxt.next;
        }

        //reorder
        cur = head;
        ListNode revCur = prev;
        while(revCur.next != null){
            ListNode curnxt = cur.next;
            ListNode prevnxt = revCur.next;
            cur.next = revCur;
            revCur.next = curnxt;

            cur = curnxt;
            revCur = prevnxt;
        }

    }
}
