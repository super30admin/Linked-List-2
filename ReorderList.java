public class ReorderList {

       // Time Complexity : O(n)
       // Space Complexity :O(1)
       public void reorderList(ListNode head) {
        //Find Middle of the list
        //Reverse second half
        //make new links

        //Find Middle of the list
        ListNode slowpointer = head, fastpointer = head;
        while(fastpointer!=null && fastpointer.next!=null)
        {
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;
        }

        ListNode curr = slowpointer.next;
        ListNode prev = null;
        //Reverse second half
        while(curr!=null)
        {
           ListNode temp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = temp;
        }

        slowpointer.next = null;

        ListNode startpointer = head;

        while(prev!=null&&startpointer!=null)
        {
            ListNode temp1 = startpointer.next;
            ListNode temp2 = prev.next;
            startpointer.next = prev;
            prev.next = temp1;

            startpointer = temp1;
            prev = temp2;
        }

    }
}
