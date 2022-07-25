// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) return null;
    //using length to bring them to equal distance from end of the Linked lists
    int lenA=0,lenB=0;
    
    ListNode curr = headA;
    //calculating length of LL1
    while(curr != null){
        curr=curr.next;
        lenA++;
    }
    //calculating length of LL2
    curr=headB;
    while(curr != null){
        curr=curr.next;
        lenB++;
    }
    //if lenA > lenB, then move headA
    while(lenA > lenB){
        headA = headA.next;
        lenA--;
    }
    // if lenB > lenA then move headB
    while(lenB > lenA){
        headB=headB.next;
        lenB--;
    }
    //now, when they are at equal length, iterate them. if they are equal then return, if not they will iterate till both becomes null and equal
    while(headA != headB){
        headA = headA.next;
        headB = headB.next;
    }
    
    return headA;
}