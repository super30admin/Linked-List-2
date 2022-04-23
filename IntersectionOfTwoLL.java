// Time Complexity : O(N+M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach


/*

We find out length of both LLs. Once the length is found, we try to make the length 
of both the LL same by traversing the head of greater LL till it is equal to  second LL.

Once it is equal, we try to move both the heads by one step each, till we come through common 
linked list node. 

*/

public class IntersectionOfTwoLL {
    

    public static ListNode getIntersectionNode(ListNode headA,ListNode headB)
    {
        if(headA == null || headB == null ) return null;

        int lenA = 0,lenB = 0;

        ListNode temp = headA;

        while(temp!=null)
        {
            lenA++;
            temp = temp.next;
        }

        temp = headB;

        while(temp!=null)
        {
            lenB++;
            temp = temp.next;
        }

        while(lenA>lenB)
        {
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA)
        {
            lenB--;
            headB=headB.next;
        }


        while(headA!=headB)
        {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
