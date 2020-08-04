//time complexity: O(n) where n is the number of nodes of a linked list
//space complexity: O(1)
//executed on leetcode: yes
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
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0;
        int lenB = 0;
        while(tempA!=null)
        {
            lenA++;
            tempA = tempA.next;
        }
        while(tempB!=null)
        {
            lenB++;
            tempB = tempB.next;
        }
        int diff = 0;
        if(lenA>lenB)  //finding difference of length between two linked lists, if listA is larger, we need to move head pointer of A to a point such that on traversing through both lists starting with original headB and new headA, we will reach a point where both nodes are equal
        {
            diff = lenA-lenB;
            while(diff!=0)
            {
                headA=headA.next;
                diff--;
            }
        }
        else
        {
            diff = lenB-lenA;
            while(diff!=0)
            {
                headB=headB.next;
                diff--;
            }
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}