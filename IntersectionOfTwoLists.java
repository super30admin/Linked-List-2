// Time complexity: O(n)
// space complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lengthA = 0;
        int lengthB = 0;

        ListNode currA = headA;
        ListNode currB = headB;

        while(currA!= null) {
            lengthA++;
            currA = currA.next;
        }

        while(currB!= null) {
            lengthB++;
            currB = currB.next;
        }


        while(lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while(lengthA < lengthB) {
            headB = headB.next;
            lengthB--;
        }

        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}