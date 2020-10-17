class ReorderList {
    public class ListNode {
           int val;
            ListNode next;
            ListNode(int x) { val = x; }
         }


    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        // middle 
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;            
        }

        // revsersing the list
        fast = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(fast != null){
            ListNode next = fast.next;
            fast.next = prev;
            prev = fast;
            fast = next;
        }
        fast = prev;

        //connections
        ListNode curr = head;
        ListNode next;

        while(curr != null && fast != null){
            next = curr.next;
            curr.next = fast;
            fast = fast.next;
            curr.next.next = next;
            curr = next;
        }


        // reverse 

        /**
         * i                       j
         * L1 -> L2 -> L3 -> L4 -> L5
         * 
         * L5 -> L4 -> L3 -> L2 -> L1
         * j
         * 
         *  
         * */

         // Make i.next = j;
         //move j--;
    }
    public static void main(String[] args){
        System.out.println("ReorderList");
    }
}