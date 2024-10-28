public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA=headA;
        ListNode currB=headB;
        int countA=0;
        int countB=0;
        while(currA!=null){
            currA=currA.next;
            countA++;
        }
        
        while(currB!=null){
            currB=currB.next;
            countB++;
        }
        currA=headA;
        currB=headB;
        
        while(countA>countB){
            currA=currA.next;
            countA--;
        }
        while(countB>countA){
            currB=currB.next;
            countB--;
        }
        while(currA!=currB){
            currA=currA.next;
            currB=currB.next;
        }
        return currA;
    }
}