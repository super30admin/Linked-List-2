// Time Complexity : O(m+n) where m and n is the length of the linked list
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Find the length of both linked lists
// 2. Move the pointer of the longer linked list to the same length as the shorter linked list
// 3. Move both pointers until they meet
// 4. Return the node where they meet
// 5. If they don't meet, return nulls
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
public class IntersectionOfLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // find length of both linked lists

        int lenA = 0, lenB = 0;

        ListNode currA = headA;
        ListNode currB = headB;

        while(currA != null){
            lenA++;
            currA = currA.next;
        }

        while(currB != null){
            lenB++;
            currB = currB.next;
        }

        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
