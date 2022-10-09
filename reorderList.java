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
        
        if(head==null || head .next==null) return;
        
        ListNode sp=head;
        ListNode fp=head;
        
        while(fp.next!=null && fp.next.next!=null )
        {
            sp=sp.next;
            fp=fp.next.next;
        }
        
        //sp=sp.next;
        System.out.println(sp.val);
        
        fp=reverse(sp.next);
        sp.next=null;
        
        sp=head;
        ListNode temp=sp.next;
        
        while(fp!=null )
        {
            
            sp.next=fp;
            fp=fp.next;
            sp.next.next=temp;
            sp=temp;
            if(temp!=null) temp=temp.next;
            
        }
        
    }
    
    public ListNode reverse(ListNode node)
    {
        ListNode prev=null;
        ListNode cur=node;
        ListNode nxt=cur.next;
        while(cur.next!=null)
        {
            cur.next=prev;
            prev=cur;
            cur=nxt;
            nxt=nxt.next;
        }
        if(node!=null)
            cur.next=prev;
        
        return cur;
        
    }
}

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
