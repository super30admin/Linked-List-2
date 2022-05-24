public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode h1 = headA, h2 = headB;
        
        while(h1!=h2){
            if(h1==null){
                h1=headB;
            }
            else{
                h1=h1.next;
            }
            if(h2==null){
                h2=headA;
            }
            else{
                h2=h2.next;
            }
        }
        return h1;
    }
}
