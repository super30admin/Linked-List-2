class Solution {
    public void reorderList(ListNode head) {
        ListNode m = m(head);
        ListNode r = r(m.next);
        m.next = null;
        while(r!=null){
            ListNode rn = r.next;
            r.next = head.next;
            head.next = r;
            r = rn;
            head = head.next.next;
            
        }}
        
        private ListNode r(ListNode head){
            ListNode p = null;
            ListNode c = head;
            while(c!=null){
                ListNode n = c.next;
                c.next = p;
                p = c;
                c = n;
                
            }
            return p;
        }
        private ListNode m(ListNode x){
            ListNode s = x;
            ListNode f = x;
            while(f.next!=null && f.next.next!=null){
                s=s.next;
                f=f.next.next;
            }
            return s;
        }
    }
//tc=O(n)
//sc=O(1)
