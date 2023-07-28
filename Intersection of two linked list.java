// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach
 //We will find out the length of both the lists and find the difference between them. Set the starting pointer for the longer list at the difference received. 
 //Then both the lists would be of the same length and would meet at the same point, if there is an intersection. If, not it would return null
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        ListNode curr=headA;

        //Calculating the length of ListA
        while(curr!=null)
        {
            curr=curr.next;
            lenA++;
        }

        int lenB=0;
        curr=headB;
        //Calculating the length of ListB
        while(curr!=null)
        {
            curr=curr.next;
            lenB++;
        }

//We will keep moving the head of the longer list until the length of both the lists become same

        //If Length of A>B
        while(lenA>lenB)
        {
            headA=headA.next;
            lenA--;
        }

        //If Length of B>A
        while(lenB>lenA)
        {
            headB=headB.next;
            lenB--;
        }

        //When the length is same, we need to keep moving the head, until their value is same. If the value is never same, then it means there is no intersection and it will return null

        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }

//Return either of the heads. If there is an intersection, it would return the value, otherwise it would have anyway iterated till the end of the list and it would return null
return headB;

    }
}