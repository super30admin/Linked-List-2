// Time Complexity : O(n) .
// Space Complexity : O(1) no extra space used.
// Any problem you faced while coding this :


// So first we get the size of listA and listB, then we reduce the gap between listA and listB. tje we loop until headA and headB are same reference. 

//Success
//Details 
//Runtime: 1 ms, faster than 97.52% of Java online submissions for Intersection of Two Linked Lists.
//Memory Usage: 42.1 MB, less than 5.71% of Java online submissions for Intersection of Two Linked Lists.
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeHeadA=0; 
        int sizeHeadB=0;
        ListNode curr=headA;
       while(curr!=null){
           sizeHeadA++;
           curr=curr.next;
       }
        curr=headB;
       while (curr!=null){
           sizeHeadB++;
           curr=curr.next;
       } 
        while (sizeHeadA>sizeHeadB){
            headA=headA.next;
            sizeHeadA--;
        }
        while (sizeHeadB>sizeHeadA){
            headB=headB.next;
            sizeHeadB--;
        }
        while (headA!=null && headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

}