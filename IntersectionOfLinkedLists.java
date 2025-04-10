// SC: O(1)
// TC:- O(m+n)  + O(m+n)  = O(n)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA=0, countB=0;

        ListNode currA = headA, currB = headB;

        // Get the length of both the lists
        while(currA !=null ){
            countA++;
            currA = currA.next;
        }

        while(currB !=null ){
            countB++;
            currB = currB.next;
        }

        currA = headA; currB = headB;

        // Either of the below 2 while's will run. If countA is bigger, then, we move the currA pointers countA spaces so that curra and currB can start at the same point.
        while(countA > countB) {
            currA = currA.next;
            countA--;
        }

        while(countB > countA) {
            currB = currB.next;
            countB--;
        }

        // Now see if they meet together. If they do not meet, then they will be at null and come out of the while loop with null.
        while(currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
        
    }
}