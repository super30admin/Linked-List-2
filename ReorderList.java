// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach

class ReorderList {
    public void reorderList(ListNode head) {
        if(null == head || null == head.next){return;}
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second= slow.next, first = head, current = dummy;
        slow.next = null;
        second = reverse(second);
        while(null != first && null != second){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            current.next = first;
            current.next.next = second;
            current = current.next.next;
            first = firstNext;
            second = secondNext;
        }
        if(null != first){
            current.next = first;
        }
        if(null != second){
            current.next = second;
        }
    }
    public ListNode reverse(ListNode head){
        if(null == head || null == head.next){return head;}
        ListNode prev = null, current = head, next = null;
        while(null != current){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;;
        }
        return prev;
    }
}