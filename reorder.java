class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode sl=head;
        ListNode fp = head;
        ListNode prev=null;
        while(fp!=null && fp.next!=null){
            prev=sl;
            sl=sl.next;
            fp=fp.next.next;
        }
        
        if(fp!=null){
            prev=sl;
            sl=sl.next;
        }
        prev.next=null;
        fp = reverse(sl);
        sl=head;
        prev=sl.next;

        while(prev!=null){
            sl.next=fp;
            fp=fp.next;
            sl.next.next=prev;
            sl=prev;
            prev=prev.next;
        }
        
        if(fp!=null){
            sl.next=fp;
        }

    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr=head;
        ListNode nxt=head.next;

        while(nxt!=null){
            curr.next=prev;
            prev=curr;
            curr=nxt;
            nxt=nxt.next;
        }
        curr.next=prev;
        return curr;
    }
}
