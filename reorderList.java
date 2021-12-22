// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
/* Approach - firstly we divide the list into two halves; first list contains one extra element if  the total no. of elements given are odd in no.
for this we will use slow pointing to head and fast pointing to head.next pointers. so, at the 2nd list would start from slow.next
next, we have to reverse the second list using 3 pointer approach and then we need to reorder the elements using pointers(dummy,slow,curr)*/


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
        if(head==null||head.next==null)
            return;
        ListNode s=head;
        ListNode f=head.next;
        while(f!=null && f.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        ListNode curr=s.next;
        s.next=null;

        s=null;
        f=curr.next;
        while(f!=null){
            curr.next=s;
            s=curr;
            curr=f;
            f=f.next;
        }
        curr.next=s;

        s=head;
        ListNode dummy=head.next;
        while(curr!=null){
            s.next=curr;
            curr=curr.next;
            s.next.next=dummy;
            s=dummy;
            if(dummy==null)
                break;
                dummy=dummy.next;
        }

    }
}