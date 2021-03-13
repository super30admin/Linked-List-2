// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        while(dummyA != null){
            dummyA = dummyA.next;
            sizeA++;}
        while(dummyB != null){
            dummyB = dummyB.next;
            sizeB++;}
         dummyA = headA;
         dummyB = headB;
        if(sizeA > sizeB){
            while(sizeA != sizeB){
                sizeA--;
                dummyA = dummyA.next;}
        }
        else{
            while(sizeA != sizeB){
                sizeB--;
                dummyB = dummyB.next;}
            }
        while(dummyA != null && dummyA != dummyB){
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }
        return dummyA;
    }
}