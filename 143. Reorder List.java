class Solution {
    // Time complexity: O(n)
    // Space complexity: O(1) I have questions here:
    // since i use recursive method which will use recursive stack to implement the reverse methond,
    // so whether we should count the space here.
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode head3 = reverse(head2);
        ListNode newHead = merge(head, head3);
    }
    // two pointers to find the mid element
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // recursive method to do the reverse method
    public ListNode reverse (ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(h1 !=null && h2 != null){
            cur.next = h1;
            cur = cur.next;
            h1 = h1.next;
            cur.next = h2;
            cur = cur.next;
            h2 = h2.next;
        }
        if(h1 != null){
            cur.next = h1;
            cur = cur.next;
            h1.next = null;
        }
        return dummy.next;
    }
}