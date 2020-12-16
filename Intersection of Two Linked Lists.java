/*
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None
        
        lenA, lenB = 0, 0
        cur = headA
        while cur is not None:
            lenA += 1
            cur = cur.next
            
        cur = headB
        while cur is not None:
            lenB += 1
            cur = cur.next
        
        curB = headB   
        while lenA < lenB:
            curB = curB.next
            lenB -= 1
        
        curA = headA  
        while lenB < lenA:
            curA = curA.next
            lenA -= 1
        
        while curA != curB:
            curA = curA.next
            curB = curB.next
        return curA
*/

// Time Complexity : O(max(m,n)) where m and n i size of two lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I calculated the size of both lists and then travelled the longer list
// till the point both lists are equal and finally travelled both simultaneously

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        
        ListNode cur = headA;
        int lenA = 0, lenB = 0;
        while (cur != null){
            lenA ++;
            cur = cur.next;
        }
        
        cur = headB;
        while (cur != null){
            lenB ++;
            cur = cur.next;
        }
        
        ListNode curA = headA;
        while (lenB < lenA){
            curA = curA.next;
            lenA--;
        }
        
        ListNode curB = headB;
        while (lenA < lenB){
            curB = curB.next;
            lenB--;
        }
        
        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        
        return curA;
        
    }
}