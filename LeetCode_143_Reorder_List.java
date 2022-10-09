//approach- 1
//traverse with slow and fast pointer, slow = slow.next and fast = fast.next.next to get slow at the middle point
// now from slow.next to fast, just reverse the LL
// traverse through the given head and keep adding nodes from the 'F(another head)' alternatively 
//time -O(n/2) find mid + O(n/2) reverse list + O(n) merge list = O(n)
//sc - O(1)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null)
        {
            if(fast.next.next == null)
            {
                fast = fast.next;
            }
            else
            {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        //slow is the middle point
        reversetheList(slow.next);
        slow.next = null;

        //head1 = head, head2 = fast
        //mergeLists2(head, fast); // this is two pointer method
        mergeLists1(head, fast); // this is one pointer method, slightly efficient compared to method2

    }
    private void reversetheList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;

        while(fast != null)
        {
            curr.next = prev;
            prev = curr;
            curr =fast;
            fast = fast.next;
        }
        curr.next = prev;
    }

    private void mergeLists1(ListNode head, ListNode headB)
    {
        ListNode headA = head;
        ListNode temp1 = headA.next;
        
        while(headA != null && headB != null)
        {
            headA.next = headB;
            headB = headB.next;
            headA.next.next = temp1;
            headA = temp1;
            if(temp1 != null)
            {
                temp1 = temp1.next;
            }
        }
    }
    private void mergeLists2(ListNode head, ListNode headB)
    {

        ListNode headA = head;
        ListNode temp1 = headA.next;
        ListNode temp2 = headB.next;
        
        while(headA != null && headB != null)
        {
            headA.next = headB;
            headA = temp1;
            if(temp1 != null)
            {
                temp1 = temp1.next;
            }
            headB.next = headA;
            headB = temp2;
            if(temp2 != null)
            {
                temp2 = temp2.next;
            }
            
        }        
    }
}