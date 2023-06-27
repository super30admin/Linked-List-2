// Time Complexity : O(n)
// Space Complexity : O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode Apointer=headA;
        ListNode Bpointer=headB;
        int Acount=0;
        int Bcount=0;

        while(Apointer!=null)
        {
            Acount++;
            Apointer=Apointer.next;
        }
        while(Bpointer!=null)
        {
            Bcount++;
            Bpointer=Bpointer.next;
        }

        Apointer=headA;
        Bpointer=headB;
        while(Bcount>Acount){
            Bpointer=Bpointer.next;
            Bcount--;
        }
        while(Acount>Bcount){
            Apointer=Apointer.next;
            Acount--;
        }
        while(Apointer!=Bpointer){
            Apointer=Apointer.next;
            Bpointer=Bpointer.next;
        }
        return Apointer;
    }
}