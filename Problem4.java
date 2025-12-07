// Time Complexity : O(n) + O(n) + O(n) ~ O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
First I counted the number of nodes in both lists.
Whichever is bigger, I moved my pointer till both the list size is the same.
Then I traversed one-by-one in both the lists till there are not equal which indicates that the intersection has been found
*/


public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cntA = 0;
        int cntB = 0;

        ListNode temp = headA;
        while(temp!=null) {
            cntA++;
            temp = temp.next;
        }

        temp = headB;
        while(temp!=null) {
            cntB++;
            temp = temp.next;
        }

        while(cntA > cntB) {
            headA = headA.next;
            cntA--;
        }

        while(cntB > cntA) {
            headB = headB.next;
            cntB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }
}
