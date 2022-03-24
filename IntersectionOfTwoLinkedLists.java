//Time Complexity O(M+N)
//Space Complexity O(1)
//Leetcode tested
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode curr = headA;
        while (curr!=null){
            curr=curr.next;
            lenA++;
        }
        curr = headB;
        while (curr!=null){
            curr=curr.next;
            lenB++;
        }
        while (lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while (lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        while (headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
    }
}
