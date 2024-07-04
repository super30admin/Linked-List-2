/**

    L.C: 160. Intersection of Two Linked Lists

    Approach: Linked List Traversal


    Working:
        find the length LL A and B

        move the head o LL A Or B to the starting point where
        both list traversal length  will be same lenA = lenB

        check if LL A node NOT EQUAL LL B node
            move next node

        return LL A node

    Time Complexity: O(m+n)
    Space Complexity: O(1)

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
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        if(headA == null || headB == null) {
            return null;
        }


        //get the length of both list
        int lenA = getLength(headA);  //O(m)
        int lenB = getLength(headB);  //O(n)

        //make the traversal length equal for both list to find out the intersecion

        while(lenB>lenA) {
            headB = headB.next;
            lenB--;
        }

        while(lenA>lenB) {
            headA = headA.next;
            lenA--;
        }

        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }

    private int getLength(ListNode head) {

        ListNode curr = head;
        int len = 0;

        while(curr!=null) {
            curr = curr.next;
            len++;
        }

        return len;
    }
}