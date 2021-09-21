//Time complexity: O(N)
//Space complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        int lengthA = 0;
        while(currentA != null) {
            currentA = currentA.next;
            lengthA++;
        }
        ListNode currentB = headB;
        int lengthB = 0;
        while(currentB != null) {
            currentB = currentB.next;
            lengthB++;
        }
        while(lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while(lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }
        while(headA != headB) {
            headB = headB.next;
            headA = headA.next;
        }
        return headA;
    }
}