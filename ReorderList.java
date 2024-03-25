class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

 //tc = o(n)
 //sc = o(1)
 class Solution {
    public ListNode reverse(ListNode slow){
        ListNode prev = null;
        ListNode current = slow;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        //find mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode start = reverse(slow.next); //reverse
        slow.next = null;
        ListNode temp = head;

        while(start != null){ //merge list
            ListNode temp2 = temp.next;
            ListNode start2 = start.next;

            temp.next = start;
            start.next = temp2;

            temp = temp2;
            start = start2;

        }



    }
}