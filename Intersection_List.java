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
    //Time O(N)
    //Space O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int len_A = 0 , len_B = 0;
        while(curr != null)
        {
            curr = curr.next;
            len_A++;
        }
        curr = headB;
        while(curr != null)
        {
            curr = curr.next;
            len_B++;
        }
        ListNode currA = headA , currB = headB;
        while(len_A > len_B)
        {
            currA = currA.next;
            len_A--;
        }
        while(len_B > len_A)
        {
            currB = currB.next;
            len_B--;
        }
        while(currA != currB)
        {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}