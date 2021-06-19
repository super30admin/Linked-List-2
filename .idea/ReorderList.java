class ReorderList {
 public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        //finding the mid
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reversing the ll
        fast = reverseL(slow.next);
        slow.next = null;
        //merging ll
        slow = head;
        while(fast!=null)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverseL(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode Next = head.next;
        while(Next!=null)
        {
            curr.next = prev;
            prev = curr;
            curr = Next;
            Next=Next.next;
        }
        curr.next = prev;
        return curr;
    }
}

//Time complexity is O(n)
//Space complexity is O(1)