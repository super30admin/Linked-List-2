public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode current = headA;
       while(current!=null){
           current=current.next;
           lenA++;
       }
        current=headB;
        while(current!=null){
            current=current.next;
            lenB++;
        }
        if(lenA>lenB){
            int n = lenA - lenB;
            while(n>0){
                headA=headA.next;
                n--;
            }
        }else{
            int n = lenB-lenA;
            while(n>0){
                headB=headB.next;
                n--;
            }
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}