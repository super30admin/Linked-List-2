//TimeComplexity O(n)
//SpaceComplexity O(1)
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null)
        {
            return headA;
        }
        if(headB==null){
            return headB;
        }
        int lenA=0;
        int lenB=0;
        
        ListNode curr=headA;
        //ListA length
        while(curr!=null){
            curr=curr.next;
            lenA++;
        }
        
        curr=headB;
        while(curr!=null){
            curr=curr.next;
            lenB++;
        }
        
        

        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        
        return headA;
    }
}
