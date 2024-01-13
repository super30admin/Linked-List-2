/*
* Approach:
*  1. Maintain 2 pointers and keep iterating till the end of linkedlists
* 
*  2. If linkedlist end is reached bring the pointers to head of other linkedlist
        by updating the flag.
* 
*  3. if any of the pointers reaches the end and flag is set to true, 
        that means there is no intersection.
    if pointers meet at any place, return the node as intersection.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m+n)
    m - length of linkedlist1
    n - length of linkedlist2
* 
* Space Complexity: O(1)
* 
*/

public class IntersectionofLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA, ptr2 = headB;
        int flag = 0;

        while (true) {
            if (ptr1 == ptr2) {
                return ptr1;
            }

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

            if (ptr1 == null) {
                if (flag == 1)
                    break;
                flag = 1;
                ptr1 = headB;
            }

            if (ptr2 == null)
                ptr2 = headA;
        }

        return null;
    }
}
