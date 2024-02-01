// Time Complexity : O(2n) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// To find the intersection point of two linked lists, first, determine the lengths of both lists.
// Then, adjust the starting points of the lists so they have an equal number of nodes remaining.
// After aligning the starting points, iterate through both lists simultaneously until you find
// a common node. That node is the intersection point.
public class Problem4 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

                int lenA = 0;
                int lenB = 0;
                ListNode curr = headA;
                while(curr!=null){
                        curr = curr.next;
                        lenA++;
                }

                curr = headB;
                while(curr!=null){
                        curr = curr.next;
                        lenB++;
                }

                while(lenA>lenB){
                        headA= headA.next;
                        lenA--;
                }

                while(lenB>lenA){
                        headB= headB.next;
                        lenB--;
                }

                while(headA!=headB){
                        headA= headA.next;
                        headB= headB.next;
                }

                return headA;

        }
}