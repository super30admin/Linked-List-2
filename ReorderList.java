
//TC-O(N) SC-O(1)
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode prev=null;
        ListNode slow=head;//mid
        ListNode fast=head;
        while(fast.next != null &&  fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;   //break the chain to 2 half
        slow = head; //point slot to head
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;

        }

    }
    private ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
