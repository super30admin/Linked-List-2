//Time Complexity: O(M+N) where M and N are lengths of listA and listB
//Space Complexity: O(1)

//Successfully runs on leetcode: 0 ms

//Approach: We first find the lengths of both the linked lists and find the difference between their lengths. We keep a pointer
//each to the head of shorter and long list but we move the pointer on longer list by the position equal to the difference
//in lengths. Now both the pointers will be equidistant from the intersecting node and we move both the pointers one step
//till we reach the intersecting node and return the head. 

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
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = 0;
        int lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null)
        {
            lenA++;
            tempA = tempA.next;
        }
        
        while(tempB != null)
        {
            lenB++;
            tempB = tempB.next;
        }
        
        while(lenA > lenB)
        {
            headA = headA.next;
            lenA--;
        }
        
        while(lenB > lenA)
        {
            headB = headB.next;
            lenB--;
        }
        
        tempA = headA;
        tempB = headB;
        
        while(tempA != tempB)
        {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        
        return tempA;
    }
}