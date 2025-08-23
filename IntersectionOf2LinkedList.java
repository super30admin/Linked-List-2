// Time Complexity : O(m+n) where m and n are the lengths of the two linked lists
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Displace the pointers such that both are equal distance from the intersection point. That is, advance the pointer of the longer list by the difference in lengths so that both pointers have the same number of nodes to traverse until the end. If no intersection are found, both reach end and return null, If found intersection is returned.

public class IntersectionOf2LinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA =0; int lenB = 0;
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
        }

        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
