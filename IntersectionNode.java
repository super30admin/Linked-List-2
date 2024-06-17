//Time Complexity - O(n)
 //Space Complexity - O(1)
 public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode curr = headA;
        int lenA = 1;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        int lenB = 1;
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }



       return headA; 
    }
}