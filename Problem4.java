// Time Complexity : O(n) traverses through all nodes of list
// Space Complexity : O(1) not using any additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem4 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null){
            return null;
        }

        int countA = 0;
        int countB = 0;

        ListNode currA = headA;
        ListNode currB = headB;

        while(currA.next != null){
            currA = currA.next;
            countA++;
        }

        while(currB.next != null){
            currB = currB.next;
            countB++;
        }

        currA = headA;
        currB = headB;

        while(countB > countA){
            countB--;
            currB = currB.next;
        }

        while(countA > countB){
            countA--;
            currA = currA.next;
        }

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }
}
