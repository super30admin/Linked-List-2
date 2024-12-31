

public class Problem2 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

         //start of 2nd half of the linked list
        //slow is at mid
        fast= reverse(slow.next);
        slow.next = null;
        slow = head;
        
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next =fast;
            fast = fast.next;
            slow.next.next = temp;
              slow = temp;
        }

    }

    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr!=null ){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;

    }
}
