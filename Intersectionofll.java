// Time Complexity : O(n) where n is the length of the longer list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    NO


// Your code here along with comments explaining your approach
// We are given two linked lists and we have to find the intersection point of the two linked lists.
// We will first calculate the lengths of both linked lists and then align them by moving the pointer of the longer list ahead by the difference in lengths. 
// After that, we will move both pointers together until they meet at the intersection point or reach the end of the lists. 
// If they meet, we return the intersection node, otherwise we return null.
// We are using two pointers to traverse the linked lists.
// We are using a while loop to traverse the linked lists until we find the intersection point or reach the end of the lists.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int countA = 0, countB = 0;

        ListNode currA = headA;
        ListNode currB = headB;

        // correct length calculation
        while (currA != null) {
            countA++;
            currA = currA.next;
        }

        while (currB != null) {
            countB++;
            currB = currB.next;
        }

        currA = headA;
        currB = headB;

        // align both lists
        while (countA > countB) {
            currA = currA.next;
            countA--;
        }

        while (countB > countA) {
            currB = currB.next;
            countB--;
        }

        // move together
        while (currA != null && currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }
}