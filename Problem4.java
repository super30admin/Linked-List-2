public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }

        int lenA=0;
        ListNode currA = headA;
        while(currA!=null){
            lenA++;
            currA = currA.next;
        }
    
        int lenB = 0;
        ListNode currB = headB;
        while(currB!=null){
            lenB++;
            currB = currB.next;
        }

        currA = headA;
        currB = headB;
        while(lenA > lenB)
        {
            currA = currA.next;
            lenA--;
        }

        while(lenB > lenA)
        {
            currB = currB.next;
            lenB--;
        }

        while(currA!=currB){
            currA = currA.next;
            currB = currB.next;
        }return currA;
    }
}
