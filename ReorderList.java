//TC : O(n)
//SC : O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode r = reverseList(head.next);
        //st.pop
        head.next.next = head;
        head.next = null;
        return r;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)   return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverseList(slow.next);
        slow = head;
        fast = slow.next;
        slow.next = null;

        ListNode temp1 = slow.next;
        ListNode temp2 = fast.next;
        while(fast != null) {
            slow.next = fast;
            fast.next = temp1;
            slow = temp1;
            fast = temp2;
            if(temp2!=null) temp2 = temp2.next;
            if(temp1!=null) temp1 = temp1.next;
        }
    }
}