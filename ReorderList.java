//TC: O(n)
//SC: O(1)
//approach: two pointers to reach mid, then reverse second half of list,
// and then merge two halves using one from each

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode left = head;
        ListNode right = head;

        while(right.next != null &&  right.next.next != null){
            left = left.next;
            right = right.next.next;
        }

        right = reverse(left.next);
        left.next = null;
        left = head;

        while(right != null){
            ListNode temp = left.next;
            left.next = right;
            right = right.next;
            left.next.next = temp;
            left = temp;
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
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
