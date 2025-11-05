/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        int headALength = 0;
        ListNode tempA = headA;
        while(tempA!=null)
        {
            headALength++;
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        int headBLength = 0;
        while(tempB!=null)
        {
            headBLength++;
            tempB = tempB.next;
        }
        int diff = Math.Abs(headALength - headBLength);

        if (headALength > headBLength)
        {
    
            for (int i = 0; i < diff; i++) 
            {
                headA = headA.next;
            }
        }
        else
        {
            for (int i = 0; i < diff; i++)
            {
                headB = headB.next;
            }
        }
        while(headA!=null&&headB!=null)
        {
            if(headA==headB)
            {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        if(headA == null)
        {
            return null;
        }
        return headA;
        
    }
}