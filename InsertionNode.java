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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;

        ListNode currA = headA, currB = headB;

        while(currA != null){
            countA++;
            currA = currA.next;
        }

        while(currB != null){
            countB++;
            currB = currB.next;
        }

        currA = headA; currB = headB;

        while(countA > countB){
            currA = currA.next;
            countA--;
        }

        while(countB > countA){
            currB = currB.next;
            countB--;
        }

        while(currA != currB){
            currA = currA.next;
            currB = currB.next;
        }

        return currA;

    }
}

Time Complexity : O(m+n)
Space Complexity : O(1)