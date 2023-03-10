public class Intersection2LL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        while(curr!=null){
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while(curr!=null){
            lenB++;
            curr = curr.next;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}

// TC - O(m+n)
// SC - O(1)
