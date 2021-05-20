//Time Complexity : O(m+n).m and n are the length of the two linked list
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null){
            return null;//no intersection
        }
        int lenA=0,lenB=0;
        ListNode curA=headA, curB=headB;
        //get the lengths of listA nad listB
        while(curA!=null){
            lenA++;
            curA=curA.next;
        }
        while(curB!=null){
            lenB++;
            curB=curB.next;
        }
        //get the headA and headB point at same index
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        //NOW MOVE BOTH THE HEADS TOGETHER UNTIL THEY MEET
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}