// Time Complexity :O(M+N)
// Space Complexity :O(1)
//Did this code successfully run on Leetcode : YES
//Any problem you faced while coding this : None
public class Solution4 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        while(lenA < lenB){
            headB = headB.next;
            lenB--;
        }
        while(lenB < lenA){
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

