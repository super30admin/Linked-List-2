// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// We first find the difference between the sizes of two lined list and then we will
// move the pointer from longest linked list till the difference of their sizes
// and then we can move the pointer from another list start and the pointer at current index by one 
//whenever they meet that would be the intersection

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
        int sizeA=0;
        int sizeB=0;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while(dummyA!=null){
            dummyA=dummyA.next;
            sizeA++;
        }
        while(dummyB!=null){
            dummyB=dummyB.next;
            sizeB++;
        }
        dummyA = headA;
        dummyB = headB;
        
        if(sizeA>sizeB){
            while(sizeA!=sizeB){
                sizeA--;
                dummyA = dummyA.next;
            }
        }else{
            while(sizeA!=sizeB){
                sizeB--;
                dummyB = dummyB.next;
            }
        }
        
        while(dummyA!=null&&dummyB!=null&&dummyA!=dummyB){
            dummyA=dummyA.next;
            dummyB=dummyB.next;
        }
        return dummyB;
    }
}