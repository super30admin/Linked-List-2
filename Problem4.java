//Accepted on LT
// The idea is to move the starting point to same index and slide window to get the intersecting node
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int l1 = 0;
        int l2 = 0;
        ListNode crr = headA;
        ListNode crr2 = headB;
        while(crr!=null){
            l1++;
            crr = crr.next;
        }
        while(crr2!=null){
            l2++;
            crr2= crr2.next;
        }
        ListNode cr = headA;
        ListNode cr2 = headB;
        if(l1>l2){
            int d = l1-l2;
            for(int i =0; i<d;i++){
                cr = cr.next;
            }
            while(cr!=cr2){
                cr = cr.next;
                cr2 = cr2.next;
            }
            return cr;
        }
        else{
            int d = l2-l1;
            for(int i =0; i<d;i++){
                cr2 = cr2.next;
            }
            while(cr!=cr2){
                cr = cr.next;
                cr2 = cr2.next;
            }
            return cr;

        }
    }
}