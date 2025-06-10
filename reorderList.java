//first node → last node → second node → second last node, and so on. 
//use fast and slow pointers to find the middle, reverses the second half of the list, and then merge the two halves alternately. The loop  links nodes from both halves until they meet, handling edge cases to avoid cycles.
//Time complexity: O(n)
//Space complexity: O(1)
class Solution {

    public static ListNode reverseList(ListNode head)
    {
        ListNode prev=null, curr=head;
        while(curr!=null)
        {
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }

        return prev;
        
    }
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid=slow;
        ListNode first=head;
        ListNode second= reverseList(mid);

        while(first!=null && second!=null)
        {
            ListNode temp=first.next;
            first.next=second;
            first=temp;
            temp=second.next;
            second.next=first;
            second=temp;

        }

        if(first!=null) first.next=null;
    }
}