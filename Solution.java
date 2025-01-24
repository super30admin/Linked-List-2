public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int lenA = 0;
        ListNode curr = headA;
        while(curr != null){
            lenA++;
            curr = curr.next;
        }
        int lenB = 0;
        curr = headB;
        while(curr != null){
            lenB++;
            curr = curr.next;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while(lenA > lenB){
            currA = currA.next;
            lenA--;
        }
        while(lenB > lenA){
            currB = currB.next;
            lenB--;
        }
        while(currA!=currB){
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
        
    }
}