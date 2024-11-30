/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr!=null && curr.next!=null)
        {
            prev=prev.next;
            curr=curr.next.next;
        }
        curr=reverse(prev.next);
        prev.next=null;
        prev=head;
        ListNode tail=prev;
        while(curr!=null)
        {
            //System.out.println(prev.val+" "+curr.val);
            ListNode temp=prev.next;
            prev.next=curr;
            curr=curr.next;
            prev.next.next=temp;
            prev=temp;
        }
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;            
        }
        return prev;
    }
}

// Time Complexity: O(3n) ==> O(n)
// Space Complexity: O(1), no extra space used