public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1 = 0;
        int c2 = 0;
        int d = 0;
        ListNode ca = headA;
        ListNode cb = headB;
        
        while(ca!= null){
            ca = ca.next;
            ++c1;
        }
        while(cb!= null){
            cb = cb.next;
            ++c2;
        }
        ca = headA;
        cb = headB;
        if (c2>c1){
            d = c2-c1;
            int q = 0;
            while(q != d){
                cb = cb.next;
                ++q;      
            }
        }
        if (c2<=c1){
            d = c1-c2;
            int q = 0;
            while(q != d){
                ca = ca.next;
                ++q;      
            }}
            while(ca!=cb){
                if(ca == null || cb == null ){
                    return null;
                }
                ca = ca.next;
                cb = cb.next;
                
                
            }
            return cb;
        }
    }


//tc=O(n)
//sc=O(n)
