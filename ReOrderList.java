
//Time Complexity: O(n)
//Space Complexity: O(1)


 // Definition for singly-linked list.



public class ReOrderList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        public void reorderList(ListNode head) {
            if(head == null || head.next == null || head.next.next == null){
                return;
            }

            // calculate middle
            ListNode slow = head, fast = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
//System.out.println("slow "+slow.val+" slow.next "+slow.next.val);
            // reverse half of the list
            ListNode prev = slow;
            // prev.next = null;
            ListNode start = slow.next;

            //  System.out.println("prev "+prev.val+" start "+start.val);
            while(start != null){
                ListNode snext = start.next;
                start.next = prev;
                prev = start;
                start = snext;
            }

            // reorder list
            ListNode last = prev;
            ListNode first = head;

            while(first != last.next && first != last){
                //    System.out.println(" first "+first.val+ " last "+last.val+" last.next "+last.next.val);
                ListNode fnext = first.next;
                ListNode lnext = last.next;
                first.next = last;
                last.next = fnext;
                first = fnext;
                last = lnext;
            }
            first.next = last;
            last.next = null;

        }


}
