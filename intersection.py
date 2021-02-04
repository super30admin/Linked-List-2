# Time Complexity : O(m+n) 
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Find the length of the lists and find the diff between the lengths.
#            Skip the nodes from the longer list until the two heads align.Return any of the heads.

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        
        lenA, lenB = 0, 0
        curr = headA
        
        while curr!= None:
            lenA+=1
            curr = curr.next
        
        curr = headB
        while curr!= None:
            lenB+=1
            curr = curr.next
            
        while lenA>lenB:
            headA = headA.next
            lenA-=1
        
        while lenB > lenA:
            headB = headB.next
            lenB-=1
            
        while headA!=headB:
            headA = headA.next
            headB = headB.next
            
        return headA