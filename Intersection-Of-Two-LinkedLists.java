//time-O(n)
//space-O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        int lenA = 0, lenB = 0;
        ListNode currA = headA;
        ListNode currB = headB;

        while(currA!=null){
            currA = currA.next;
            lenA++;
        }

        while(currB!=null){
            currB = currB.next;
            lenB++;
        }

        currA = headA;
        currB = headB;

        while(lenA > lenB){
            currA = currA.next;
            lenA--;
        }

        while(lenB > lenA){
            currB = currB.next;
            lenB--;
        }

        while(currA!=null && currB!=null){
            if(currA==currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}