// Time Complexity : O(Max(N,M)), where N and M are the lengths of list A and B
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach :
// Since both the lists can be of different length, we cant compare them as they are. We need to identify the length of each list.
// Whichever list is longer we need to move its head such that length of both lists is same. We start comparing each node from
// the 2 lists, if they are equal return the node, else null.
public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        while(lenA > lenB){
            //Move listA head if it is longer
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA){
            // Move listB head if it is longer
            headB = headB.next;
            lenB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getLength(ListNode head){
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}



