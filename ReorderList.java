// Time Complexity : O(n)
// Space Complexity : O(1) 
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next== null)return;

        ListNode slow = head;
        ListNode fast = head;
        //separate the two LL at middle
        while(fast.next != null && fast.next.next != null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next = null;
        slow=head;

        //reverse the second half
        ListNode prev = null;
        ListNode curr = fast;
        ListNode Next = curr.next;
        while(curr!=null && curr.next!=null){
            curr.next=prev;
            prev=curr;
            curr=Next;
            Next=Next.next;
        }
        curr.next=prev;

        //merge both
        while(slow!=null && curr!=null){
            ListNode temp = slow.next;
            slow.next=curr;
            curr=curr.next;
            slow.next.next = temp;
            slow=temp;
        }
    }
}