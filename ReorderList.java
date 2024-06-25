class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        int count = 0;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count += 1;
        }

        
        ListNode prev = null;
        ListNode curr = slow.next;
        fast = curr.next;

        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        
        slow.next = null;

        ListNode temp1 = head;
        ListNode temp2 = curr;

        temp1 = head;
        temp2 = curr;
        ListNode temp2Next = null;
        while(count > 0) {
            ListNode temp1Next = temp1.next;
            temp2Next = temp2.next;

            temp1.next = temp2;
            temp2.next = temp1Next;
            temp2 = temp2Next;
            temp1 = temp1Next;
            count -=1;
        }
        temp1.next = temp2Next;
    }

}
