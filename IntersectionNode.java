// Time Complexity : O(n)
// Space Complexity : O(1)

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
        ListNode temp = headA;
        int lengthA = 0;
        int lengthB = 0;
        while(temp != null){
            temp = temp.next;
            lengthA++;
        }
        temp = headB;
        while(temp != null){
            temp = temp.next;
            lengthB++;
        }
        while(lengthA > lengthB){
            headA = headA.next;
            lengthA--;
        }
        while(lengthB > lengthA){
            headB = headB.next;
            lengthB--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}