public class ReoderList {
    //https://leetcode.com/problems/reorder-list/submissions/1359756733/

     public class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        //Step 1;find middle of LL.
        //  - take slow pointer fast pointer.
        //slow pointer moves one step. fast pointer moves 2 steps.
        //until fast.next is not null and fast.next.next is not null
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //Step2. Reverse second half of the linkedlist.
        // reusing the fast pointer as at this point no use for that and we can reuse instead of redeclaring
        fast = reverse(slow.next);

        //Step 3 - merge two lists such that reordering is achieved.
        // resuing slow pointer at this point as no use for it.
        // point slpw pointer to null first. this will create two clear lists that needs to be merged
        // re assign slow pointer to head of the original list.

        slow.next = null;
        slow = head;
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        return prev;
    }
}
