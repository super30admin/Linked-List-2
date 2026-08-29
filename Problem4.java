

// Time complexity : Max length of two nodes
// Space complexity is O(1)
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

        ListNode  currA = headA;
        ListNode currB = headB;

        int countA = 0;
        int countB = 0;

        while(currA != null){
            currA = currA.next;
            countA++;
        }

           while(currB != null){
            currB = currB.next;
            countB++;
        }

        currA = headA; currB = headB;

        while(countA > countB){
            currA = currA.next;
            countA--;

        }

         while(countA < countB){
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
