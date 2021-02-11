// Time Complexity :O(M+N) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No



public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptA = headA;
        ListNode ptB = headB;
        int sizeA =0;
        int sizeB =0;
        while(ptA!=null){
            sizeA++;
            ptA=ptA.next;
        }
        while(ptB!=null){
            sizeB++;
            ptB=ptB.next;
        }
        ptB=headB;
        ptA=headA;
        //System.out.println(sizeA+" "+sizeB);
        if(sizeB>sizeA){
            while(sizeB!=sizeA){
                sizeB--;
                ptB=ptB.next;
            }
        }
        else{
            while(sizeB!=sizeA){
                sizeA--;
                ptA=ptA.next;
            }
        }
        while(ptA!=null && ptB!=null){
            if(ptA==ptB)
                return ptA;
            ptA=ptA.next;
            ptB=ptB.next;
        }
        return null;
    }
} 
