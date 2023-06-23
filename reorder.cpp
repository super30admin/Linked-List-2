

// first finds the middle node of the list using the slow and fast pointer technique.
// splits the list into two halves at the middle node.
// reverses the second half of the list.
// merges the two halves by alternating nodes from each half.
// Overall, the code has a time complexity of O(n) and a space complexity of O(1), 
// where n is the length of the linked list.

class Solution {
    public void reorderList(ListNode head) {
        if(head==null)
            return;

        // Initialize fast and slow pointers to find the middle node
        ListNode fast,slow,temp;
        fast=head;
        slow=head;

        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
    
        // Split the list into two halves
        fast=slow.next;
        slow.next=null;
        slow=fast;

        ListNode head2=null;
        
        // Reverse the second half of the list
        while(slow!=null)
        {
            slow=slow.next;
            fast.next=head2;
            head2=fast;
            fast=slow;
        }
        
        slow=head;
        temp=head;
        fast=head2;

        // Merge the two halves by alternating nodes from each half
        while(fast!=null)
        {
            slow=slow.next;
            temp.next=head2;
            fast=fast.next;
            head2.next=slow;
            temp=slow;
            head2=fast;
        }
    }
}
