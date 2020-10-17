/**
 * The time complexity is O(m+n) and the space complexity is O(1).
 *
 * We first count the number of nodes in each linked list. Then we move difference of length steps from the head of longest linked list.
 * Then we move each step of both the lists until we find the common node.
 *
 * Yes, the code passed all the test cases in leet code.
 *
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

        if(headA==null || headB==null){return null;}

        int firstCount = 1; int secondCount = 1; ListNode tempA = headA; ListNode tempB = headB;

        while(tempB.next!=null && tempA.next!=null){
            firstCount++;
            secondCount++; tempB = tempB.next; tempA = tempA.next;
        }

        if(tempA.next!=null){
            while(tempA.next!=null){firstCount++;tempA = tempA.next;}
        }

        if(tempB.next!=null){
            while(tempB.next!=null){secondCount++;tempB = tempB.next;}
        }

        if(firstCount>secondCount){
            while(firstCount!=secondCount){headA = headA.next;firstCount--;}
        }
        else if(secondCount>firstCount){
            while(firstCount!=secondCount){headB = headB.next;secondCount--;}
        }

        while(headA!=headB){
            headA = headA.next; headB = headB.next;
        }

        return headA;
    }
}