package Linked-List-2;

public class problem4 {
    // Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) return null;
    
    int lenA = 0;
    int lenB = 0;
    ListNode curr = headA;
    //1. Calculate length of A and B
    while(curr != null){
        curr = curr.next;
        lenA++;
    }
    
    curr = headB;
    while(curr != null){
        curr = curr.next;
        lenB++;
    }
    
    //2. Put heads at same length
    while(lenA > lenB){
        headA = headA.next;
        lenA--;
    }
    while(lenB > lenA){
        headB = headB.next;
        lenB--;
    }
    
    //3. Find intersection
    
    while(headA != headB){
        headA = headA.next;
        headB = headB.next;
    }
    
    return headA;
}
}
