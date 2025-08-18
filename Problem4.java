// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA=headA,currB=headB;
        int countA=0,countB=0;

        //find lengths of both linked lists
        while(currA!=null){
            countA++;
            currA=currA.next;
        }
        while(currB!=null){
            countB++;
            currB=currB.next;
        }
        currA=headA;
        currB=headB;

        //move the pointer of the longer list ahead by the difference in lengths
        while(countA>countB){  
            currA=currA.next;
            countA--;
        }
        while(countB>countA){  
            currB=currB.next;
            countB--;
        }

        //move both pointers until they collide
        while(currA!=currB){
            currA=currA.next;
            currB=currB.next;
        }
        return currA;

    }
}