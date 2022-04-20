//time-O(n)
//space-O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        //find mid point
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second half of the list
        ListNode reversedHead = reverse(slow.next);

        //Split reversed half from first half
        slow.next = null;

        //Merge
        slow = head;
        fast = reversedHead;
        ListNode temp = slow.next;
        while(fast!=null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextPtr = curr.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
            if(nextPtr!=null)
                nextPtr = nextPtr.next;
        }
        return prev;
    }
}