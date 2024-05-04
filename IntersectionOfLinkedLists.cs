// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
	// 1) Get length of both linked list
	// 2) Then whiciver is greater length, iterate over 
	// 	a. Length of greatger - length of smaller
	// 	b. Then iterate both until both reach to intersection
	// 	c. Return result

public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        
    if(headA == null || headB == null)
        return null;
    
    int lenA = 0;
    int lenB = 0;
    var curr = headA;
    
    //calculate headA length
    while(curr != null)
    {
        lenA++;
        curr = curr.next;
    }
    //calculate headB length        
    curr = headB;
    while(curr != null)
    {
        lenB++;
        curr = curr.next;
    }
    
    //if lenA is greater than lenb , then make head A small
    while(lenA > lenB)
    {
        lenA--;
        headA = headA.next;
    }
    
    //if lenb is greater than lenA , then make head B small
    while(lenB > lenA)
    {
        lenB--;
        headB = headB.next;
    }
    
    //now iterate over to find intersecting element
    while(headA != headB)
    {
        headA = headA.next;
        headB = headB.next;
    }
    
    return headA;
}