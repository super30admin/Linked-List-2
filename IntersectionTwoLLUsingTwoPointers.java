/*
 Time Complexity : O(2(m+n)) => O(m+n)
 In the worst case, each list is traversed twice giving 2⋅M+2⋅N, which is equivalent to O(N+M). This is because
 the pointers firstly go down each list so that they can be "lined up" and then in the second iteration, the
 intersection node is searched for.

 Space Complexity : O(1)
 Did this code successfully run on Leetcode: Yes
 */
//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }

public class IntersectionTwoLLUsingTwoPointers {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode currA = headA;
        ListNode currB = headB;

        int lengthA = 0, lengthB = 0;

        //Finding the length of list1
        while(currA != null)
        {
            lengthA++;
            currA = currA.next;
        }

        //Finding the length of list2
        while(currB != null)
        {
            lengthB++;
            currB = currB.next;
        }

        //Pointing the current nodes back to respective head after finding the length
        currA = headA; currB = headB;

        //If LengthA is greater than LengthB, we will traverse the pointer in bigger list
        while(lengthA > lengthB)
        {
            currA = currA.next;
            lengthA--;
        }

        //If LengthB is greater than LengthA, we will traverse the pointer in bigger list
        while(lengthB > lengthA)
        {
            currB = currB.next;
            lengthB--;
        }

        //Trying to find out the linkedlists meet, else it will traverse till end and end up pointing to null
        while(currA != currB)
        {
            currA = currA.next;
            currB = currB.next;
        }

        return currA; // At this point currA and currB either point to their intersection or they point to null
    }
}