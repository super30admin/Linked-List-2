// Time - O(M+N)
// Space - O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) {
            return null;
        }
        
        int lengthA = 0, lengthB = 0;
        ListNode curr = headA;
        while(curr!=null) {
            curr = curr.next;
            lengthA++;
        }
        curr = headB;
        while(curr!=null) {
            curr = curr.next;
            lengthB++;
        }
        
        while(lengthA > lengthB) {
            lengthA--;
            headA = headA.next;
        }
        
        while(lengthA < lengthB) {
            lengthB--;
            headB = headB.next;
        }
        
        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}
