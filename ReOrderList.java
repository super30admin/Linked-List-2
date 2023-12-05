class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class ReOrderList {
    public void reorderList(ListNode head) {
        // TC:O(n);
        // SC:O(1);
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){ // to consider odd and even cases
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null; // pointng to last
        slow = head; //pointing to 1st

        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
