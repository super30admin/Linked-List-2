// Time Complexity : O(Max(M,N)). where M and N is the length of two linked lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Since, I don't know the length difference of linked lists, I will need to determine the length of both Linked lists.
// Once I know the length m and n of the list, I can keep two pointers, one at the beginning of each list. Two move them from
// the same distance in the lists, we should increment the pointer of list(that is longer) to a particular point. The starting point
// of that list should start from m-n, lets say k nodes from the beginning of list. Then we can increment both the pointers by one each time
// and check for equality.

public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA -= 1;
        }

        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB -= 1;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;

        }

        return headA;
    }


    int getLength(ListNode headA) {
        ListNode temp = headA;
        int len = 0;
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }
        return len;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
