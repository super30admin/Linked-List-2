// Time Complexity : O(length of LL1 + length of LL2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Solution 1 : The idea here is to either store all nodes on set, then iterate other LL and check if set contains the node.
// Solution 2 : Get the lengthof both LL and get the difference of both, then move d (difference) nodes ahead in longer LL and then start iterating both LL, we will get the intersection point

public  class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        // it means they have atleast 1 node
        int lengthA = 1;
        int lengthB = 1;

        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != null) {
            tempA = tempA.next;
            lengthA++;
        }

        while(tempB != null) {
            tempB = tempB.next;
            lengthB++;
        }

        int diff = 0;
        // A is longer
        if(lengthA > lengthB){
            diff = lengthA - lengthB;
            while(diff > 0){
                headA = headA.next;
                diff--;
            }
        } else if(lengthB > lengthA){
            // B is longer
            diff = lengthB - lengthA;
            while(diff > 0){
                headB = headB.next;
                diff--;
            }
        } else {
            // both are equal
            diff = 0;
        }

        // iterate until we find intersection point
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}