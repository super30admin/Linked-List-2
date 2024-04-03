# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import ListNode, Optional
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        lenA = 0
        lenB = 0
        curr = headA
        while(curr != None):
            lenA+=1
            curr = curr.next
        
        curr = headB
        while(curr != None):
            lenB+=1
            curr = curr.next
        
        while(lenA > lenB):
            headA = headA.next
            lenA-=1
        
        while(lenB > lenA):
            headB = headB.next
            lenB-=1
        
        while(headA != headB):
            headA = headA.next
            headB = headB.next

        return headB