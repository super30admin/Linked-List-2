/*
Time Complexity : O(2(m+n)) => O(m+n)
First Pass:

Each pointer (currA and currB) traverses its respective list (List A and List B).
At the end of the first pass, if a pointer reaches the end of its list, it switches to the head of the other list.
This ensures both pointers traverse the full lengths of both lists.
Second Pass:

After switching, the pointers traverse the remaining portion of the other list.
Since both pointers now start at equivalent distances from the end, they meet either at the intersection node or at
null (if no intersection exists).

 Space Complexity : O(1)

 Did this code successfully run on Leetcode: Yes
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionTwoPointersWithoutLengthCal
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        //Trying to find out the linkedlists meet, else it will traverse till end
        while(currA != currB)
        {
            if(currA == null) {
                currA = headB;
            }
            else {
                currA = currA.next;
            }

            if(currB == null) {
                currB = headA;
            }
            else {
                currB = currB.next;
            }

        }

        return currA;
    }
}