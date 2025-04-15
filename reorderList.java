public class reorderList {

   public class ListNode 
   {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution 
    {
        public void print(ListNode list)
        {
            while(list!=null)
            {
                System.out.print(list.val+" -> ");
                list = list.next;
            }
            System.out.println("");
        }
        public void reorderList(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next!=null)
            {
                fast = fast.next.next;
                slow = slow.next;
            }
    
            ListNode prev = null;
            ListNode dup = slow.next;
            slow.next = null;
            while(dup !=null)
            {
                ListNode temp = dup.next;
                dup.next = prev;
                prev = dup;
                dup = temp;
            }
    
    
            ListNode one = head;
            ListNode two = prev;
            while(two != null)
            {
                ListNode odup = one.next;
                ListNode tdup = two.next;
                one.next = two;
                two.next = odup;
                two = tdup;
                one = one.next.next;
            }
            
        }
    }
}