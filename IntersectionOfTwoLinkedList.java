// Time Complexity - O(n) + O(n) = O(n) // as we traverse both lists to find length
// Space Complexity - O(1) as no extra space used
// Approach - Find the length of both lists.
// Then move the head of the longer list to the node from where both the lists will have equal length
// Now simultaneously move head pointer for both lists by one and return the point where they are equal i.e. meet 
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
        int lenA = 0;
        while(temp!=null){
            temp = temp.next;
            lenA++;
        }
        temp = headB;
        int lenB = 0;
        while(temp!=null){
            temp = temp.next;
            lenB++;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}