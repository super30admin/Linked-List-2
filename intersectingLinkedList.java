// Time Complexity : O(n) -> iterating over entire linkedList
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //basecase
        if(headA == null || headB == null){
            return null;
        }
        
        //find Length of list one
        int lenA = 0;
        ListNode currA = headA;
        while (currA != null){
            lenA++;
            currA = currA.next;
        }

        //find lenght of list two
        int lenB = 0;
        ListNode currB = headB;
        while (currB != null){
            lenB++;
            currB = currB.next;
        }

        //reset pointer and if length A > length B then move currentA until the length becomes equal
        currA = headA;
        while(lenA > lenB){
            currA = currA.next;
            lenA--;
        }

        //reset pointer and if length B > length A then move currentB until the length becomes equal
        currB = headB;
        while(lenB > lenA){
            currB = currB.next;
            lenB--;
        }

        //iterate until both become equal to find the intersecting node
        while(currB != currA){
            currB = currB.next;
            currA = currA.next;
        }

        //return the any node if both are equal
        if(currB == currA){
            return currB;
        }

        return null;
    }
}