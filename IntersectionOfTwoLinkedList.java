/**
 * Time Complexity - O(M + N)
 * Space Complexity - O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lenA=headA;
        int countlenA=0;
        ListNode lenB=headB;
        int countlenB=0;
        while(lenA!=null)
        {
            countlenA++;
            lenA=lenA.next;
        }
        while(lenB!=null)
        {
            countlenB++;
            lenB=lenB.next;
        }
        lenA=headA;
        lenB=headB;
        while(countlenA>countlenB)
        {
            lenA=lenA.next;
            countlenA--;

        }
        while(countlenB>countlenA)
        {
            lenB=lenB.next;
            countlenB--;
        }
        while(lenA!=null || lenB!=null)
        {
            if(lenA==lenB)
            {
                return lenA;
            }
            lenA=lenA.next;
            lenB=lenB.next;
        }
        return null;
    }
}