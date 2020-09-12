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
//TimeComplexity=O(n)
//Space Complexity=O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head==null)
        {
            return;
        }
       ListNode slowPointer=head;
       ListNode fastPointer=head;
       while(fastPointer!=null && fastPointer.next!=null)
       {
           slowPointer=slowPointer.next;
           fastPointer=fastPointer.next.next;
       }
        ListNode reversePointer=Reverse(slowPointer.next);
        slowPointer.next=null;
        slowPointer=head;
        ListNode temp1;
        ListNode temp2;
        while(reversePointer!=null)
        {
            temp1=slowPointer.next;
            slowPointer.next=reversePointer;
            temp2=reversePointer.next;
            reversePointer.next=temp1;
            slowPointer=temp1;
            reversePointer=temp2;
        }
        
    }
    private ListNode Reverse(ListNode slowPointer)
    {
        ListNode prev=null;
        ListNode next=null;
        ListNode cur=slowPointer;
        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    void print(ListNode cur)
    {
        while(cur!=null)
        {
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
    }
}