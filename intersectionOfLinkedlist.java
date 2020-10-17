//Time complexity: O(n)
//Space Complexity: O(1)
//Tried on leetcode and accepted
//No of attempts: 2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        
        int lenA = 0;
        int lenB = 0;
        
        while(currA!=null)
        {
            lenA++;
            currA=currA.next;
        }
        while(currB!=null)
        {
            lenB++;
            currB=currB.next;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        if(lenA>lenB)
        {
            int diff = lenA-lenB;
            for(int i=0; i<diff; i++)
            {
                curA= curA.next;
            }
        }
        if(lenB>lenA)
        {
            int diff = lenB-lenA;
            for(int i=0; i<diff; i++)
            {
                curB= curB.next;
            }
        }
        while(curA!=null)
        {
            if(curA==curB)
            {
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}