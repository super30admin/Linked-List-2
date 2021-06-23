// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1. Find the length of both the linkedlists
2. Iterate as many times through the longer lists such that the difference between their length become 0
3. then iterate through both the list one at a time and whenever they come to the same node we get the intersection point


*/

public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=0;
        int lengthB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=null)
        {
            lengthA++;
            tempA=tempA.next;
        }
        while(tempB!=null)
        {
            lengthB++;
            tempB=tempB.next;
        }
         tempA=headA;
         tempB=headB;
        while(lengthA>lengthB)
        {
            tempA=tempA.next;
            lengthA--;
            
        }
        while(lengthB>lengthA)
        {
            tempB=tempB.next;
            lengthB--;
            
        }
        while(tempA!=tempB)
        {
             tempA=tempA.next;
            tempB=tempB.next;
        }
        
        return tempA;
    }
}
