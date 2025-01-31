// Time Complexity  :  O(n)
// Space Complexity :  O(1)

public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0;
        ListNode curr = headA;
        while(curr!=null){
            curr = curr.next;
            lenA++;
        }
        int lenB = 0;
        curr = headB;
        while(curr!=null){
            curr = curr.next;
            lenB++;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while(lenA>lenB){
            currA = currA.next;
            lenA--;
        }
        while(lenB>lenA){
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