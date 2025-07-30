// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : find no. of nodes 1 list is more than other and traverse that part. Now use two pointers to iterate through
/// both lists at the same time and return the first node that is same in both lists
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
        //find lengths
        int n1 = 0, n2 = 0;
        ListNode ptr1 = headA, ptr2 = headB;
        while(ptr1!=null){
            n1++;
            ptr1 = ptr1.next;
        }
        while(ptr2!= null){
            n2++;
            ptr2 = ptr2.next;
        }
        if(n1<n2){
            return getIntersectionNode(headB, headA);
        }
        //n1>n2
        ptr1 = headA;
        int diff = n1-n2;
        while(diff>0){
            ptr1 = ptr1.next;
            diff--;
        }
        ptr2 = headB;
        while(ptr1!=null && ptr2!=null){
            if(ptr1==ptr2){
                return ptr1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }
}