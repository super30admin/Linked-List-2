// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had little difficulty in thinking optimized approach

class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode slow = head, fast = head;

        //find middle
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow = middle
        fast = slow.next;
        ListNode prev = null;
        ListNode next = null;
        //reverse second half of the linked list
        while(fast!=null){
            next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }

        //bringing last element to fast
        fast = prev;

        //merge list //1->2->3->null 6->5->4
        slow.next = null;
        slow = head;

        while(fast!=null){
            next = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = next;
            slow = next;
        }
    }
}