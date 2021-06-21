//TC O(N)
// SC O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        int lengthA = 0;
        int lengthB = 0;

		//calculate length of list A
        while(tempA != null) {
            tempA = tempA.next;
            lengthA++;
        }
		
		//calculate length of list B
        while(tempB != null) {
            tempB = tempB.next;
            lengthB++;
        }
		
		//if len of listA is greater move till they are of equal len
        while(lengthA>lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while(lengthB>lengthA) {
            headB = headB.next;
            lengthB--;
        }
		
		//if both pointers point to same node, return one of the nodes
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headB;
    }
}