class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public void reorderList(ListNode head) {
       //find mid

       ListNode slow = head;
       ListNode fast = head;

        //odd and even length each one condition
       while(fast.next!=null && fast.next.next!=null)
       {
        slow = slow.next;
        fast= fast.next.next;
       }

       //reverse second half from the second half where slow is there
       fast = reverse(slow.next);

       slow.next = null;

       //merge

       slow = head;
       while( fast != null)
       {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
       }

    }

    private ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
