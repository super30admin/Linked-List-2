// Time Complexity :O(m+n) where m is length of first linked list and n is of second's
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//first, we'll find length of both linked lists , then we'll start our pointers, pointer of smaller LL will be at head,
// pointer of longer LL will start from diff of length steps ahead then we'll inc both pointers and those pointers will point
//to common node at same time, we'll find common node and will return the same
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode ptr = headA;

        while (ptr != null) {
            ptr = ptr.next;
            lengthA++;
        }
        ptr = headB;

        while (ptr != null) {
            ptr = ptr.next;
            lengthB++;
        }
        if (lengthA >= lengthB) {
            int count = lengthA - lengthB;
            while (count > 0) {
                headA = headA.next;
                count--;
            }
        } else {
            int count = lengthB - lengthA;
            while (count > 0) {
                headB = headB.next;
                count--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}