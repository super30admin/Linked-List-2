// Time Complexity : O(m+n) where m and n are lengths of the lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Find the length of the two lists
//increment the list which has greater size by the difference
//Loop till the list nodes becomes equal and return
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
        ListNode fir = headA;
        ListNode sec = headB;
        int lenA = len(headA);
        int lenB = len(headB);
        if(lenB > lenA){
            fir = headB;
            sec = headA;
        }
        int dif = Math.abs(lenA - lenB);
        while(dif != 0){
            dif--;
            fir = fir.next;
        }
        while(fir != sec){
            fir = fir.next;
            sec = sec.next;
        }
        return fir;
    }
    private int len(ListNode x){
        int size = 0;
        while(x != null){
            size++;
            x = x.next;
        }
        return size;
    }
}