public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA=headA;
        ListNode currB=headB;
        int  lenA=0,lenB=0;
        while(currA!=null){
            lenA++;
            currA=currA.next;
        }

        while(currB!=null){
            lenB++;
            currB= currB.next;
        }
        currA=headA;
        currB=headB;
        while(lenA<lenB){
            currB=currB.next;
            lenB--;
        }

        while(lenA>lenB){
            currA=currA.next;
            lenA--;
        }

        while(currB!=null){
            if(currB==currA) break;
            currB=currB.next;
            currA=currA.next;
        }
        return currB;
    }
}
