// Time Complexity :
O(m+n) where m and n are length of both lists
// Space Complexity :
O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

Approach 1:
/* 1. Take a hash set 
2. Traverse through first List and place all elemnts in it in hash set
3.Traverse through second List and check if the element is already present in set

Time Complexity : O(m+n) where m and n are length of both lists
Space complexity: O(m) length of first list
*/

Approach 2:

/*We have two lists that have same part, so we cut down extra part and 
then we can get the intersection of the two lists and first common part we see 
is the intersection point
*/

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
        ListNode first = headA;
        ListNode second = headB;
        
        while(first != second){
            first = (first == null) ? headB : first.next ;
            second = (second == null) ? headA : second.next ;
        }
        return first;
    }
}