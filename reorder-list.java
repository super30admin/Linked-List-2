// Find the middle of the list using two pointers.
// Reverse the second half of the list.
// Merge the two halves in a zig-zag manner.
// TC:O(n), SC:O(1)
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //find mid: O(n/2)=O(n)
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse: O(n/2)=O(n)
        fast = reverse(slow.next);
        //disconnect second half
        slow.next = null;
        slow = head;

        //merge: O(n)
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow=temp;
        }
    }
    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}